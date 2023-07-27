package com.example.proj1_year2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Switch switch1;
    EditText firstNum;
    EditText mulOrPlus;
    Intent mainActivity2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switch1 = findViewById(R.id.choice1);
        firstNum = findViewById(R.id.first_num);
        mulOrPlus = findViewById(R.id.mulOrPlus);
        mainActivity2 = new Intent(this, serie.class);
    }

    public void clicked(View view) {
        if(switch1.isChecked())
        {
            switch1.setText("Geometric");
        }
        else
        {
            switch1.setText("Math");
        }


    }

    public void next_activity(View view) {
        mainActivity2.putExtra("choice", switch1.isChecked());
        String check = "";
        String check2 = "";
        int flag = 0;
        check = firstNum.getText().toString();
        check2 = mulOrPlus.getText().toString();
        if(check.equals(".") || check.equals("-") || check.equals("-.") || check.equals(".-") || check2.equals(".") || check2.equals("-") || check2.equals("-.") || check2.equals(".-"))
        {
            Toast.makeText(getApplicationContext(), "illegal input", Toast.LENGTH_SHORT).show();
            flag = 1;
        }
        if(check.length() == 0)
        {
            Toast.makeText(getApplicationContext(), "must enter the first num", Toast.LENGTH_SHORT).show();
            flag = 1;
        }
        else
        {
            mainActivity2.putExtra("first_num", Double.parseDouble(check));

        }
        if(check2.length() == 0)
        {
            Toast.makeText(getApplicationContext(), "must enter progressor", Toast.LENGTH_SHORT).show();
            flag = 1;
        }
        else
        {
            mainActivity2.putExtra("progressor", Double.parseDouble(check2));
        }

        if(flag == 0)
        {
            startActivity(mainActivity2);
        }


    }
}