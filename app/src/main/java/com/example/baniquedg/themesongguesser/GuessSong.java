package com.example.baniquedg.themesongguesser;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
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
        numIncorrect = 0;
        numCorrect = 0;
        corr.setText("0");
        incorr.setText("0");
        TextView title = (TextView) findViewById(R.id.txtGameTitle);
        discoTitle(title);
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


    //places all theme songs in an ArrayList
    public ArrayList<MediaPlayer> arrSongs(ArrayList<MediaPlayer> playlist){
        playlist.add(MediaPlayer.create(this, R.raw.backyardigans));
        playlist.add(MediaPlayer.create(this, R.raw.bigcomfycouch));
        playlist.add(MediaPlayer.create(this, R.raw.blues));
        playlist.add(MediaPlayer.create(this, R.raw.fairlyodd));
        playlist.add(MediaPlayer.create(this, R.raw.friends));
        playlist.add(MediaPlayer.create(this, R.raw.hannahmontana));
        playlist.add(MediaPlayer.create(this, R.raw.himym));
        playlist.add(MediaPlayer.create(this, R.raw.icarly));
        playlist.add(MediaPlayer.create(this, R.raw.kim));
        playlist.add(MediaPlayer.create(this, R.raw.lazytown));
        playlist.add(MediaPlayer.create(this, R.raw.lilostitch));
        playlist.add(MediaPlayer.create(this, R.raw.onetreehill));
        playlist.add(MediaPlayer.create(this, R.raw.proud));
        playlist.add(MediaPlayer.create(this, R.raw.raven));
        playlist.add(MediaPlayer.create(this, R.raw.sesamestreet));
        playlist.add(MediaPlayer.create(this, R.raw.spongebob));
        playlist.add(MediaPlayer.create(this, R.raw.suitelife));
        playlist.add(MediaPlayer.create(this, R.raw.victorious));
        playlist.add(MediaPlayer.create(this, R.raw.wizards));
        playlist.add(MediaPlayer.create(this, R.raw.wonderpets));


       /* MediaPlayer backyardigans = MediaPlayer.create(this, R.raw.backyardigans);
        MediaPlayer bigcomfycouch = MediaPlayer.create(this, R.raw.bigcomfycouch);
        MediaPlayer blues = MediaPlayer.create(this, R.raw.blues);
        MediaPlayer fairlyodd = MediaPlayer.create(this, R.raw.fairlyodd);
        MediaPlayer friends = MediaPlayer.create(this, R.raw.friends);
        MediaPlayer handymanny = MediaPlayer.create(this, R.raw.handymanny);
        MediaPlayer hannahmontana = MediaPlayer.create(this, R.raw.hannahmontana);
        MediaPlayer himym = MediaPlayer.create(this, R.raw.himym);
        MediaPlayer icarly = MediaPlayer.create(this, R.raw.icarly);
        MediaPlayer kim = MediaPlayer.create(this, R.raw.kim);
        MediaPlayer lazytown = MediaPlayer.create(this, R.raw.lazytown);
        MediaPlayer lilostitch = MediaPlayer.create(this, R.raw.lilostitch);
        MediaPlayer onetreehill = MediaPlayer.create(this, R.raw.onetreehill);
        MediaPlayer proud = MediaPlayer.create(this, R.raw.proud);
        MediaPlayer raven = MediaPlayer.create(this, R.raw.raven);
        MediaPlayer sesamestreet = MediaPlayer.create(this, R.raw.sesamestreet);
        MediaPlayer spongebob = MediaPlayer.create(this, R.raw.spongebob);
        MediaPlayer suitelife = MediaPlayer.create(this, R.raw.suitelife);
        MediaPlayer victorious = MediaPlayer.create(this, R.raw.victorious);
        MediaPlayer wizards = MediaPlayer.create(this, R.raw.wizards);
        MediaPlayer wonderpets = MediaPlayer.create(this, R.raw.wonderpets);
        */
        return playlist;
    }

    //brings user to home screen
    public void homeScreen(View view) {
        Class home = HomeScreen.class;
        Intent intent = new Intent(this, home);
        startActivity(intent);
    }

    //updates score
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
}

