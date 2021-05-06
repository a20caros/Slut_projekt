package com.example.slut_projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Pizza extends AppCompatActivity {

    private Mat[] maträtter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Namn");
        String location = intent.getStringExtra("Location");
        String category = intent.getStringExtra("Category");
        String company = intent.getStringExtra("Company");
        TextView textView = findViewById(R.id.textview);
        textView.setText(name);
        TextView textView1 = findViewById(R.id.textview_location);
        textView1.setText(location);
        TextView textView2 = findViewById(R.id.textview_category);
        textView2.setText(category);
        TextView textView3 = findViewById(R.id.textview_company);
        textView3.setText(category);




    }

}