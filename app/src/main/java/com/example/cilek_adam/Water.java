package com.example.cilek_adam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Objects;


public class Water extends AppCompatActivity {

    EditText su;

    TextView baslik, aciklama;

    Button updateButton;

    Switch trSwitch;

    ProgressBar progressBar;



    boolean sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_name);

        sw = getIntent().getBooleanExtra("sw", false);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.barColor)));

        su = findViewById(R.id.water_input);

        baslik = findViewById(R.id.water_baslik);
        aciklama = findViewById(R.id.water_aciklama);

        updateButton = findViewById(R.id.water_button);

        progressBar = findViewById(R.id.water_progress);




        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int water;
                int total_water = 0;
                String wota;

                wota = su.getText().toString();
                water = Integer.parseInt(wota);
                total_water += water;
                progressBar.incrementProgressBy(water);


            }
        });

/*        trSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    baslik.setText(R.string.water_baslikE);
                    aciklama.setText(R.string.water_aciklamaE);
                    updateButton.setText(R.string.water_buttonE);

                } else {
                    baslik.setText(R.string.water_baslikT);
                    aciklama.setText(R.string.water_aciklamaT);
                    updateButton.setText(R.string.water_buttonT);

                }
            }
        });

        trSwitch.setChecked(sw);

*/


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