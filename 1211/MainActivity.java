package com.example.a1211;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedList;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

//010 10
//012 03

public class MainActivity extends AppCompatActivity {
    DBHelper dbHelper=new DBHelper(this);
    EditText edittext_memo, edittext_display;
    Button button_save, button_read;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext_memo=findViewById(R.id.edittext_memo);
        edittext_display=findViewById(R.id.edittext_display);
        button_read=findViewById(R.id.button_read);
        button_save=findViewById(R.id.button_save);
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.insert(edittext_memo.getText().toString());
            }
        });
        button_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.select(edittext_display);
            }
        });
    }
}