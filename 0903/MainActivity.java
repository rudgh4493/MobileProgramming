package com.example.a0904;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        TextView tV=new TextView(this);
        tV.setText("안녕하세요");
        tV.getTextSize();
        tV.setGravity(Gravity.CENTER);

        setContentView(tV);
    }
}

