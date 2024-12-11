package com.example.a1211;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.net.URL;

public class ContentActivity extends AppCompatActivity {
    ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        imageview=findViewById(R.id.imageview);
        Intent intent=getIntent();
        String imageUrl=intent.getStringExtra("IMAGE_URL");
        new Thread(()->displayImage(imageUrl)).start();
    }

    private void displayImage(String imageUrl) {
        try {
            URL url=new URL(imageUrl);
            Bitmap bitmap= BitmapFactory.decodeStream(url.openStream());
            runOnUiThread(()->imageview.setImageBitmap(bitmap));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


