package com.example.firstconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile extends AppCompatActivity {

    private Button buttonLogout;
     private  TextView userEmail;
    private  FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null){
            startActivity(new Intent(getApplicationContext(),Login.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        userEmail = findViewById(R.id.userEmail);
        userEmail.setText("Welcome "+user.getEmail());
        buttonLogout = findViewById(R.id.buttonLogout);



        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this,Login.class);
                startActivity(intent);
            }
        });
    }
}
