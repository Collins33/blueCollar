package com.example.root.bluecollar.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.root.bluecollar.Category_page;
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
    EditText contact;
    boolean urgently=true;

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
        contact=(EditText) findViewById(R.id.contact);
        //intent get extra string
        Intent intent=getIntent();
        String category=intent.getStringExtra("category");
        Toast.makeText(getApplicationContext(),"hello "+category,Toast.LENGTH_LONG).show();
    }
    //check credentials entered in the form
    private boolean isEmployerName(String name) {
        if (name.equals("")) {
            employerName.setError("Please enter your name");
            return false;
        }
        return true;
    }
    private boolean isDescriptionRight(String descriptionJob){
        if(descriptionJob.equals("")){
            description.setError("description should not be less than 20 characters");
            return false;
        }
        return true;
    }
    private boolean isPaymentRight(String budget){
        if(budget.equals("")){
            payment.setError("please enter budget");
            return false;
        }
        return true;

    }
    private boolean isDuration(String time){
        if(time.equals("")){
            duration.setError("please enter valid duration");
            return false;
        }
        return true;
    }
    private boolean isNumber(String number){
        if(number.equals("")||number.length()<10){
            contact.setError("Enter a valid number");
            return false;
        }
        return true;
    }


    @Override
    public void onClick(View view){
        if(view == saveJobs) {

            String name=employerName.getText().toString();
            String jobDescription=description.getText().toString();
            String money=payment.getText().toString();
            String time=duration.getText().toString();
            String number=contact.getText().toString();
            Intent intent=getIntent();
            String category=intent.getStringExtra("category");

            String jobCategory=category;
            //validate credentials
            boolean validName=isEmployerName(name);
            boolean validDescription=isDescriptionRight(jobDescription);
            boolean validPayment=isPaymentRight(money);
            boolean validDuration=isDuration(time);
            boolean validPhone=isNumber(number);
            if(!validName||!validDescription||!validPayment||!validDuration||!validPhone) return;
            //create new instance using the objects
            Job newjob=new Job(name,jobDescription,money,time,urgently,jobCategory,number);
            //save new instance to firebase
            DatabaseReference restaurantRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_JOB);
            restaurantRef.push().setValue(newjob);

            Intent intent2=new Intent(getApplicationContext(),Category_page.class);
            startActivity(intent2);
            Toast.makeText(getApplicationContext(), "job added successfully", Toast.LENGTH_LONG).show();


        }
        else if (view == casual){
            urgent.setAlpha(0);
             urgently=false;
        }
        else if(view==urgent){
            urgently=true;
            casual.setAlpha(0);
        }
    }
}
