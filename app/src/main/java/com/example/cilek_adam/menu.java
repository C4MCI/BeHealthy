package com.example.cilek_adam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class menu extends AppCompatActivity {
    FirebaseAuth mAuth;
    TextView tV1,tV2,tV3,tV4,tV5;
    Button logOutButton;
    FirebaseUser mUser;
    DatabaseReference mReference;
    HashMap<String,String> data;
    UserInfo info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mReference = FirebaseDatabase.getInstance().getReference("Users").child(mUser.getUid());

        logOutButton = findViewById(R.id.logOutButton);
        tV1 = findViewById(R.id.userDetails);
        tV2 = findViewById(R.id.userDetails2);
        tV3 = findViewById(R.id.userDetails3);
        tV4 = findViewById(R.id.userDetails4);
        tV5 = findViewById(R.id.userDetails5);


        data = new HashMap<>();
        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int i=0;
                for(DataSnapshot snp : snapshot.getChildren()){
                   data.put(snp.getKey().toString(),snp.getValue().toString());
                }
               tV1.setText("name: " + data.get("name"));
                tV2.setText("weight: " + data.get("weight"));
                tV3.setText("height: " + data.get("height"));
                tV4.setText("years: " + data.get("years"));
                tV5.setText("sex: " + data.get("sex"));
                info = new UserInfo(data.get("name").toString(),data.get("sex").toString(),
                        Integer.parseInt(data.get("years").toString()),Integer.parseInt(data.get("weight").toString()),
                        Integer.parseInt(data.get("height").toString()));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Account.class);
                startActivity(intent);
                finish();
            }
        });
    }
}