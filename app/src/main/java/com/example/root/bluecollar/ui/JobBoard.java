package com.example.root.bluecollar.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.root.bluecollar.Constants;
import com.example.root.bluecollar.R;
import com.example.root.bluecollar.adapters.FirebaseJobViewHolder;
import com.example.root.bluecollar.models.Job;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class JobBoard extends AppCompatActivity {
    private DatabaseReference ref;
    private FirebaseRecyclerAdapter mFirebaseAdapter;
    RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_board);
        //recyclerview in the layout
        mRecyclerView=(RecyclerView) findViewById(R.id.jobBoard);
        //name of node
        ref= FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_JOB);

        setUpFirebaseAdapter();
    }
    private void setUpFirebaseAdapter(){
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Job,FirebaseJobViewHolder>(Job.class,R.layout.available_job,FirebaseJobViewHolder.class,ref) {


            @Override
            protected void populateViewHolder(FirebaseJobViewHolder viewHolder, Job model, int position) {
                viewHolder.bindJob(model);
            }
        };
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
