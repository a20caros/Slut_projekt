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
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Matalternativ extends AppCompatActivity {

    private Mat[] maträtter;
    private ListView listView;
    ArrayAdapter<Mat> adapter;
    ArrayList<Mat> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matalternativ);
        try{
            list = new ArrayList<>();
            adapter = new ArrayAdapter<>(this,R.layout.list_textview);
            listView = findViewById(R.id.listview);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Mat tmp = adapter.getItem(position);
                    Intent intent = new Intent (Matalternativ.this, Pizza.class);
                    intent.putExtra("Namn", tmp.getName());
                    intent.putExtra("Location", tmp.getLocation());
                    intent.putExtra("Category", tmp.getCategory());
                    startActivity(intent);
                }
            });

            new JsonTask().execute("https://wwwlab.iit.his.se/brom/kurser/mobilprog/dbservice/admin/getdataasjson.php?type=a20caros");
        }catch (Exception e){
            Log.e("MainActivity ==>","Something went wrong when reading textfile:\n\n"+ e.getMessage());
        }
    }
    @SuppressLint("StaticFieldLeak")
    private class JsonTask extends AsyncTask<String, String, String> {
        private HttpURLConnection connection = null;
        private BufferedReader reader = null;

        protected String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null && !isCancelled()) {
                    builder.append(line).append("\n");
                }
                return builder.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String json) {
            Gson gson = new Gson();
            maträtter = gson.fromJson(json, Mat[].class);
            adapter = new ArrayAdapter<Mat>(Matalternativ.this, R.layout.list_textview,maträtter);
            listView = findViewById(R.id.listview);
            listView.setAdapter(adapter);
            for (int i = 0; i < maträtter.length; i++) {
                Log.d("==>", "Maträtt" + maträtter[i].getName());
            }
        }
    }
}