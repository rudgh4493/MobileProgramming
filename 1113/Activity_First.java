package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


//사용자인터페이스2 7p      인텐트 3p 4p 7p 9p
//refactor


public class Activity_First extends AppCompatActivity {
    private int GET_COUNTRY_NAME=1;
    private TextView textview_display;
    private int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        setTitle("첫번째 액티비티");
        textview_display=findViewById(R.id.textview_display);
        Button button=findViewById(R.id.button_countryNameInput);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Activity_Second.class);
                intent.putExtra("COUNTER", ++counter);
                startActivityForResult(intent, GET_COUNTRY_NAME);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GET_COUNTRY_NAME && resultCode==RESULT_OK){
            textview_display.setText(data.getStringExtra("COUNTRY_NAME"));
        }
    }
}