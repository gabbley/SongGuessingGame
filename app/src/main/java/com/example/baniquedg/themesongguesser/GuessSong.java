package com.example.baniquedg.themesongguesser;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class GuessSong extends AppCompatActivity {

    //public ArrayList<MediaPlayer> playlist = new ArrayList<MediaPlayer>();
    public int numCorrect, numIncorrect;
    public TextView corr;
    public TextView incorr;
    public TextView timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_song);
        initialSetup();
    }

    public String whichButtonClicked(){
        //returns String of show to field
        return "";
    }

    public void buttonClick(View view){
        score();
        buttonClickSound();
    }

    public void initialSetup(){
        corr = (TextView) findViewById(R.id.lblCorrectScore);
        incorr = (TextView) findViewById(R.id.lblIncorrectScore);
        timer = (TextView) findViewById(R.id.lblTimer);
        numIncorrect = 0;
        numCorrect = 0;
        corr.setText("0");
        incorr.setText("0");
        TextView title = (TextView) findViewById(R.id.txtGameTitle);
        discoTitle(title);
        startTimer();
    }

    public void compareSong(){

    }

    public void resetScreen(View view){
        initialSetup();
    }

    //plays click sound every time button is clicked
    public void buttonClickSound(){
        MediaPlayer click = MediaPlayer.create(this, R.raw.click);
        click.start();
    }

    //brings user to home screen
    public void homeScreen(View view) {
       goToClass(HomeScreen.class);
    }

    //updates score
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

    //checks score
    public void check(){
        if (numCorrect == 15){
            goToClass(BonusRound.class);
        }
        else if (numIncorrect == 10){
            goToClass(LoseScreen.class);
        }
    }

    public void goToClass(Class c){
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }

    //determines if guess is correct
    public boolean isCorrect(){
        return true;
    }

    public void discoTitle(final TextView disco){
        Thread t = new Thread() {


            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(500);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                disco.setTextColor(randColor());
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();
    }

    //returns a random color to set word to
    public int randColor(){

        int[] colorArray = new int[] {Color.YELLOW, Color.GREEN,
                Color.RED, Color.BLUE, Color.MAGENTA, Color.BLACK};

        return colorArray[(int)(Math.random() * colorArray.length) ];
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

