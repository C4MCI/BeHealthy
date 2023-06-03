package com.example.cilek_adam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.Nullable;


public class Workout extends AppCompatActivity {

    Switch trSwitch;

    Button button3, button4, button5, button6, button7;

    TextView baslik;

    boolean sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        sw = getIntent().getBooleanExtra("sw", false);

        baslik = findViewById(R.id.workout_text);

        trSwitch = findViewById(R.id.workoutSwitch);

        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), WebWorkout.class);
                i.putExtra("url", "https://www.kasvekuvvet.net/stronglifts-5x5");
                startActivity(i);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), WebWorkout.class);
                i.putExtra("url", "https://fithub.com.tr/kaslari-sisiren-en-iyi-full-body-antrenman-programi/");
                startActivity(i);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), WebWorkout.class);
                i.putExtra("url", "https://formassist.net/blogs/egzersiz/vucut-gelistirmek-icin-3-x-5-antrenman-programi");
                startActivity(i);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), WebWorkout.class);
                i.putExtra("url", "https://fithub.com.tr/kusursuz-bir-vucut-icin-split-antrenman-programi/");
                startActivity(i);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), WebWorkout.class);
                i.putExtra("url", "https://www.agirsaglam.com/kardiyo/");
                startActivity(i);
            }
        });

        trSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    baslik.setText(R.string.wo_baslikE);
                    button3.setText(R.string.wo_5x5E);
                    button4.setText(R.string.wo_fullbodyE);
                    button5.setText(R.string.wo_3x5E);
                    button6.setText(R.string.wo_splitE);
                    button7.setText(R.string.wo_kardiyoE);

                } else {
                    baslik.setText(R.string.wo_baslikT);
                    button3.setText(R.string.wo_5x5T);
                    button4.setText(R.string.wo_fullbodyT);
                    button5.setText(R.string.wo_3x5T);
                    button6.setText(R.string.wo_splitT);
                    button7.setText(R.string.wo_kardiyoT);
                }
            }
        });





    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            // Geri düğmesine basıldığında yapılacak işlemler
            // Burada belirli bir aktiviteye yönlendirebilirsiniz
            Intent intent = new Intent(this, menu.class);
            sw = trSwitch.isChecked();
            intent.putExtra("sw", sw);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}