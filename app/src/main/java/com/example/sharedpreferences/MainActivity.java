package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etNama = findViewById(R.id.etNama);
        EditText etUsia = findViewById(R.id.etUsia);

        Spinner spinJeniskel = findViewById(R.id.spinJensikel);
        String[] jeniskel = new String[]{"Laki-Laki","Perempuan"};
        ArrayAdapter<String> listadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,jeniskel);
        spinJeniskel.setAdapter(listadapter);

        sharedPreferences = getSharedPreferences("data1",MODE_PRIVATE);
        sharedPreferences.contains("nama");
        sharedPreferences.contains("jeniskel");
        sharedPreferences.contains("usia");

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("nama",etNama.getText().toString());
                editor.putString("jeniskel",spinJeniskel.getSelectedItem().toString());
                editor.putInt("usia",Integer.parseInt(etUsia.getText().toString()));
                editor.apply();

                etNama.setText("");
                spinJeniskel.setSelection(0);
                etUsia.setText("");
            }
        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}