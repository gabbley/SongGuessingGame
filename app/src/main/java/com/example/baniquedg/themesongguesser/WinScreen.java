package com.example.baniquedg.themesongguesser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WinScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_screen);
    }

    public void playAgain(View view){
        goToClass(GuessSong.class);
    }

    public void goToClass(Class c){
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}
