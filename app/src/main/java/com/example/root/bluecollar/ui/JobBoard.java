package com.example.root.bluecollar.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

import butterknife.Bind;
import butterknife.ButterKnife;

public class JobBoard extends AppCompatActivity {
    private DatabaseReference ref;

    private FirebaseJobListAdapter mFirebaseAdapter;


    @Bind(R.id.jobBoard) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_board);
        //recyclerview in the layout
        ButterKnife.bind(this);
        setUpFirebaseAdapter();
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
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }
}
