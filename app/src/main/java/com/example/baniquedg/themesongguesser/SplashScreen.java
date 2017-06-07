package com.example.baniquedg.themesongguesser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

       // programmerInfo(); //Logs programmer info to the screen

        Thread homeScreen = new Thread() {

            public void run() {

                //splash opens for 3 seconds, then to home screen
                try {
                    sleep(3000);
                    Intent login = new Intent(SplashScreen.this, LoginScreen.class);
                    startActivity(login);
                    finish();
                }
                //prints out errors
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };

        //Start thread
        homeScreen.start();
    }

    //prints programmer info to the log
    public void programmerInfo(){

        Log.i("tag", "Programmed by: Gabby Baniqued");
    }
}
