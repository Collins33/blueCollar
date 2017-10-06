package com.example.root.bluecollar.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.root.bluecollar.R;
import com.example.root.bluecollar.adapters.JobDetailsAdapter;
import com.example.root.bluecollar.models.Job;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class JobDetailActivity extends AppCompatActivity{
    @Bind(R.id.viewPager)
    ViewPager mViewPager;

    private JobDetailsAdapter adapterViewPager;
    ArrayList<Job> mJobs= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_detail);
        ButterKnife.bind(this);

        mJobs = Parcels.unwrap(getIntent().getParcelableExtra("jobs"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new JobDetailsAdapter(getSupportFragmentManager(), mJobs);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);

    }

}
