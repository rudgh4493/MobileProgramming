package com.example.a1007practice2;

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
        EditText edittext_input=findViewById(R.id.edittext_input);
        Button button_convert=findViewById(R.id.button_convert);
        TextView textView_display=findViewById(R.id.textview_display);
        button_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s= edittext_input.getText().toString();
                if(view.getId()==R.id.button_convert)
                    textView_display.setText(Integer.toString(s.length()));
            }
        });
    }
}

