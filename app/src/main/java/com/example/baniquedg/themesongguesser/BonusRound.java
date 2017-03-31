package com.example.baniquedg.themesongguesser;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BonusRound extends AppCompatActivity {

    public GridLayout btns = (GridLayout) findViewById(R.id.gridButtons);
    public ArrayList<Button> btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus_round);

    }

    public void intialSetup(){
        allButtons(); //places all buttons into an arrayList
        for (int i = 0; i<3; i++){ //randomly selects three buttons to color
            randomColorButton();
        }
    }

    public void allButtons(){
        for (int i = 0; i<btns.getChildCount(); i++){
               btnList.add((Button) btns.getChildAt(i));
        }
    }

    public void whenBtnClicked(View view){
        shuffleBtns(view);
        score();
    }

    public void randomColorButton(){
        int n = (int) Math.random() * btns.getChildCount();
        btnList.get(n).setBackgroundColor(Color.CYAN);
    }

    public void btnIsPlaying(){
        //if this button matches up with the song, it should be colored
    }

    public void shuffleBtns(View view){
        long seed = System.nanoTime();
        Collections.shuffle(btnList, new Random(seed));
    }

    public void score(){

    }
}
