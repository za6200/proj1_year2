package com.example.proj1_year2;

import static java.lang.Math.pow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class serie extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listSerie1;
    Intent serie2;
    TextView x1;
    TextView d;
    TextView n;
    TextView Sn;
    Double numbers[];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serie);
        serie2 = getIntent();
        listSerie1 = findViewById(R.id.list_serie);
        x1 = findViewById(R.id.x1);
        d = findViewById(R.id.d);
        n = findViewById(R.id.n);
        Sn = findViewById(R.id.Sn);
        numbers = new Double[20];
        numbers[0] = serie2.getDoubleExtra("first_num", 0);
        for (int i = 1; i < 20; i++) {
            if (serie2.getBooleanExtra("choice", false)) {
                numbers[i] = serie2.getDoubleExtra("first_num", 0) * pow(serie2.getDoubleExtra("progressor", 0), i);
            } else {
                numbers[i] = serie2.getDoubleExtra("first_num", 0) + i * serie2.getDoubleExtra("progressor", 0);

            }
        }
        ArrayAdapter<Double> adp = new ArrayAdapter<Double>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, numbers);
        listSerie1.setAdapter(adp);
        listSerie1.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        x1.setText("X1= " + serie2.getDoubleExtra("first_num", 0));
        d.setText("d= " + serie2.getDoubleExtra("progressor", 0));
        position = position + 1;
        n.setText("n= " + position);
        double sum = 0;
        for (int i = 0; i <= position - 1; i++) {
            sum += numbers[i];
        }
        Sn.setText("Sn= " + sum);
    }
}
