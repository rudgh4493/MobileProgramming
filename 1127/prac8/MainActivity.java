package com.example.prac8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
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

        LayoutInflater inflater=getLayoutInflater();
        LinearLayout edittext= (LinearLayout) inflater.inflate(R.layout.display_1, null);
        LinearLayout radiogroup= (LinearLayout) inflater.inflate(R.layout.display_2, null);

        EditText et1 = edittext.findViewById(R.id.et1);
        RadioButton rb3 = radiogroup.findViewById(R.id.rb3);
        RadioButton rb4 = radiogroup.findViewById(R.id.rb4);

        RadioButton rb1=findViewById(R.id.rb1);
        rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) ll.addView(edittext);
                else ll.removeView(edittext);
            }
        });
        RadioButton rb2=findViewById(R.id.rb2);
        rb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) ll.addView(radiogroup);
                else ll.removeView(radiogroup);
            }
        });
    }
}