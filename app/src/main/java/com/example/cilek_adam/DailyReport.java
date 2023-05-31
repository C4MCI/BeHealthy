package com.example.cilek_adam;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.io.Console;

public class DailyReport extends AppCompatActivity {

    TextView headerText, calorieTakenText, calorieTakenInput, calorieBurnText, calorieBurnInput;

    UserInfo info;

    Switch dailySwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_report);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.barColor)));

        info = new UserInfo();
        headerText = findViewById(R.id.daily_header);
        calorieTakenText = findViewById(R.id.daily_calorieTakenText);
        calorieTakenInput = findViewById(R.id.daily_calorieTakenInput);
        calorieBurnText = findViewById(R.id.daily_calorieBurnText);
        calorieBurnInput = findViewById(R.id.daily_calorieBurnInput);
        dailySwitch = findViewById(R.id.dailySwitch);

        int calorieTaken = info.getCalorie_taken();
        int calorieBurn = info.getCalorie_burn();

        calorieTakenInput.setText(String.valueOf(calorieTaken));
        calorieBurnInput.setText(String.valueOf(calorieBurn));


        dailySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    headerText.setText(R.string.daily_header_E);
                    calorieTakenText.setText(R.string.daily_calorieTakenText_E);
                    calorieBurnText.setText(R.string.daily_calorieBurnText_E);
                } else {
                    headerText.setText(R.string.daily_header_T);
                    calorieTakenText.setText(R.string.daily_calorieTakenText_T);
                    calorieBurnText.setText(R.string.daily_calorieBurnText_T);
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
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}