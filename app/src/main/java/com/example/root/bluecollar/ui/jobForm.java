package com.example.root.bluecollar.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.root.bluecollar.Constants;
import com.example.root.bluecollar.R;
import com.example.root.bluecollar.models.Job;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class jobForm extends AppCompatActivity implements View.OnClickListener{
    Button saveJobs;
    Button casual;
    Button urgent;
    EditText employerName;
    EditText description;
    EditText payment;
    EditText duration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_form);
        saveJobs=(Button) findViewById(R.id.button8);
        casual=(Button) findViewById(R.id.button7);
        urgent=(Button) findViewById(R.id.button9);
        //set click listeners
        saveJobs.setOnClickListener(this);
        casual.setOnClickListener(this);
        urgent.setOnClickListener(this);
        //get views
        employerName=(EditText) findViewById(R.id.editText7);
        description=(EditText) findViewById(R.id.editText8);
        payment=(EditText) findViewById(R.id.editText9);
        duration=(EditText) findViewById(R.id.editText10);
        //intent get extra string
        Intent intent=getIntent();
        String category=intent.getStringExtra("category");
        Toast.makeText(getApplicationContext(),"hello "+category,Toast.LENGTH_LONG).show();
    }
    @Override
    public void onClick(View view){
        if(view == saveJobs) {
            Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_LONG).show();
            String name=employerName.getText().toString();
            String jobDescription=description.getText().toString();
            String money=payment.getText().toString();
            String time=duration.getText().toString();
            boolean urgent=true;
            String jobCategory="cooking";
            Job newjob=new Job(name,jobDescription,money,time,urgent,jobCategory);
            DatabaseReference restaurantRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_JOB);
            restaurantRef.push().setValue(newjob);

        }
        else if (view == casual){
            boolean urgency=false;
        }
        else if(view==urgent){
            boolean urgency=true;
        }
    }
}
