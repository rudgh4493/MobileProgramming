package com.example.a1204;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

//009 14 16 17


public class MainActivity2 extends AppCompatActivity {
    EditText edittext_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext_date = findViewById(R.id.edittext_date);
        edittext_date.setFocusable(false);
        edittext_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext_date_job();
            }
        });
    }

    private void edittext_date_job() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                edittext_date.setText(year + "년 " + (month + 1) + "월 " + dayOfMonth + "일");
            }
        }, year, month, day);

        dialog.show();
    }
}
