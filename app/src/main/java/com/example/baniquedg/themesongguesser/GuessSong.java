package com.example.baniquedg.themesongguesser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GuessSong extends AppCompatActivity {

    //public ArrayList<MediaPlayer> playlist = new ArrayList<MediaPlayer>();
    public int numCorrect, numIncorrect;
    public TextView corr;
    public TextView incorr;
    public TextView timer;
    public static Activity a; //reference GuessSong.a
    private ArrayList<Song> playlist;
    private Song mySong;
    private String clickedTag;
    private String playingTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_song);
        initialSetup();
    }

    public void buttonClick(View view){
        //returns tag of clicked button
        Button b = (Button) findViewById(view.getId());
        clickedTag = b.getTag().toString();
        score();
       // buttonClickSound();
    }


/*    public void storeScores(User person){
        String fileName = "user_" + person.getUsername();
        String storedCoins =  "" + person.getUsercoins();

        try {
            FileOutputStream fos = openFileOutput(fileName, Context.MODE_PRIVATE);
            fos.write(storedCoins.getBytes());
            //fos.write(name.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String retrieveScores(User person){
        String fileName = "user_" + person.getUsername();
        String coinValue = "" + person.getUsercoins();

        try {
            FileInputStream fis = openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            coinValue = sb.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return coinValue;
    }*/

    public void initialSetup(){
        a = this;
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
        playlist = tempSongs();

        playSong(); //plays random song, sets field

    }

    public void playSong(){
        mySong = randSong(); //gets random song
        mySong.getThemeSong().start(); //starts playing
        playingTag = mySong.getSongName(); //sets field to song for comparison
        btnCorrect(mySong); //assigns a button to the song
        assignRandBtn(); //randomly assigns other buttons
    }

    public void assignRandBtn(){ //hard coded
        Song s1 = randSong();
        Song s2 = randSong();
        Song s3 = randSong();

        ImageButton opt1 = (ImageButton) findViewById(R.id.btnOption1);
        opt1.setTag(s1.getSongName());
        opt1.setImageResource(s1.getImgAlbum());


        ImageButton opt2 = (ImageButton) findViewById(R.id.btnOption2);
        opt2.setTag(s2.getSongName());
        opt2.setImageResource(s2.getImgAlbum());

        ImageButton opt3 = (ImageButton) findViewById(R.id.btnOption3);
        opt3.setTag(s3.getSongName());
        opt3.setImageResource(s3.getImgAlbum());
    }

    public void btnCorrect(Song s){
        ImageButton opt4 = (ImageButton) findViewById(R.id.btnOption4);
        opt4.setTag(s.getSongName());
        opt4.setImageResource(s.getImgAlbum());
    }

    public Song randSong(){
        return playlist.get((int) (Math.random() * playlist.size()));
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
         if (clickedTag.equals(playingTag)){
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

    public ArrayList<Song> tempSongs(){

        ArrayList<Song> playlist = new ArrayList<>();

        Song bigcomfycouch = new Song();
        bigcomfycouch.setSongName("big comfy couch");
        bigcomfycouch.setFileName("bigcomfycouch.mp3");
        bigcomfycouch.setImgAlbum(R.drawable.couch);
        MediaPlayer bigcomfycouchTheme = MediaPlayer.create(a, R.raw.bigcomfycouch);
        bigcomfycouch.setThemeSong(bigcomfycouchTheme);
        playlist.add(bigcomfycouch);

        Song blues = new Song();
        blues.setSongName("blues");
        blues.setFileName("blues.mp3");
        blues.setImgAlbum(R.drawable.blues);
        MediaPlayer bluesTheme = MediaPlayer.create(a, R.raw.bigcomfycouch);
        blues.setThemeSong(bluesTheme);
        playlist.add(blues);

        Song fairlyodd = new Song();
        fairlyodd.setSongName("fairlyodd");
        fairlyodd.setFileName("fairlyodd.mp3");
        fairlyodd.setImgAlbum(R.drawable.fairly);
        MediaPlayer fairlyoddTheme = MediaPlayer.create(a, R.raw.fairlyodd);
        fairlyodd.setThemeSong(fairlyoddTheme);
        playlist.add(fairlyodd);

        Song friends = new Song();
        friends.setSongName("friends");
        friends.setFileName("friends.mp3");
        friends.setImgAlbum(R.drawable.friends);
        MediaPlayer friendsTheme = MediaPlayer.create(a, R.raw.friends);
        friends.setThemeSong(friendsTheme);
        playlist.add(friends);

  /*      Song handymanny = new Song();
        handymanny = new Song();
        handymanny.setSongName("handymanny");
        handymanny.setFileName("handymanny.mp3");
        MediaPlayer handymannyTheme = MediaPlayer.create(a, R.raw.handymanny);
        handymanny.setThemeSong(handymannyTheme);
        playlist.add(handymanny);*/

   /*     Song hannahmontana = new Song();
        hannahmontana = new Song();
        hannahmontana.setSongName("hannahmontana");
        hannahmontana.setFileName("hannahmontana.mp3");
        MediaPlayer hannahmontanaTheme = MediaPlayer.create(a, R.raw.hannahmontana);
        hannahmontana.setThemeSong(hannahmontanaTheme);
        playlist.add(hannahmontana);*/

  /*      Song himym = new Song();
        himym = new Song();
        himym.setSongName("himym");
        himym.setFileName("himym.mp3");
        MediaPlayer himymTheme = MediaPlayer.create(a, R.raw.himym);
        himym.setThemeSong(himymTheme);
        playlist.add(himym);*/

      /*  Song icarly = new Song();
        icarly = new Song();
        icarly.setSongName("icarly");
        icarly.setFileName("icarly.mp3");
        MediaPlayer icarlyTheme = MediaPlayer.create(a, R.raw.icarly);
        icarly.setThemeSong(icarlyTheme);
        playlist.add(icarly);*/

        Song kim = new Song();
        kim.setSongName("kim");
        kim.setFileName("kim.mp3");
        kim.setImgAlbum(R.drawable.kim);
        MediaPlayer kimTheme = MediaPlayer.create(a, R.raw.kim);
        kim.setThemeSong(kimTheme);
        playlist.add(kim);


       /* Song lazytown = new Song();
        lazytown = new Song();
        lazytown.setSongName("lazytown");
        lazytown.setFileName("lazytown.mp3");
        MediaPlayer lazytownTheme = MediaPlayer.create(a, R.raw.lazytown);
        lazytown.setThemeSong(lazytownTheme);
        playlist.add(lazytown);*/

        Song sesamestreet = new Song();
        sesamestreet.setSongName("sesamestreet");
        sesamestreet.setFileName("sesamestreet.mp3");
        sesamestreet.setImgAlbum(R.drawable.sesamestreet);
        MediaPlayer sesameStreetTheme = MediaPlayer.create(a, R.raw.sesamestreet);
        sesamestreet.setThemeSong(sesameStreetTheme);
        playlist.add(sesamestreet);


        Song raven = new Song();
        raven.setSongName("raven");
        raven.setFileName("raven.mp3");
        raven.setImgAlbum(R.drawable.raven);
        MediaPlayer ravenTheme = MediaPlayer.create(a, R.raw.raven);
        raven.setThemeSong(ravenTheme);
        playlist.add(raven);

        Song spongebob = new Song();
        spongebob.setSongName("spongebob");
        spongebob.setFileName("spongebob.mp3");
        spongebob.setImgAlbum(R.drawable.spongebob);
        MediaPlayer spongebobTheme = MediaPlayer.create(a, R.raw.spongebob);
        spongebob.setThemeSong(spongebobTheme);
        playlist.add(spongebob);

        Song suitelife = new Song();
        suitelife.setSongName("suitelife");
        suitelife.setFileName("suitelife.mp3");
        suitelife.setImgAlbum(R.drawable.suitelife);
        MediaPlayer suitelifeTheme = MediaPlayer.create(a, R.raw.suitelife);
        suitelife.setThemeSong(suitelifeTheme);
        playlist.add(suitelife);

        Song victorious = new Song();
        victorious.setSongName("victorious");
        victorious.setFileName("victorious.mp3");
        victorious.setImgAlbum(R.drawable.victorious);
        MediaPlayer victoriousTheme = MediaPlayer.create(a, R.raw.victorious);
        victorious.setThemeSong(victoriousTheme);


        return playlist;
    }
}

