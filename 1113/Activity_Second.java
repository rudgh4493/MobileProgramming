package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_Second extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("두번째 액티비티");
        TextView textview_display=findViewById(R.id.textview_display);
        EditText edittext_countryName=findViewById(R.id.edittext_countryName);
        Button button=findViewById(R.id.button_return);
        Intent intent=getIntent();
        edittext_countryName.setHint("입력 시도 "+intent.getIntExtra("COUNTER",0)+"번째");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("COUNTRY_NAME", edittext_countryName.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}