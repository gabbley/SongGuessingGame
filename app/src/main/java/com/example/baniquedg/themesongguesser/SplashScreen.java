package com.example.baniquedg.themesongguesser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        programmerInfo();

    }

    //prints programmer info to the log
    public void programmerInfo(){

        Log.i("tag", "Programmed by: Gabby Baniqued");
    }
}
