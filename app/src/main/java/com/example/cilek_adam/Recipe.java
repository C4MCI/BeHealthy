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

    TextView welcome_bmiTV, welcome_kiloTV, kiloal1,kiloal2, kiloal3, kilover1,kilover2,kilover3, recipe1, recipe2, recipe3, recipe4,
    recipe5, recipe6;

    Switch trSwitch;

    Button buttonKahvalti, buttonPizza, buttonSalata, buttonYulaf, buttonPankek, buttonHindi;

    boolean sw;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Recipe");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.barColor)));
        sw = getIntent().getBooleanExtra("sw", false);
        info = new UserInfo();

        welcome_bmiTV = findViewById(R.id.textView3);
        welcome_kiloTV = findViewById(R.id.textView4);
        kiloal1 = findViewById(R.id.text_pizza2);
        kiloal2 = findViewById(R.id.text_yulaf2);
        kiloal3 = findViewById(R.id.hindi_text2);
        kilover1 = findViewById(R.id.text_kahvalti2);
        kilover2 = findViewById(R.id.text_salata2);
        kilover3 = findViewById(R.id.text_pankek2);
        recipe1 = findViewById(R.id.text_kahvalti1);
        recipe2 = findViewById(R.id.text_pizza1);
        recipe3 = findViewById(R.id.text_salata1);
        recipe4 = findViewById(R.id.text_yulaf1);
        recipe5 = findViewById(R.id.text_pankek1);
        recipe6 = findViewById(R.id.hindi_text1);




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

        trSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    welcome_bmiTV.setText(R.string.recipe_bmi_E);
                    welcome_kiloTV.setText(R.string.recipe_kilo_E);
                    kiloal1.setText(R.string.kilo_al_E);
                    kiloal2.setText(R.string.kilo_al_E);
                    kiloal3.setText(R.string.kilo_al_E);
                    kilover1.setText(R.string.kilo_ver_E);
                    kilover2.setText(R.string.kilo_ver_E);
                    kilover3.setText(R.string.kilo_ver_E);
                    recipe1.setText(R.string.breakfast_recipeE);
                    recipe2.setText(R.string.pizza_recipeE);
                    recipe3.setText(R.string.salata_recipeE);
                    recipe4.setText(R.string.yulaf_recipeE);
                    recipe5.setText(R.string.pankek_recipeE);
                    recipe6.setText(R.string.hindi_recipeE);
                    buttonKahvalti.setText(R.string.tarifE);
                    buttonPizza.setText(R.string.tarifE);
                    buttonSalata.setText(R.string.tarifE);
                    buttonYulaf.setText(R.string.tarifE);
                    buttonPankek.setText(R.string.tarifE);
                    buttonHindi.setText(R.string.tarifE);




                } else {
                    welcome_bmiTV.setText(R.string.recipe_bmi_T);
                    welcome_kiloTV.setText(R.string.recipe_kilo_T);
                    kiloal1.setText(R.string.kilo_al_T);
                    kiloal2.setText(R.string.kilo_al_T);
                    kiloal3.setText(R.string.kilo_al_T);
                    kilover1.setText(R.string.kilo_ver_T);
                    kilover2.setText(R.string.kilo_ver_T);
                    kilover3.setText(R.string.kilo_ver_T);
                    recipe1.setText(R.string.breakfast_recipeT);
                    recipe2.setText(R.string.pizza_recipeT);
                    recipe3.setText(R.string.salata_recipeT);
                    recipe4.setText(R.string.yulaf_recipeT);
                    recipe5.setText(R.string.pankek_recipeT);
                    recipe6.setText(R.string.hindi_recipeT);
                    buttonKahvalti.setText(R.string.tarifT);
                    buttonPizza.setText(R.string.tarifT);
                    buttonSalata.setText(R.string.tarifT);
                    buttonYulaf.setText(R.string.tarifT);
                    buttonPankek.setText(R.string.tarifT);
                    buttonHindi.setText(R.string.tarifT);

                }
            }
        });


        trSwitch.setChecked(sw);
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