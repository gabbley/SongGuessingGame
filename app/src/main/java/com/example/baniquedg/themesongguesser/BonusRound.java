package com.example.baniquedg.themesongguesser;

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
    public TextView timer;

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

        corr = (TextView) findViewById(R.id.lblCorrectScore);
        incorr = (TextView) findViewById(R.id.lblIncorrectScore);
        numIncorrect = 0;
        numCorrect = 0;
        corr.setText("0");
        incorr.setText("0");
        timer.setText("0");
        choices = new ArrayList<>();

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
        if (isCorrect()){
            numCorrect++;
            corr.setText(numCorrect + "");
        }
        else{
            numIncorrect++;
            incorr.setText(numIncorrect + "");
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

    public Song tempSongs(){

        ArrayList<Song> playlist = new ArrayList<>();

        Song backyardigans = new Song();
        backyardigans.setSongName("backyardigans");
        backyardigans.setFileName("backyardigans.mp3");
        MediaPlayer backyardigansTheme = MediaPlayer.create(this, R.raw.backyardigans);
        backyardigans.setThemeSong(backyardigansTheme);
        playlist.add(backyardigans);



        Song bigcomfycouch = new Song();
        bigcomfycouch = new Song();
        bigcomfycouch.setSongName("big comfy couch");
        bigcomfycouch.setFileName("bigcomfycouch.mp3");
        MediaPlayer bigcomfycouchTheme = MediaPlayer.create(this, R.raw.bigcomfycouch);
        bigcomfycouch.setThemeSong(bigcomfycouchTheme);
        playlist.add(bigcomfycouch);

        Song blues = new Song();
        blues = new Song();
        blues.setSongName("blues");
        blues.setFileName("blues.mp3");
        MediaPlayer bluesTheme = MediaPlayer.create(this, R.raw.bigcomfycouch);
        blues.setThemeSong(bluesTheme);
        playlist.add(blues);

        Song fairlyodd = new Song();
        fairlyodd = new Song();
        fairlyodd.setSongName("fairlyodd");
        fairlyodd.setFileName("fairlyodd.mp3");
        MediaPlayer fairlyoddTheme = MediaPlayer.create(this, R.raw.fairlyodd);
        fairlyodd.setThemeSong(fairlyoddTheme);
        playlist.add(fairlyodd);

        Song friends = new Song();
        friends = new Song();
        friends.setSongName("friends");
        friends.setFileName("friends.mp3");
        MediaPlayer friendsTheme = MediaPlayer.create(this, R.raw.friends);
        friends.setThemeSong(friendsTheme);
        playlist.add(friends);

        Song handymanny = new Song();
        handymanny = new Song();
        handymanny.setSongName("handymanny");
        handymanny.setFileName("handymanny.mp3");
        MediaPlayer handymannyTheme = MediaPlayer.create(this, R.raw.handymanny);
        handymanny.setThemeSong(handymannyTheme);
        playlist.add(handymanny);

        Song hannahmontana = new Song();
        hannahmontana = new Song();
        hannahmontana.setSongName("hannahmontana");
        hannahmontana.setFileName("hannahmontana.mp3");
        MediaPlayer hannahmontanaTheme = MediaPlayer.create(this, R.raw.hannahmontana);
        hannahmontana.setThemeSong(hannahmontanaTheme);
        playlist.add(hannahmontana);

        Song himym = new Song();
        himym = new Song();
        himym.setSongName("himym");
        himym.setFileName("himym.mp3");
        MediaPlayer himymTheme = MediaPlayer.create(this, R.raw.himym);
        himym.setThemeSong(himymTheme);
        playlist.add(himym);

        Song icarly = new Song();
        icarly = new Song();
        icarly.setSongName("icarly");
        icarly.setFileName("icarly.mp3");
        MediaPlayer icarlyTheme = MediaPlayer.create(this, R.raw.icarly);
        icarly.setThemeSong(icarlyTheme);
        playlist.add(icarly);

        Song kim = new Song();
        kim = new Song();
        kim.setSongName("kim");
        kim.setFileName("kim.mp3");
        MediaPlayer kimTheme = MediaPlayer.create(this, R.raw.kim);
        kim.setThemeSong(kimTheme);
        playlist.add(kim);

        Song lazytown = new Song();
        lazytown = new Song();
        lazytown.setSongName("kim");
        lazytown.setFileName("kim.mp3");
        MediaPlayer lazytownTheme = MediaPlayer.create(this, R.raw.lazytown);
        lazytown.setThemeSong(lazytownTheme);
        playlist.add(kim);


        return playlist.get(1); //make this one random
    }

}
