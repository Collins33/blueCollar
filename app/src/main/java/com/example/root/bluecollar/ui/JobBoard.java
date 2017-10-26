package com.example.root.bluecollar.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.root.bluecollar.Constants;
import com.example.root.bluecollar.R;
import com.example.root.bluecollar.adapters.FirebaseJobListAdapter;
import com.example.root.bluecollar.adapters.FirebaseJobViewHolder;
import com.example.root.bluecollar.models.Job;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class JobBoard extends AppCompatActivity implements View.OnClickListener{
    private DatabaseReference ref;

    private FirebaseJobListAdapter mFirebaseAdapter;


    @Bind(R.id.jobBoard) RecyclerView mRecyclerView;
    @Bind(R.id.button5) Button sortCategories;
    private Spinner categorySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_board);
        //recyclerview in the layout
        ButterKnife.bind(this);
        sortCategories.setOnClickListener(this);
        addCategoryToSpinner();
        setUpFirebaseAdapter();
    }
    @Override
    public void onClick(View view){
        setUpSortedFirebaseAdapter();
    }
    public void addCategoryToSpinner(){
    categorySpinner=(Spinner) findViewById(R.id.categorySpinner);
        //arraylist with categories
        List<String> categories=new ArrayList<>();
        categories.add("CLEANING");
        categories.add("TRANSPORT");
        categories.add("LANDSCAPING");
        categories.add("DELIVERY");
        categories.add("COOKING");
        categories.add("HANDYMAN");
        //arrayadapter to add data to the spinner
       ArrayAdapter<String> spinnerAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,categories);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(spinnerAdapter);
    }
    private void setUpFirebaseAdapter(){

        ref= FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_JOB);

        mFirebaseAdapter = new FirebaseJobListAdapter(Job.class,
                R.layout.available_job, FirebaseJobViewHolder.class,
                ref, this);


        //set our adapter on our recyclerview
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }
    public void setUpSortedFirebaseAdapter(){
        String categories=String.valueOf(categorySpinner.getSelectedItem());
        ref=FirebaseDatabase.getInstance().getReference();
        Query query=ref.child("jobs").orderByChild("description").equalTo(categories);
        mFirebaseAdapter = new FirebaseJobListAdapter(Job.class,
                R.layout.available_job, FirebaseJobViewHolder.class,
                query, this);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }
}
