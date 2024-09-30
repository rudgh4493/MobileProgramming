package com.example.a0930;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        Speakable s=new Speakable();
//        s.speak();
//
//        Dog dog = new Dog();
//        System.out.println(dog.speak());
//        Speakable cat=new Speakable() {
//            @Override
//            public String speak() {
//
//            }
//        }
        /*

        textview.setOnClickListener( (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 v.setBackgroundColor(Color.GREEN);
            }
        });
        -> textview.setOnClickListener(  v -> v.setBackgroundColor(Color.GREEN));
        람다식으로 작성가능
*/

        TextView tv=findViewById(R.id.textview1);


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.GREEN);
            }
        });
    }

}