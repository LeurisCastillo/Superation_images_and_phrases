package com.example.overcomingintents;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class FraseSuperacioActivity extends AppCompatActivity {

    TextView txtName, txtGender;
    TextView superationPhrase;
    Button btnExit, btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frase_superacion);

        Intent intent = getIntent();
        String name = intent.getStringExtra("username");
        String gender = intent.getStringExtra("userGender");

        txtName = findViewById(R.id.txt_name);
        txtGender = findViewById(R.id.txt_gender);

        superationPhrase = findViewById(R.id.superation_phrase);

        btnExit = findViewById(R.id.btn_exit);
        btnShare = findViewById(R.id.btn_share);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent share = new Intent();
                share.setAction(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_STREAM, superationPhrase.getText().toString());
                startActivity(Intent.createChooser(share, "Share via:"));
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(FraseSuperacioActivity.this);
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

        txtName.setText(name);
        txtGender.setText(gender);

        Random random = new Random();
        String[] phraseMen = {
                "“Success is going from failure to failure without losing your enthusiasm.”",
                "“If you try, you risk failure. If you don’t, you ensure it.”",
                "“If one advances confidently in the direction of one’s dreams, and endeavors to live the life which one has imagined, one will meet with a success unexpected in common hours.”",
                "“Insanity: doing the same thing over and over again and expecting different results.”",
                "“Courage is grace under pressure.”"};

        String[] phraseWomen = {
                "“Don’t let anyone speak for you, and don’t rely on others to fight for you.”",
                "“You had the power all along my dear.”",
                "“Nothing I accept about myself can be used against me to diminish me.”",
                "“I am not free while any woman is unfree, even when her shackles are very different from my own.”",
                "“My mother told me to be a lady. And for her, that meant be your own person, be independent.”"};

        String inspirationMessage = "";

        if (gender.equals("Men")) {

            int index = random.nextInt(phraseMen.length+1);
            if (index == 5){
                index = 4;
            }
            inspirationMessage = phraseMen[index];

        } else if (gender.equals("Women")) {

            int index = random.nextInt(phraseWomen.length+1);
            if (index == 5){
                index = 4;
            }
            inspirationMessage = phraseWomen[index];

        }

        superationPhrase.setText(inspirationMessage);
    }
}