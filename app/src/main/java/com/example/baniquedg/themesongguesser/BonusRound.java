package com.example.baniquedg.themesongguesser;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
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
    public ArrayList<Button> choices;
    public TextView timer, user;
    public Activity a;
    public Variables username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus_round);
        btns = (GridLayout) findViewById(R.id.gridButtons);
        btnList = new ArrayList<>();
        allButtons(); //places all buttons into an arrayList
        initialSetup();

    }

    public void initialSetup(){

        username = (Variables) this.getApplication();
        corr = (TextView) findViewById(R.id.lblCorrectScore);
        incorr = (TextView) findViewById(R.id.lblIncorrectScore);
        numIncorrect = 0;
        numCorrect = 0;
        corr.setText("0");
        incorr.setText("0");
        timer.setText("0");// String s = (Variables) this.getApplication().getCoins()
        user.setText(username.getUsername());
        choices = new ArrayList<>();
        a = this;



        buttonSelect();
    }

    public void buttonSelect(){
        for (int i = 0; i<5; i++){ //randomly selects five buttons to color
            Button b1 = randomColorButton();
            if (choices.size()>0)
             if (choices.indexOf(b1) == -1)
            b1.setBackgroundColor(randColor());
           /* else {
                if (choices.indexOf(randomColorButton()) == -1){
                    Button b2 = randomColorButton();
                    b2.setBackgroundColor(randColor());
                }
            }*/

                //recursive?
        }
    }

    //plays click sound every time button is clicked
    public void buttonClickSound(){
        MediaPlayer click = MediaPlayer.create(this, R.raw.click);
        click.start();
    }

    public void allButtons(){
        for (int i = 0; i<20; i++){
            Button b = (Button) (btns.getChildAt(i));
            b.setBackgroundColor(Color.LTGRAY);
            btnList.add(b);
        }

    }

    public void whenBtnClicked(View view){
       // shuffleBtns(view);
        buttonClickSound();
        score();
        buttonSelect();
        decolor();
        buttonSelect();

    }

    public Button randomColorButton(){
        int a = (int) (Math.random() * btns.getChildCount());
        Button opt = btnList.get(a);
        choices.add(opt);
        return opt;
    }

    public void decolor(){
        for (int i = 0; i<choices.size(); i++){
                choices.get(i).setBackgroundColor(Color.LTGRAY);
        }
    }

    public void btnIsPlaying(){
        //if this button matches up with the song, it should be colored
    }

    public void shuffleBtns(View view){ //i dont think this works
        long seed = System.nanoTime();
        Collections.shuffle(btnList, new Random(seed));
    }
    //returns a random color to set word to
    public int randColor(){

        int[] colorArray = new int[] {Color.YELLOW, Color.GREEN,
                Color.RED, Color.BLUE, Color.MAGENTA, Color.BLACK};

        return colorArray[(int)(Math.random() * colorArray.length) ];
    }

    public void score(){
        check();
        if (isCorrect()){
            numCorrect++;
            corr.setText(numCorrect + "");
        }
        else{
            numIncorrect++;
            incorr.setText(numIncorrect + "");
        }

    }

    public void check(){
        if (numCorrect == 10){
            goToClass(WinScreen.class);
        }
    }
    public void goToClass(Class c){
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }

    public boolean isCorrect(){
        return true;
    }

    public void startTimer(){
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("time left: " + millisUntilFinished / 1000 + " secs");
            }

            public void onFinish() {
                timer.setText("time left: 0 secs");
                goToClass(LoseScreen.class);
            }
        }.start();

    }






}
