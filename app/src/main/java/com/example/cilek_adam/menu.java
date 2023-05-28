package com.example.cilek_adam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
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
    TextView accountText, dailyText, calorieText, recipesText, sportsText, waterText, weightText,
             updateText, healthText;
    ImageButton accountButton, updateButton, calorieButton;
    FirebaseUser mUser;
    DatabaseReference mReference;
    HashMap<String,String> data;
    UserInfo info;

    Switch menuSwitch;
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
        updateButton = findViewById(R.id.menu_updateButton);
        accountButton = findViewById(R.id.menu_accountButton);
        calorieButton = findViewById(R.id.menu_calorieButton);
        menuSwitch = findViewById(R.id.menuSwitch);
        accountText = findViewById(R.id.menu_accountText);
        dailyText = findViewById(R.id.menu_dailyText);
        calorieText = findViewById(R.id.menu_calorieText);
        recipesText = findViewById(R.id.menu_recipesText);
        sportsText = findViewById(R.id.menu_sportsText);
        waterText = findViewById(R.id.menu_waterText);
        weightText = findViewById(R.id.menu_weightText);
        updateText = findViewById(R.id.menu_updateText);
        healthText = findViewById(R.id.menu_healthText);

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

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),UpdateInfo.class);
                startActivity(intent);
            }
        });

        calorieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Calorie.class);
                startActivity(intent);
            }
        });

        menuSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    accountText.setText(R.string.menu_account_E);
                    dailyText.setText(R.string.menu_daily_E);
                    calorieText.setText(R.string.menu_calorie_E);
                    recipesText.setText(R.string.menu_recipes_E);
                    sportsText.setText(R.string.menu_sports_E);
                    waterText.setText(R.string.menu_water_E);
                    weightText.setText(R.string.menu_weight_E);
                    updateText.setText(R.string.menu_update_E);
                    healthText.setText(R.string.menu_health_E);
                } else {
                    accountText.setText(R.string.menu_account_T);
                    dailyText.setText(R.string.menu_daily_T);
                    calorieText.setText(R.string.menu_calorie_T);
                    recipesText.setText(R.string.menu_recipes_T);
                    sportsText.setText(R.string.menu_sports_T);
                    waterText.setText(R.string.menu_water_T);
                    weightText.setText(R.string.menu_weight_T);
                    updateText.setText(R.string.menu_update_T);
                    healthText.setText(R.string.menu_health_T);
                }
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