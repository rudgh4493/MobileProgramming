package com.example.a1002;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText  edittext_input = findViewById(R.id.edittext_input);
        Button  button_convert = findViewById(R.id.button_convert);
        TextView  textview_display = findViewById(R.id.textview_display);
        button_convert.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String s= edittext_input.getText()+"";
                if(s.length()<=0)return;
                textview_display.setText(Double.parseDouble(s)*0.3025+"(평)");
                
            }
        });
    }
}

