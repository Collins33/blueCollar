package com.example.root.bluecollar.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.root.bluecollar.R;
import com.example.root.bluecollar.ui.Log_In;
import com.example.root.bluecollar.ui.Sign_Up;

public class StartPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
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
}
