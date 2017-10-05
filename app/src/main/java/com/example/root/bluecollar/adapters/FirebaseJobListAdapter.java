package com.example.root.bluecollar.adapters;

import android.content.Context;


import com.example.root.bluecollar.models.Job;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

/**
 * Created by root on 10/2/17.
 */

public class FirebaseJobListAdapter extends FirebaseRecyclerAdapter<Job, FirebaseJobViewHolder>{
    public DatabaseReference mRef;
    //private OnStartDragListener mOnStartDragListener;
    public Context mContext;

    public FirebaseJobListAdapter(Class<Job> modelClass, int modelLayout,
                                   Class<FirebaseJobViewHolder> viewHolderClass,
                                   Query ref,Context context) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        mRef = ref.getRef();
        //mOnStartDragListener = onStartDragListener;
        mContext = context;
    }

    @Override
    protected void populateViewHolder(FirebaseJobViewHolder viewHolder, Job model, int position) {
        viewHolder.bindJob(model);
    }




}
