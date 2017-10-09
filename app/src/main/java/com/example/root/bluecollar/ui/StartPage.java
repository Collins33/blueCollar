package com.example.root.bluecollar.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.bluecollar.Category_page;
import com.example.root.bluecollar.R;
import com.example.root.bluecollar.ui.Log_In;
import com.example.root.bluecollar.ui.Sign_Up;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class StartPage extends AppCompatActivity {
    TextView firstText;
    TextView secondText;
    GoogleApiClient mGoogleApiClient;
    SignInButton mGoogleSignInButton;
    private static final int RC_SIGN_IN = 9001;
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
        //google sign in
        mGoogleSignInButton = (SignInButton)findViewById(R.id.button2);
        mGoogleSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInWithGoogle();
            }
        });

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
        Toast.makeText(getApplicationContext(),"coming soon",Toast.LENGTH_LONG).show();
    }
    private void signInWithGoogle() {
        if(mGoogleApiClient != null) {
            mGoogleApiClient.disconnect();
        }

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        final Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);

            if(result.isSuccess()) {
                final GoogleApiClient client = mGoogleApiClient;
                Intent newIntent =new Intent(getApplicationContext(), Category_page.class);
                startActivity(newIntent);
                finish();

                //handleSignInResult(...)
            } else {
                //handleSignInResult(...);
            }
        } else {
            // Handle other values for requestCode
        }
    }

}
