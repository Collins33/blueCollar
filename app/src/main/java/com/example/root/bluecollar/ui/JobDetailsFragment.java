package com.example.root.bluecollar.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.bluecollar.R;
import com.example.root.bluecollar.models.Job;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class JobDetailsFragment extends Fragment implements View.OnClickListener{
    @Bind(R.id.restaurantImageView)
    ImageView mImageLabel;
    @Bind(R.id.jobCategory)
    TextView mCategory;
    @Bind(R.id.jobEmployer) TextView mEmployer;
    @Bind(R.id.urgency) TextView mUrgent;
    @Bind(R.id.jobDescription) TextView mDescription;
    @Bind(R.id.jobPay) TextView mPay;

    @Bind(R.id.saveRestaurantButton) TextView mApplyJob;

    private Job mJob;


    public JobDetailsFragment() {
        // Required empty public constructor
    }


    public static JobDetailsFragment newInstance(Job job){
        JobDetailsFragment jobDetailsFragment=new JobDetailsFragment();
        Bundle arg=new Bundle();
        arg.putParcelable("job", Parcels.wrap(job));
        jobDetailsFragment.setArguments(arg);
        return jobDetailsFragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mJob = Parcels.unwrap(getArguments().getParcelable("job"));
    }
    @Override
    public void onClick(View view){
        Uri number = Uri.parse("tel:5551234");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(callIntent);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_blank, container, false);
        ButterKnife.bind(this,view);
        mCategory.setText(mJob.getDescription());
        mEmployer.setText(mJob.getName());
        mDescription.setText(mJob.getCategory());
        mUrgent.setText(mJob.getDuration());
        mPay.setText(mJob.getPayment());
        mApplyJob.setOnClickListener(this);
        return view;


    }

}
