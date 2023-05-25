package com.example.cilek_adam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.Instant;
import java.util.HashMap;


public class Register2 extends AppCompatActivity {
    EditText nameET,yearsET,weightET,heightET;
Switch sexS;
Button saveB;
DatabaseReference mReference;
FirebaseUser mUser;
FirebaseAuth mAuth;
    HashMap<String,String> mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mReference = FirebaseDatabase.getInstance().getReference();
        nameET = findViewById(R.id.nameEditText);
        yearsET = findViewById(R.id.yearsEditText);
        weightET = findViewById(R.id.weightEditText);
        heightET = findViewById(R.id.heightEditText);
        saveB = findViewById(R.id.saveButton);
        sexS = findViewById(R.id.switchButton);


        saveB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameET.getText().toString();
                String sex;
                if(sexS.isChecked()){
                    sex = "Women";
                }else{
                    sex = "Men";
                }
                String years = yearsET.getText().toString();
                String weight = weightET.getText().toString();
                String height = heightET.getText().toString();

             if(!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(years)&&!TextUtils.isEmpty(weight)&&!TextUtils.isEmpty(height)){

                 mData = new HashMap<>();
                 mData.put("userID",mUser.getUid());
                 mData.put("name",name);
                 mData.put("years",years);
                 mData.put("weight",weight);
                 mData.put("height",height);
                 mData.put("sex",sex);

                 mReference.child("Users").child(mUser.getUid()).setValue(mData)
                         .addOnCompleteListener(Register2.this, new OnCompleteListener<Void>() {
                             @Override
                             public void onComplete(@NonNull Task<Void> task) {
                                 if(task.isSuccessful()){
                                    Toast.makeText(Register2.this, "Kayit Islemi Basarili",Toast.LENGTH_SHORT).show();
                                     Intent intent = new Intent(getApplicationContext(),menu.class);
                                     startActivity(intent);
                                     finish();
                                 }else{
                                     Toast.makeText(Register2.this, task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                 }
                             }
                         });


             }else{
                 Toast.makeText(Register2.this, "Tum Bosluklari Doldurunuz.",
                         Toast.LENGTH_SHORT).show();
             }
            }
        });

    }
}