package com.example.a1127;

import androidx.annotation.Dimension;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//스레드 3p 4p 5p 6p
//메뉴 대화상자 4p

public class MainActivity extends AppCompatActivity{
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textview=new TextView(this);
        textview.setGravity(Gravity.CENTER_HORIZONTAL);
        textview.setTextSize(Dimension.SP, 30);
        setContentView(textview);
        textview.setText("작업중");
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textview.setBackgroundColor(Color.GREEN);
                        textview.setText("작업완료");
                    }
                });
            }
        }).start();
    }
}