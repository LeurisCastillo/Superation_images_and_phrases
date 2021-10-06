package com.example.overcomingintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Login extends AppCompatActivity {

    EditText edtName;
    Button btnOverImages, btnOverPhrases;
    RadioGroup radioGroup;
    RadioButton radioGender;

    public static String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtName = findViewById(R.id.edt_name);
        btnOverImages = findViewById(R.id.btn_overcoming_images);
        btnOverPhrases = findViewById(R.id.btn_overcoming_phrases);
        radioGroup = findViewById(R.id.radio_group);

        btnOverImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSuperationImage();
            }
        });

        btnOverPhrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSuperationPhrase();
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedButtonId) {
                radioGender = findViewById(checkedButtonId);
                gender = radioGender.getText().toString();
            }
        });
    }

    private void openSuperationImage() {
        Intent intent = new Intent(this, ImagenSuperacionActivity.class);
        String name = edtName.getText().toString();
        intent.putExtra("username", name);
        intent.putExtra("userGender", gender);
        startActivity(intent);
    }

    private void openSuperationPhrase() {
        Intent intent = new Intent(this, FraseSuperacioActivity.class);
        String name = edtName.getText().toString();
        intent.putExtra("username", name);
        intent.putExtra("userGender", gender);
        startActivity(intent);
    }
}