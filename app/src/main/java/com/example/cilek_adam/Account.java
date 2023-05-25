package com.example.cilek_adam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Account extends AppCompatActivity {
UserInfo info;
TextView tV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        tV = findViewById(R.id.accountTextView);
        info = new UserInfo();
        tV.setText(info.getName()+"\n"+info.getSex() + "\n" +info.getHeightString() + "\n"+info.getWeightString()+ "\n"+info.getYearsString());
    }
}