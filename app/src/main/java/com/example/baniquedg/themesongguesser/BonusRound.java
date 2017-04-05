package com.example.baniquedg.themesongguesser;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BonusRound extends AppCompatActivity {
    public GridLayout btns;
    public ArrayList<Button> btnList;
    public int numCorrect, numIncorrect;
    public TextView corr;
    public TextView incorr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      //  this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus_round);
        btns = (GridLayout) findViewById(R.id.gridButtons);
        btnList = new ArrayList<>();
        initialSetup();

    }

    public void initialSetup(){

        corr = (TextView) findViewById(R.id.lblCorrectScore);
        incorr = (TextView) findViewById(R.id.lblIncorrectScore);
        numIncorrect = 0;
        numCorrect = 0;
        corr.setText("0");
        incorr.setText("0");

        allButtons(); //places all buttons into an arrayList
        for (int i = 0; i<3; i++){ //randomly selects three buttons to color
            randomColorButton();
        }
    }

    //plays click sound every time button is clicked
    public void buttonClickSound(){
        MediaPlayer click = MediaPlayer.create(this, R.raw.click);
        click.start();
    }

    public void allButtons(){
        for (int i = 0; i<20; i++){
               btnList.add((Button) btns.getChildAt(i));
        }
    }

    public void whenBtnClicked(View view){
        //shuffleBtns(view);
        buttonClickSound();
        score();

    }

    public void randomColorButton(){
        int a = (int) Math.random() * btns.getChildCount();
        int b = (int) Math.random() * btns.getChildCount();
        int c = (int) Math.random() * btns.getChildCount();
        btnList.get(a).setBackgroundColor(Color.CYAN);
        btnList.get(b).setBackgroundColor(Color.CYAN);
        btnList.get(c).setBackgroundColor(Color.CYAN);
    }

    public void btnIsPlaying(){
        //if this button matches up with the song, it should be colored
    }

    public void shuffleBtns(View view){ //i dont think this works
        long seed = System.nanoTime();
        Collections.shuffle(btnList, new Random(seed));
    }

    public void score(){
        if (isCorrect()){
            numCorrect++;
            corr.setText(numCorrect + "");
        }
        else{
            numIncorrect++;
            incorr.setText(numIncorrect + "");
        }

    }

    public boolean isCorrect(){
        return true;
    }
}
