package com.example.loginandroid_29_09_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity{
    private static final long SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.SplashScreen);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user_m);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                MainActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}