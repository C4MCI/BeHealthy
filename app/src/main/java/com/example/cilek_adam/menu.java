package com.example.cilek_adam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class menu extends AppCompatActivity {
    FirebaseAuth mAuth;
    TextView textView;
    Button logOutButton;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mAuth = FirebaseAuth.getInstance();
        logOutButton = findViewById(R.id.logOutButton);
        textView = findViewById(R.id.userDetails);
        user = mAuth.getCurrentUser();
        if(user==null){
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            finish();
        }else{
            textView.setText(user.getEmail());
        }
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}