package com.example.cilek_adam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.Objects;

public class Calorie extends AppCompatActivity {
    UserInfo info;

    EditText morningInput, noonInput, eveningInput;

    TextView headerText, descriptionText, morningText, noonText, eveningText;

    Switch calorieSwitch;

    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.barColor)));


        info = new UserInfo();
        headerText = findViewById(R.id.calorie_header);
        descriptionText = findViewById(R.id.calorie_text);
        morningInput = findViewById(R.id.calorie_morningInput);
        noonInput = findViewById(R.id.calorie_noonInput);
        eveningInput = findViewById(R.id.calorie_eveningInput);
        morningText = findViewById(R.id.calorie_morningText);
        noonText = findViewById(R.id.calorie_noonText);
        eveningText = findViewById(R.id.calorie_eveningText);
        calorieSwitch = findViewById(R.id.calorieSwitch);
        saveButton = findViewById(R.id.calorie_saveButton);

        calorieSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    if (isChecked) {
                        headerText.setText(R.string.calorie_header_E);
                        descriptionText.setText(R.string.calorie_text_E);
                        morningText.setText(R.string.calorie_morningText_E);
                        noonText.setText(R.string.calorie_noonText_E);
                        eveningText.setText(R.string.calorie_eveningText_E);
                        saveButton.setText(R.string.calorie_saveButton_E);
                    } else {
                        headerText.setText(R.string.calorie_header_T);
                        descriptionText.setText(R.string.calorie_text_T);
                        morningText.setText(R.string.calorie_morningText_T);
                        noonText.setText(R.string.calorie_noonText_T);
                        eveningText.setText(R.string.calorie_eveningText_T);
                        saveButton.setText(R.string.calorie_saveButton_T);
                    }
            }
        });


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String morning,noon,evening;
                int total = 0;
                morning = morningInput.getText().toString();
                noon = noonInput.getText().toString();
                evening = eveningInput.getText().toString();
                String[] inputs = { morning, noon, evening };
                for (int i = 0; i < inputs.length; i++) {
                    if (Objects.equals(inputs[i], ""))
                        inputs[i] = "0";
                }

                for (String input : inputs) {
                    total += Integer.parseInt(input);
                }

                info.addCalorieTaken(total);

                if (!calorieSwitch.isChecked()){
                    Toast.makeText(Calorie.this, "Güncelleme Başarılı!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Calorie.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(),menu.class);
                startActivity(intent);
                finish();


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