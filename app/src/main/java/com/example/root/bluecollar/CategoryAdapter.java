package com.example.root.bluecollar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by root on 9/22/17.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryView> {

    private ArrayList<Category> categoryData;

    public CategoryAdapter(ArrayList<Category> data){
        this.categoryData=data;
    }

   //the nested class
    public static class CategoryView extends RecyclerView.ViewHolder{
        TextView categoryName;

        public CategoryView(View view){
            super(view);
            this.categoryName=(TextView) itemView.findViewById(R.id.textViewName);
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

        categoryName.setText(categoryData.get(listPosition).getName());
    }

    @Override
    public int getItemCount(){
        return categoryData.size();
    }



}
