package com.example.proj1_year2;

import static java.lang.Math.pow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class serie extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView listSerie1;
    Intent serie2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serie);
        serie2 = getIntent();
        listSerie1 = findViewById(R.id.list_serie);
        Double numbers[] = new Double[19];
        numbers[0] = serie2.getDoubleExtra("first_num", 0);
        for (int i = 1; i < 19; i++) {
            if (serie2.getBooleanExtra("choice", false)) {
                numbers[i] = serie2.getDoubleExtra("first_num", 0) * pow(serie2.getDoubleExtra("progressor", 0), i);
            } else {
                numbers[i] = serie2.getDoubleExtra("first_num", 0) + (i - 1) * serie2.getDoubleExtra("progressor", 0);
            }
        }
        ArrayAdapter<Double> adp = new ArrayAdapter<Double>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, numbers);
        listSerie1.setAdapter(adp);
    }
}