package com.example.prac8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout ll=findViewById(R.id.ll);
        EditText edittext= findViewById(R.id.et1);
        RadioGroup radiogroup= findViewById(R.id.rg1);

        EditText et1 = edittext.findViewById(R.id.et1);
        RadioGroup rg1 = radiogroup.findViewById(R.id.rg1);

        RadioButton rb3 = radiogroup.findViewById(R.id.rb3);
        RadioButton rb4 = radiogroup.findViewById(R.id.rb4);
        et1.setVisibility(View.GONE);
        rg1.setVisibility(View.GONE);

        RadioButton rb1=findViewById(R.id.rb1);
        rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) et1.setVisibility(View.VISIBLE);
                else et1.setVisibility(View.GONE);
            }
        });
        RadioButton rb2=findViewById(R.id.rb2);
        rb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) rg1.setVisibility(View.VISIBLE);
                else rg1.setVisibility(View.GONE);
            }
        });
    }
}