package com.example.a1104;


import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


public class MainActivity2 extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textview=new TextView(this);
        textview.setText("터치하면배경색이변경됩니다.");
        textview.setTextSize(25);
        textview.setGravity(Gravity.CENTER);
        setContentView(textview);
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeColor(v);
            }
        });
    }
    private void changeColor(View v) {
        Random random=new Random();
        int color=Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(256));
        v.setBackgroundColor(color);
        Toast.makeText( this, "Color value "+color, Toast.LENGTH_SHORT).show();
        //Toast.makeText( MainActivity.this, "Color value "+color, Toast.LENGTH_SHORT).show();
        //Toast.makeText( getApplicationContext(), "Color value "+color, Toast.LENGTH_SHORT).show();
    }
}