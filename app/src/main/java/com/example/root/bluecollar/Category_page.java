package com.example.root.bluecollar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.root.bluecollar.adapters.CategoryAdapter;
import com.example.root.bluecollar.models.Category;
import com.example.root.bluecollar.ui.JobBoard;
import com.example.root.bluecollar.ui.StartPage;
import com.example.root.bluecollar.ui.jobForm;
import com.google.firebase.auth.FirebaseAuth;

import org.aviran.cookiebar2.CookieBar;

import java.util.ArrayList;

public class Category_page extends AppCompatActivity implements View.OnClickListener{
    private CardView mCardView;
    private TextView mTextView;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<Category> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_page);
        CookieBar.Build(Category_page.this)
                .setTitle("WELCOME")
                .setMessage("CLICK CATEGORY TO ADD TASK")
                .show();

        mCardView=(CardView) findViewById(R.id.card_view);
        //mCardView.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data=new ArrayList<Category>();
        for(int i=0; i<=5; i++){
            data.add(new Category(MyData.categories[i],MyData.images[i]));
        }

           adapter=new CategoryAdapter(getApplicationContext(),data);
           recyclerView.setAdapter(adapter);

    }
    @Override
    public void onClick(View v){
        Intent intent=new Intent(getApplicationContext(),jobForm.class);
        startActivity(intent);
    }


    //inflate the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);

    }
    //instruct to do when a menu option is selected
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.logOut){
            logOut();
            return true;
        }

        if(id == R.id.jobsBoard){
            viewJobs();
            return true;
        }
        return false;
    }
    //log user out
    public void logOut(){
        FirebaseAuth.getInstance().signOut();
        Intent intent=new Intent(this, StartPage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
    public void viewJobs(){
        Intent intent=new Intent(getApplicationContext(),JobBoard.class);
        startActivity(intent);
    }
}
