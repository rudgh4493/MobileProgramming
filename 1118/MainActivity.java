package com.example.a1118;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    //05 8p 12p
    //06 1p 4p 7p
    //생명주기 순서   oncreate  onstart onresume    onpause onstop  ondestroy

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("액티비티A ", "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("액티비티A ", "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("액티비티A ", "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("액티비티A ", "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("액티비티A ", "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("액티비티A ", "onDestroy: ");
    }
}