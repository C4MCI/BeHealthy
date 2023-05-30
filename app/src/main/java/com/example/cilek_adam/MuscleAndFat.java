package com.example.cilek_adam;

import androidx.appcompat.app.AppCompatActivity;
import java.lang.Math;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MuscleAndFat extends AppCompatActivity {
TextView fatTV,belTV,boyunTV,fatRatioTV1,fatRatioTV2,kalcaTV,yagKGTV1,yagKGTV2;
Button calculateFat;
Switch fatS;
double fat;
EditText belET,boyunET,kalcaET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle_and_fat);
        UserInfo info = new UserInfo();
        int bel,boyun;

        fatTV=findViewById(R.id.fatTextView);
        belTV = findViewById(R.id.belTextView);
        boyunTV = findViewById(R.id.boyunTextView);
        fatRatioTV1 = findViewById(R.id.fatRatioTextView1);
        fatRatioTV2 = findViewById(R.id.fatRatioTextView2);
        calculateFat = findViewById(R.id.fatCalculateButton);
        fatS = findViewById(R.id.fatSwitch);
        belET = findViewById(R.id.BelEditTextNumber);
        boyunET = findViewById(R.id.boyunEditTextNumber);
        kalcaET = findViewById(R.id.kalcaEditTextNumber);
        kalcaTV = findViewById(R.id.kalcaTextView);
        yagKGTV1 = findViewById(R.id.yagKgTV1);
        yagKGTV2 = findViewById(R.id.yagKgTV2);


        calculateFat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int bel = Integer.parseInt( belET.getText().toString());
                int boyun = Integer.parseInt( boyunET.getText().toString());
                if (info.getSex().equals("Men")){
                    fat = (495.0 / (1.0324-(0.19077*Math.log10(bel-boyun))+(0.15456*Math.log10(info.getHeight()))))-450;
                    fatRatioTV2.setText(String.format("%.2f",fat));


                }else if (info.getSex().equals("Women")){


                }

            }
        });


    }
}