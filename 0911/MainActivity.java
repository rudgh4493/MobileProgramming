package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override





    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    /*  setContentView(R.layout.activity_main);
        TextView textview = findViewById(R.id.textview);
        textview.setText("대한민국");
*/
        TextView t = new TextView(this);
        t.setText("겨ㅁㄴㅇㄹㄴㅇㄴㅁㅇ");
        t.setTextSize(30);
        t.setGravity(Gravity.CENTER);
        setContentView(t);


    }
}

////시험문제 - 다음 괄호부분 빈칸 채우기
//setContentView(R.layout.activity_main);
//    TextView textview = findViewById(R.id.textview);
