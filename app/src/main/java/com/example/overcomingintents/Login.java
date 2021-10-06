package com.example.overcomingintents;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Login extends AppCompatActivity {

    EditText edtName;
    Button btnOverImages, btnOverPhrases, btnExit;
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
        btnExit = findViewById(R.id.btn_exit);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                builder.setTitle("Confirmacion")
                        .setMessage("Desea salir de la app?")
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finishAffinity();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                builder.create();
                builder.show();
            }
        });

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