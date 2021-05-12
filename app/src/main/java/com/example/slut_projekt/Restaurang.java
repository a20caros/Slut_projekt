package com.example.slut_projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Restaurang extends AppCompatActivity {

    private Mat[] maträtter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurang);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Namn");
        String location = intent.getStringExtra("Location");
        String category = intent.getStringExtra("Category");
        String company = intent.getStringExtra("Company");
        String Img = intent.getStringExtra("Img");
        TextView textView = findViewById(R.id.textview);
        textView.setText(name);
        TextView textView1 = findViewById(R.id.textview_location);
        textView1.setText(location);
        TextView textView2 = findViewById(R.id.textview_category);
        textView2.setText(category);
        TextView textView3 = findViewById(R.id.textview_company);
        textView3.setText(company);

        ImageView imageView = findViewById(R.id.images_view_restaurang);
        Picasso.get()
                .load(Img)
                .into(imageView);


    }

}