package com.example.root.bluecollar.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.root.bluecollar.Category_page;
import com.example.root.bluecollar.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Sign_Up extends AppCompatActivity{
    EditText emailInput;
    EditText passwordInput;
    Button signUp;
    public static final String TAG = Sign_Up.class.getSimpleName();
    private FirebaseAuth mAuth;
    //listen for authentication
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);
        emailInput=(EditText) findViewById(R.id.editText3);
        passwordInput=(EditText) findViewById(R.id.editText4);
        signUp=(Button) findViewById(R.id.signUpButton);
        mAuth=FirebaseAuth.getInstance();
        createStateListener();
    }
    public void signUp(View view){
        Intent intent=new Intent(getApplicationContext(),Log_In.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
    private void registerAccount(){
        final String email=emailInput.getText().toString().trim();
        String password=passwordInput.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.d(TAG,"AUTHENTICATION SUCCESSFULL");

                }
               else{

                    Toast.makeText(Sign_Up.this,"AUTHENTICATION FAILED",Toast.LENGTH_LONG).show();
               }
            }
        });
    }

    public void onClick(View view){
        registerAccount();
    }
    public void createStateListener(){
        mAuthStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user=firebaseAuth.getCurrentUser();
                if(user != null){
                    Intent intent=new Intent(Sign_Up.this,Category_page.class);
                    //MAKE SURE YOU DONT GO BACK
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }

            }
        };
    }
    @Override
    public void onStart(){
        super.onStart();
        mAuth.addAuthStateListener(mAuthStateListener);
    }
    @Override
    public void onStop(){
        super.onStop();
        if(mAuthStateListener == null){
            mAuth.removeAuthStateListener(mAuthStateListener);
        }
    }





}
