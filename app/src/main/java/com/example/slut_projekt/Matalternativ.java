package com.example.slut_projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Matalternativ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matalternativ);

        Button button = findViewById(R.id.Hamburgare_knapp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Matalternativ.this, Hamburgare.class);
                startActivity(intent);
            }
        });
        Button button1 = findViewById(R.id.Pizza_knapp);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Matalternativ.this, Pizza.class);
                startActivity(intent);
            }
        });
        Button button2 = findViewById(R.id.Pasta_knapp);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Matalternativ.this, Pizza.class);
                startActivity(intent);
            }
        });
    }
}