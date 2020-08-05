package com.example.baptcmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class ImageScreen extends AppCompatActivity {

    Handler handler;
    Runnable runnable;
    ImageView baptclogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_screen);

        baptclogo = findViewById(R.id.baptclogo);
        baptclogo.animate().alpha(4000).setDuration(0);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent dsp = new Intent(ImageScreen.this,LoginForm.class);
                startActivity(dsp);
                finish();
            }
        },4000);
    }
}