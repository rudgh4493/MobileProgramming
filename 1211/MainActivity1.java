package com.example.a1211;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

//010 10


public class MainActivity1 extends AppCompatActivity {
    EditText edittext_memo, edittext_display;
    Button button_save, button_read;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext_memo=findViewById(R.id.edittext_memo);
        edittext_display=findViewById(R.id.edittext_display);
        button_save=findViewById(R.id.button_save);
        button_read=findViewById(R.id.button_read);
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { button_save_job(); }
        });
        button_read.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { button_read_job(); }
        });
    }
    private void button_read_job() {
        try {
            FileInputStream fis = openFileInput("memo.txt");
            InputStreamReader iF=new InputStreamReader(fis);
            char buf[]=new char[3];
            edittext_display.setText("");
            while(true){
                int len=iF.read(buf);
                if(len==-1) break;
                edittext_display.append(new String(buf, 0, len));
            }
            iF.close();
        } catch (Exception e) { e.printStackTrace(); }
    }
    private void button_save_job() {
        try {
            FileOutputStream oF=openFileOutput("memo.txt", MODE_APPEND);
            String s=edittext_memo.getText().toString()+"\n";
            oF.write(s.getBytes());
            oF.close();
        } catch (Exception e) { e.printStackTrace(); }
    }
}