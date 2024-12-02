package com.example.a1202;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//009 04 05 06 07 08 09

public class MainActivity1 extends AppCompatActivity{
    EditText edittext_memo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext_memo=findViewById(R.id.edittext_memo);
    }
    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.optionsmenu_italic){
            edittext_memo.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
        }
        else if(item.getItemId()==R.id.optionsmenu_bold){
            edittext_memo.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        }
        else if(item.getItemId()==R.id.optionsmenu_normal) {
            edittext_memo.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        }
        return super.onOptionsItemSelected(item);
    }
}