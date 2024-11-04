package com.example.a1104;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;



public class MainActivity1 extends AppCompatActivity {
    private static final String TAG = "액티비티->선택된 색 값 출력";
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
                Random random=new Random();
                int color= Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(256));
                v.setBackgroundColor(color);
                Log.i(TAG, "onClick: "+"Color value "+color);
            }
        });
    }
}