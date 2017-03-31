package com.example.baniquedg.themesongguesser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    public void playGame(View view){
        Class game = GuessSong.class;
        Intent intent = new Intent(this, game);
        startActivity(intent);
    }

    public void testBonus(View view){
        Class bonus = BonusRound.class;
        Intent intent = new Intent(this, bonus);
        startActivity(intent);
    }
}
