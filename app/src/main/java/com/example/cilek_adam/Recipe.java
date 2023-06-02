package com.example.cilek_adam;

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
import androidx.appcompat.app.AppCompatActivity;

public class Recipe extends AppCompatActivity {
    UserInfo info;

    TextView welcome_bmiTV, welcome_kiloTV;
    Switch trSwitch;

    Button buttonKahvalti, buttonPizza, buttonSalata, buttonYulaf, buttonPankek, buttonHindi;

    boolean sw;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.barColor)));
        sw = getIntent().getBooleanExtra("sw", false);
        info = new UserInfo();

        welcome_bmiTV = findViewById(R.id.textView3);
        welcome_kiloTV = findViewById(R.id.textView4);

        trSwitch = findViewById(R.id.recipe_switch);

        buttonKahvalti = findViewById(R.id.button_kahvalti);
        buttonPizza = findViewById(R.id.button_pizza);
        buttonSalata = findViewById(R.id.button_salata);
        buttonYulaf = findViewById(R.id.button_yulaf);
        buttonPankek = findViewById(R.id.button_pankek);
        buttonHindi = findViewById(R.id.button_hindi);

        welcome_bmiTV.setText("BMI değeriniz: " + info.getBMIString());
        welcome_kiloTV.setText("Burası ayarlanacak.");

        buttonKahvalti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Web.class);
                i.putExtra("url", "https://fityemek.com/fit-tarifler/sef-gibi-kahvalti-hazirla/");
                startActivity(i);
            }
        });

        buttonPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Web.class);
                i.putExtra("url", "https://fityemek.com/fit-tarifler/pizza-bulk-kilo-aldirir-kas-yaptirir/");
                startActivity(i);
            }
        });

        buttonSalata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Web.class);
                i.putExtra("url", "https://fityemek.com/fit-tarifler/mercimek-salatasi-tarifi/");
                startActivity(i);
            }
        });

        buttonYulaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Web.class);
                i.putExtra("url", "https://fityemek.com/fit-tarifler/kilo-aldiran-yulaf-ezmesi-tarifi/");
                startActivity(i);
            }
        });

        buttonPankek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Web.class);
                i.putExtra("url", "https://fityemek.com/fit-tarifler/kahveli-pankek-tarifi/");
                startActivity(i);
            }
        });

        buttonHindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Web.class);
                i.putExtra("url", "https://fityemek.com/fit-tarifler/sporcu-yemegi-1000-kalori/");
                startActivity(i);
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
