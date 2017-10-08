package com.example.root.bluecollar.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.bluecollar.R;
import com.example.root.bluecollar.ui.Log_In;
import com.example.root.bluecollar.ui.Sign_Up;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;

public class StartPage extends AppCompatActivity {
        TextView firstText;
        TextView secondText;
        GoogleApiClient mGoogleApiClient;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        firstText=(TextView) findViewById(R.id.textView4);
        secondText=(TextView) findViewById(R.id.textView5);
        Typeface champagne=Typeface.createFromAsset(getAssets(),"fonts/song.ttf");
        Typeface song=Typeface.createFromAsset(getAssets(),"fonts/champagne.ttf");
        firstText.setTypeface(champagne);
        secondText.setTypeface(song);






    }
    public void logIn(View view){
        Intent intent=new Intent(getApplicationContext(),Log_In.class);
        startActivity(intent);
    }
    public void SignUp(View view){
        Intent intent=new Intent(getApplicationContext(),Sign_Up.class);
        startActivity(intent);
        //finish();
    }
    public void GoogleSignIn(View view){
        Toast.makeText(getApplicationContext(),"comming soon",Toast.LENGTH_LONG).show();
    }

}
