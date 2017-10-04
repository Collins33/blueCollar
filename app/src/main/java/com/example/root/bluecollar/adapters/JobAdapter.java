package com.example.root.bluecollar.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.root.bluecollar.R;
import com.example.root.bluecollar.models.Job;

import java.util.List;

/**
 * Created by root on 10/4/17.
 */

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {
    //the nested view holder class
    public class JobViewHolder extends RecyclerView.ViewHolder{
        public TextView jobDescription;
        public TextView jobPay;
        //constructor
        public JobViewHolder(View view){
            super(view);
            jobDescription=(TextView) view.findViewById(R.id.jobDescription);
            jobPay=(TextView) view.findViewById(R.id.jobPay);
        }
    }
    //adapter class
    public List<Job> mJobs;
    public Context mContext;

    public JobAdapter(Context context,List<Job> job){
        mContext=context;
        mJobs=job;
    }
    //easily access the context
    private Context getContext(){
        return mContext;
    }
    @Override
    public JobAdapter.JobViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.available_job, parent, false);

        // Return a new holder instance
        JobViewHolder viewHolder = new JobViewHolder(contactView);
        return viewHolder;

    }
    //bind views with the getter methods
    @Override
    public void onBindViewHolder(JobAdapter.JobViewHolder viewHolder, int position) {
        // Get the data model based on position
        Job job=mJobs.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.jobDescription;
        textView.setText(job.getDescription());
        TextView payment=viewHolder.jobPay;
        payment.setText(job.getPayment());
    }
    //returns amount of objects in the list
    @Override
    public int getItemCount() {
        return mJobs.size();
    }


}
