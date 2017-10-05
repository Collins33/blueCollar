package com.example.root.bluecollar.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.root.bluecollar.Constants;
import com.example.root.bluecollar.R;
import com.example.root.bluecollar.models.Job;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by root on 10/4/17.
 */

public class FirebaseJobViewHolder extends RecyclerView.ViewHolder  {
    View mView;
    Context context;

    public FirebaseJobViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        context = itemView.getContext();
        //itemView.setOnClickListener(this);
    }

    public void bindJob(Job job){
        TextView description=(TextView) mView.findViewById(R.id.jobDescription);
        TextView pay=(TextView) mView.findViewById(R.id.jobPay);
        description.setText(job.getCategory());
        pay.setText(job.getPayment());
    }
    //@Override
//    public void onClick(View view){
//        final ArrayList<Job> mJobs=new ArrayList<>();
//        DatabaseReference ref= FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_JOB);
//
//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    restaurants.add(snapshot.getValue(Restaurant.class));
//                }
//
//                int itemPosition = getLayoutPosition();
//
//                Intent intent = new Intent(mContext, RestaurantDetailActivity.class);
//                intent.putExtra("position", itemPosition + "");
//                intent.putExtra("restaurants", Parcels.wrap(restaurants));
//
//                mContext.startActivity(intent);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//    }
}

