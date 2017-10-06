package com.example.root.bluecollar.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.root.bluecollar.models.Job;
import com.example.root.bluecollar.ui.JobDetailsFragment;

import java.util.ArrayList;

/**
 * Created by root on 10/6/17.
 */

public class JobDetailsAdapter extends FragmentPagerAdapter {
    private ArrayList<Job> mJob;
    public JobDetailsAdapter(FragmentManager fm, ArrayList<Job> restaurants) {
        super(fm);
        mJob = restaurants;
    }

    @Override
    public Fragment getItem(int position) {
        return JobDetailsFragment.newInstance(mJob.get(position));
    }

    @Override
    public int getCount() {
        return mJob.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mJob.get(position).getCategory();
    }
}
