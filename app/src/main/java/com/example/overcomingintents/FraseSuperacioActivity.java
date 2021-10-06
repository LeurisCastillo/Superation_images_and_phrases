package com.example.overcomingintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FraseSuperacioActivity extends AppCompatActivity {

    TextView txtName, txtGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frase_superacion);

        Intent intent = getIntent();
        String name = intent.getStringExtra("username");
        String gender = intent.getStringExtra("userGender");

        txtName = findViewById(R.id.txt_name);
        txtGender = findViewById(R.id.txt_gender);

        txtName.setText(name);
        txtGender.setText(gender);
    }
}