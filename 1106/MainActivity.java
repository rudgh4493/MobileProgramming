package com.example.a1106;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout ll = new LinearLayout(this);
        ll.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        ll.setBackgroundColor(Color.parseColor("#F0F0F0"));
        ll.setOrientation(LinearLayout.VERTICAL);

        TextView tv1 = new TextView(this);
        tv1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tv1.setBackgroundColor(Color.parseColor("#FFAB15"));
        tv1.setText(" TextView1 ");

// 여기에 다른 TextView 객체(tv2, tv3 등) 추가 코드가 있어야 합니다.

        ll.addView(tv1);

        setContentView(ll);

    }
}