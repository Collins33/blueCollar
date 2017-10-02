package com.example.root.bluecollar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Sign_Up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);
    }
    public void signUp(View view){
        Intent intent=new Intent(getApplicationContext(),Log_In.class);
        startActivity(intent);
    }
}
