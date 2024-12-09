package com.example.a1209;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


//010 02 03 04


public class MainActivity extends AppCompatActivity {
    private static final String MEMO = "MEMO";
    EditText edittext_title, edittext_memo;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        edittext_memo=findViewById(R.id.edittext_memo);
        pref=getSharedPreferences("myPref", MODE_PRIVATE);
        if(pref.contains(MEMO)) edittext_memo.setText(pref.getString(MEMO, ""));
    }
    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences pref=getSharedPreferences("myPref", MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putString(MEMO, edittext_memo.getText().toString());
        editor.apply();
    }
}