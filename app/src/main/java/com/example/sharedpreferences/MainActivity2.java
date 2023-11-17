package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tvnama = findViewById(R.id.tvNama);
        TextView tvjeniskel = findViewById(R.id.tvJenisKel);
        TextView tvusia = findViewById(R.id.tvUsia);

        sharedPreferences = getSharedPreferences("data1",MODE_PRIVATE);
        tvnama.setText(sharedPreferences.getString("nama",null));
        tvjeniskel.setText(sharedPreferences.getString("jeniskel",null));
        tvusia.setText(""+sharedPreferences.getInt("usia",0));
    }
}