package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //
//    int total;//field
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        int total2; //local
//
//    Calc.add(11,22);
//
//        double degree=2.34;
//        int a[]=new int[3];
//        a[0]=12;
//
//    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textveiw1=findViewById(R.id.textview1);
        textveiw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textveiw1.setBackgroundColor(Color.GREEN);
            }
        });
    }
}