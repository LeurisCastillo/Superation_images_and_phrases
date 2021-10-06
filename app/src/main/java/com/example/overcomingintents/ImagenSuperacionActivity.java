package com.example.overcomingintents;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class ImagenSuperacionActivity extends AppCompatActivity {

    TextView txtName, txtGender;
    ImageView superationImage;
    Button btnExit, btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen_superacion);

        Intent intent = getIntent();
        String name = intent.getStringExtra("username");
        String gender = intent.getStringExtra("userGender");

        txtName = findViewById(R.id.txt_name);
        txtGender = findViewById(R.id.txt_gender);

        superationImage = findViewById(R.id.superation_image);

        btnExit = findViewById(R.id.btn_exit);
        btnShare = findViewById(R.id.btn_share);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent share = new Intent();
                share.setAction(Intent.ACTION_SEND);
                share.setType("image/*");
                share.putExtra(Intent.EXTRA_STREAM, String.valueOf((BitmapDrawable) superationImage.getDrawable()));
                startActivity(Intent.createChooser(share, "Share via:"));
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ImagenSuperacionActivity.this);
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
        String[] imagesMen = {"first_men", "second_men", "third_men", "fourth_men", "fith_men"};
        String[] imagesWomen = {"first_women", "second_women", "third_women", "fourth_women", "fith_women"};

        int id = 0;

        if (gender.equals("Men")) {

            int index = random.nextInt(imagesMen.length+1);
            if (index == 5){
                index = 4;
            }
            Context context = superationImage.getContext();
            id = context.getResources().getIdentifier(imagesMen[index], "drawable", context.getPackageName());

        } else if (gender.equals("Women")) {

            int index = random.nextInt(imagesWomen.length+1);
            if (index == 5){
                index = 4;
            }
            Context context = superationImage.getContext();
            id = context.getResources().getIdentifier(imagesWomen[index], "drawable", context.getPackageName());

        }

        superationImage.setImageResource(id);
    }
}