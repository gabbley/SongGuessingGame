package com.example.baniquedg.themesongguesser;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class GuessSong extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_song);
    }

    public String whichButtonClicked(){
        //returns String of show to field
        return "";
    }

    public void compareSong(){

    }

    public void buttonClickSound(){
        //plays sound every time button is clicked
        MediaPlayer click = MediaPlayer.create(this, R.raw.click);
        click.start();
    }

    public ArrayList<MediaPlayer> arrSongs(){
        MediaPlayer backyardigans = MediaPlayer.create(this, R.raw.backyardigans);
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
    }
}
