package com.example.a1007;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_convert=findViewById(R.id.button_convert);
        TextView textView_display=findViewById(R.id.textview_display);
        button_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView_display.setText("정답: 서울");
            }
        });
    }
}