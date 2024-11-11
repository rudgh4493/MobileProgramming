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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private String city[]={"서울","부산","울산","대구","광주"};
    private TextView tv_title, tv1, tv2, tv3, tv4, tv5;
    private Spinner sp;
    private EditText et;
    private RadioButton rbn, rbs;
    private CheckBox chw, cha;
    private Button btn_submit;
    String seletedcity, s1 ;
    int passenger;

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

        ArrayAdapter ad=new ArrayAdapter(this, android.R.layout.simple_spinner_item, city);
        sp.setAdapter(ad);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                seletedcity = city[position];
                s1 = "목적지: "+city[position]+"\n";
                tv1.setText(s1);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        tv2.setText( "승차인원: (명)");

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
                passenger = Integer.parseInt(v);
                tv2.setText( "승차인원:"+Integer.parseInt(v)+" (명)");
            }
        });
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb.setLength(0);
                sb.append("목적지: "+seletedcity+"\n");
                sb.append("승차인원:"+passenger+" (명)\n");
                if(rbn.isChecked()) sb.append("좌석: 일반실\n");
                if(rbs.isChecked()) sb.append("좌석: 특실\n");
                if(chw.isChecked()) sb.append("창측 선호\n");
                if(cha.isChecked()) sb.append("복도측 선호\n");

            //    tv1.setText(sb.toString());

                Toast.makeText(getApplicationContext(), "제출: "+sb, Toast.LENGTH_SHORT).show();
                tv3부터 구현하면됌
            }
        });
    }



}