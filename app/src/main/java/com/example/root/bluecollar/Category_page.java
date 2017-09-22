package com.example.root.bluecollar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Category_page extends AppCompatActivity {
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

        mCardView=(CardView) findViewById(R.id.card_view);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data=new ArrayList<Category>();
        for(int i=0; i<=5; i++){
            data.add(new Category(MyData.categories[i]));
        }

           adapter=new CategoryAdapter(data);
           recyclerView.setAdapter(adapter);



    }
}
