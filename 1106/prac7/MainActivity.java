package com.example.prac7;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private String city[]={"서울","부산","울산","대구","광주"};
    private TextView tv_title, tv1,tv2,tv3,tv4,tv5;
    private Spinner sp;
    private EditText et;
    private RadioButton rbn, rbs;
    private CheckBox chw, cha;
    private Button btn_submit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_title = findViewById(R.id.tv_title);
        sp = findViewById(R.id.sp);
        et = findViewById(R.id.et);
        rbn = findViewById(R.id.rbn);
        rbs = findViewById(R.id.rbs);
        chw = findViewById(R.id.chw);
        cha = findViewById(R.id.cha);
        btn_submit = findViewById(R.id.btn_submit);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        StringBuilder sb= new StringBuilder();
        String s1=new String()

        ArrayAdapter ad=new ArrayAdapter(this, android.R.layout.simple_spinner_item, city);
        sp.setAdapter(ad);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s1 = "목적지: "+city[position]+"\n";
                tv1.setText(s1);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                String v=et.getText().toString();
                if(v.length()<=0)   tv2.setText("");
                else tv2.setText( "승차인원:"+Integer.parseInt(v)+" (명)");
            }
        });

        if(rbn.isChecked()) tv3.setText("좌석: 일반실");
        if(rbs.isChecked()) tv3.setText("좌석: 특실");
        if(chw.isChecked()) tv4.setText("창측 선호");
        if(cha.isChecked()) tv5.setText("복도측 선호");


     /*   btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=et.getText().toString();
                StringBuilder sb=new StringBuilder();
                tv_display.setText(sb.toString());

//                sb.append("중국어회화가능여부: "+checkbox_chinese.isChecked()+"\n");
//                sb.append("한국인: "+radiobutton_korean.isChecked()+"\n");
//                sb.append("외국인: "+radiobutton_foreigner.isChecked()+"\n");
//                textview_display.setText(sb.toString());
            }
        });*/
    }



}