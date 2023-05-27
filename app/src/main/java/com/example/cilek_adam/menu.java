package com.example.cilek_adam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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
    ImageButton accountButton, update;
    FirebaseUser mUser;
    DatabaseReference mReference;
    HashMap<String,String> data;
    UserInfo info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.barColor)));
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mReference = FirebaseDatabase.getInstance().getReference("Users").child(mUser.getUid());
        update = findViewById(R.id.menu_updateButton);
        accountButton = findViewById(R.id.menu_accountButton);

        data = new HashMap<>();
        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snp : snapshot.getChildren()){
                   data.put(snp.getKey().toString(),snp.getValue().toString());
                }

                info = new UserInfo(data.get("name").toString(),data.get("sex").toString(),
                        Integer.parseInt(data.get("years").toString()),Integer.parseInt(data.get("weight").toString()),
                        Integer.parseInt(data.get("height").toString()));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        accountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Account.class);
                startActivity(intent);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),UpdateInfo.class);
                startActivity(intent);
            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            // Geri düğmesine basıldığında yapılacak işlemler
            // Burada belirli bir aktiviteye yönlendirebilirsiniz
            mAuth.signOut();
            Intent intent = new Intent(this, logIn.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}