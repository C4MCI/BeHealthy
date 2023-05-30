package com.example.cilek_adam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Sports extends AppCompatActivity {

    UserInfo info;

    EditText minutesInput;
    TextView headerText, descriptionText;
    Spinner sportSpinner;
    Switch sportsSwitch;
    Button saveButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.barColor)));

        info = new UserInfo();
        headerText = findViewById(R.id.sports_header);
        descriptionText = findViewById(R.id.sports_descriptionText);
        sportSpinner = findViewById(R.id.sports_spinner);
        sportsSwitch = findViewById(R.id.sportsSwitch);
        saveButton = findViewById(R.id.sports_saveButton);
        minutesInput = findViewById(R.id.sports_minuteInput);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int caloriesBurned = 0;
                String sport = sportSpinner.getSelectedItem().toString();
                String minutesStr = minutesInput.getText().toString();

                if (TextUtils.isEmpty(minutesStr) || TextUtils.isEmpty(sport)){
                    if (!sportsSwitch.isChecked()){
                        Toast.makeText(Sports.this,"Lütfen Tüm Boşlukları Doldurun!",Toast.LENGTH_SHORT).show();}
                    else{
                        Toast.makeText(Sports.this,"Please Fill All Blanks!",Toast.LENGTH_SHORT).show();}
                    return;
                }

                int minutes = Integer.parseInt(minutesStr);

                switch (sport) {
                    case "Yürüyüş":
                    case "Walking":
                        caloriesBurned += (minutes * 5);
                        break;
                    case "Tempolu Koşu":
                    case "Jogging":
                        caloriesBurned += (minutes * 15);
                        break;
                    case "Bisiklet":
                    case "Cycling":
                        caloriesBurned += (minutes * 12);
                        break;
                    case "Yüzme":
                    case "Swimming":
                        caloriesBurned += (minutes * 12);
                        break;
                    case "Basketbol":
                    case "Basketball":
                        caloriesBurned += (minutes * 10);
                        break;
                    case "İp Atlama":
                    case "Jump Rope":
                        caloriesBurned += (minutes * 13);
                        break;
                    case "Jimnastik":
                    case "Gymnastics":
                        caloriesBurned += (minutes * 5);
                        break;
                }

                info.addCalorieBurn(caloriesBurned);
                if (!sportsSwitch.isChecked()){
                    Toast.makeText(Sports.this, "Güncelleme Başarılı!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Sports.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
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