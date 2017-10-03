package com.example.root.bluecollar.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.bluecollar.Category_page;
import com.example.root.bluecollar.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Log_In extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = Log_In.class.getSimpleName();
    TextView createAccount;
    EditText enterEmail;
    EditText enterPassword;
    Button logIn;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log__in);
        enterEmail=(EditText) findViewById(R.id.emailText);
        enterPassword=(EditText) findViewById(R.id.passwordInput);
        logIn=(Button) findViewById(R.id.loginButton);
        logIn.setOnClickListener(this);
        //firebase authentication
        mAuth=FirebaseAuth.getInstance();
        mAuthStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=firebaseAuth.getCurrentUser();
                if(user!=null){
                    Intent intent=new Intent(Log_In.this, Category_page.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        };
    }
    @Override
    public void onClick(View view){
        if(view == logIn){
            logInWithPassword();
        }
    }
    @Override
    public void onStart(){
        super.onStart();
        mAuth.addAuthStateListener(mAuthStateListener);
    }
    @Override
    public void onStop(){
        super.onStop();
        if(mAuthStateListener != null){
            mAuth.removeAuthStateListener(mAuthStateListener);
        }
    }
    public void createAccount(View view){
        Intent intent=new Intent(getApplicationContext(),Sign_Up.class);
        startActivity(intent);
        finish();
    }
//    public void logInUser(View view){
//        logInWithPassword();
//    }
    public void logInWithPassword(){
        String email=enterEmail.getText().toString().trim();
        String password=enterPassword.getText().toString().trim();
        if(email.equals("")){
            enterEmail.setError("enter a valid email");
            return;
        }
        if(password.equals("")){
            enterPassword.setError("enter a valid password");
            return;
        }

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());
                if(task.isSuccessful()){
                    Log.w(TAG, "signInWithEmail", task.getException());
                    Toast.makeText(Log_In.this, "WELCOME.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}
