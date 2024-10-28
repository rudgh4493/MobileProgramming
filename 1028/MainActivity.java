package com.example.a1028;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textview_display;
    CheckBox checkbox_english, checkbox_chinese, checkbox_lock;
    RadioButton radiobutton_korean,radiobutton_foreigner;
    Button button_confirm, button_clear;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview_display=findViewById(R.id.textview_display);
        checkbox_chinese=findViewById(R.id.checkbox_chinese);
        checkbox_english=findViewById(R.id.checkbox_english);
        radiobutton_korean=findViewById(R.id.radiobutton_korean);
        radiobutton_foreigner=findViewById(R.id.radiobutton_foreigner);
        button_confirm=findViewById(R.id.button_confirm);
        button_clear=findViewById(R.id.button_clear);
        checkbox_lock= findViewById(R.id.checkbox_lock);

        checkbox_lock.setOnCheckedChangeListener((a, isChecked)->lockUnlock(!isChecked) );

        button_clear.setOnClickListener((v)->button_clear_job());

        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_clear_job();
            }
        });
        button_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "";
                s+="영어 대화 가능"+checkbox_english.isChecked()+"\n";
                s+="중국어 대화 가능"+checkbox_chinese.isChecked()+"\n";
                s+="한국인"+radiobutton_korean.isChecked()+"\n";
                s+="외국인"+radiobutton_foreigner.isChecked()+"\n";
                textview_display.setText(s);

            }
        });

    }

    private void lockUnlock(boolean b){
        checkbox_english.setEnabled(b);
        checkbox_chinese.setEnabled(b);
        radiobutton_foreigner.setEnabled(b);
        radiobutton_korean.setEnabled(b);
        textview_display.setEnabled(b);
        button_clear.setEnabled(b);
        button_confirm.setEnabled(b);

    }

    private void button_clear_job() {
        checkbox_english.setChecked(false);
        checkbox_chinese.setChecked(false);
        radiobutton_korean.setChecked(false);
        radiobutton_foreigner.setChecked(false);
        textview_display.setText("");
    }


}