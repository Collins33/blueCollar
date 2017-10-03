package com.example.root.bluecollar.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.bluecollar.R;
import com.example.root.bluecollar.models.Category;
import com.example.root.bluecollar.ui.jobForm;

import java.util.ArrayList;

/**
 * Created by root on 9/22/17.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryView> {

    private ArrayList<Category> categoryData;
    private Context mContext;

    public CategoryAdapter(Context context,ArrayList<Category> data){
        this.categoryData=data;
        mContext = context;
    }

   //the nested class
    public  class CategoryView extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView categoryName;
        ImageView categoryImage;

        public CategoryView(View view){
            super(view);
            this.categoryName=(TextView) itemView.findViewById(R.id.textViewName);
            this.categoryImage=(ImageView) itemView.findViewById(R.id.imageView);
            view.setOnClickListener(this);

        }
        @Override
        public void onClick(View v){
           Intent intent=new Intent(mContext,jobForm.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            String category=categoryName.getText().toString();
            intent.putExtra("category",category);
           mContext.startActivity(intent);
        }
    }

    @Override
    public CategoryView onCreateViewHolder(ViewGroup parent, int viewType){
        //inflate the card view
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        //create new instance of view holder
        CategoryView viewHolder=new CategoryView(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(final CategoryView holder, final int listPosition){
        TextView categoryName= holder.categoryName;
        ImageView categoryImage=holder.categoryImage;

        categoryName.setText(categoryData.get(listPosition).getName());
        categoryImage.setImageResource(categoryData.get(listPosition).getImage());
    }

    @Override
    public int getItemCount(){
        return categoryData.size();
    }



}
