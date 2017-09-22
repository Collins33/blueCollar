package com.example.root.bluecollar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Category_page extends AppCompatActivity {
    private CardView mCardView;
    private TextView mTextView;
    private String[] categories={"CLEANING","HANDYMAN","LANDSCAPING","DELIVERY","ERRANDS","TUTOR"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_page);

        mCardView=(CardView) findViewById(R.id.card_view);




    }
}
