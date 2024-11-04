package com.example.a1104;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private TextView tv_display;
    private Button btn_show;
    private RadioButton rbwh, rbbr, rbbl;
    private EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        rbwh = findViewById(R.id.rbwh);
        rbbr = findViewById(R.id.rbbr);
        rbbl = findViewById(R.id.rbbl);
        btn_show = findViewById(R.id.btn_show);
        tv_display = findViewById(R.id.tv_display);

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=et1.getText().toString();
                StringBuilder sb=new StringBuilder();
                sb.append("[가로: "tv_display.setText(s)"\n");
                tv_display.setText(sb.toString());

//                sb.append("중국어회화가능여부: "+checkbox_chinese.isChecked()+"\n");
//                sb.append("한국인: "+radiobutton_korean.isChecked()+"\n");
//                sb.append("외국인: "+radiobutton_foreigner.isChecked()+"\n");
//                textview_display.setText(sb.toString());
            }
        });
    }



}
