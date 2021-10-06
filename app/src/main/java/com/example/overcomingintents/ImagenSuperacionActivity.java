package com.example.overcomingintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class ImagenSuperacionActivity extends AppCompatActivity {

    TextView txtName, txtGender;
    ImageView superationImage;

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