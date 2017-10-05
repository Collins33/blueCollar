package com.example.root.bluecollar.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.root.bluecollar.R;
import com.example.root.bluecollar.models.Job;

import java.util.ArrayList;

/**
 * Created by root on 10/5/17.
 */

public class JobListAdapter extends RecyclerView.Adapter<JobListAdapter.NewsListViewHolder>{
    private ArrayList<Job> mJobs=new ArrayList<>();
    private Context mContext;

    public JobListAdapter(Context context, ArrayList<Job> jobs){
        mContext=context;
        mJobs=jobs;
    }
    //viewholder
    public class NewsListViewHolder extends RecyclerView.ViewHolder{
        TextView jobDescription=(TextView) itemView.findViewById(R.id.jobDescription);
        TextView jobPay=(TextView) itemView.findViewById(R.id.jobPay);
        private Context mContext;

        public NewsListViewHolder(View itemView){
            super(itemView);
            mContext=itemView.getContext();
        }
        public void bindJob(Job job){
            jobDescription.setText(job.getDescription());
            jobPay.setText(job.getPayment());
        }

    }

    @Override
    public JobListAdapter.NewsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.available_job, parent, false);
        NewsListViewHolder viewHolder = new NewsListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(JobListAdapter.NewsListViewHolder holder, int position) {
        holder.bindJob(mJobs.get(position));
    }

    @Override
    public int getItemCount() {
        return mJobs.size();
    }

}
