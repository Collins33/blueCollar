package com.example.root.bluecollar.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.bluecollar.Category_page;
import com.example.root.bluecollar.Constants;
import com.example.root.bluecollar.R;
import com.example.root.bluecollar.models.Job;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class jobForm extends AppCompatActivity implements View.OnClickListener{
    Button saveJobs;

    EditText employerName;
    EditText description;
    EditText payment;
    EditText duration;
    EditText contact;
    TextView heading;
    private Spinner mSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_form);
        //find the views
        saveJobs=(Button) findViewById(R.id.addJobButton);

        heading=(TextView) findViewById(R.id.textView10);
        //set click listeners
        saveJobs.setOnClickListener(this);

        //get views
        employerName=(EditText) findViewById(R.id.editName);
        description=(EditText) findViewById(R.id.editDescription);
        payment=(EditText) findViewById(R.id.editPayment);
        duration=(EditText) findViewById(R.id.editDuration);
        contact=(EditText) findViewById(R.id.editContact);
        //intent get extra string
        Intent intent=getIntent();
        String category=intent.getStringExtra("category");
        Toast.makeText(getApplicationContext(),"hello "+category,Toast.LENGTH_LONG).show();
        //set font style
        Typeface song=Typeface.createFromAsset(getAssets(),"fonts/champagne.ttf");
        heading.setTypeface(song);
        //add items to spinner in this method
        addItemsToSpinner();
    }
    //add items to spinner
    public void addItemsToSpinner(){
    //find spinner view
        mSpinner=(Spinner) findViewById(R.id.spinner2);
        //create arrayList to contain items of the spinner
        List<String> state=new ArrayList<String>();
        state.add("urgent");
        state.add("casual");
        //array adapter to connect array to spinner
        ArrayAdapter<String> dataSpinner=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,state);
        dataSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //set adapter to spinner
        mSpinner.setAdapter(dataSpinner);
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
            String urgently=String.valueOf(mSpinner.getSelectedItem());
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


    }
}
