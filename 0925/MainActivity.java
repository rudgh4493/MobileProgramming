package com.example.a0925;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/*
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Person p;//객체참조변수 선언
        p=new Person("홍길동");
        Person p2=new Person();

        Student s= new Student();
        s.name="김철수";

        Car car=new Car();
        car.setColor(Colorable.RED);

        Robot robot=new Robot();
        robot.setColor(Colorable.RED);

        Colorable truck= new Colorable() {
            @Override
            public void setColor(int color) {

            }
        }

    }
}
*/
public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textview1=findViewById(R.id.textview1);
        textview1.setOnClickListener(new OnC());
        textview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview1.setBackgroundColor(Color.GREEN);
            }
        });


        }
}