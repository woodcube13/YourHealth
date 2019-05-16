package com.example.yourhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.auth.FirebaseAuth;

public class GoogleSignInActivity extends AppCompatActivity {

    private static final int RC_READ_IN = 900;

    private GoogleSignInClient googleSignInClient;

    private FirebaseAuth firebaseAuth;

    private SignInButton buttonGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_sign_in);
        Intent splashIntent = new Intent(this, splashActivity.class);
        startActivity(splashIntent);

        firebaseAuth = FirebaseAuth.getInstance();

        buttonGoogle = findViewById(R.id.btn_googleSignIn);

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);

        buttonGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInIntent = googleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_READ_IN);
            }
            @Override
            public void onActivityResult(int requestcode, int resultcode, Intent data){
                super.onActivityResult(requestcode, requestcode, data);


            }
        });

    }
}
