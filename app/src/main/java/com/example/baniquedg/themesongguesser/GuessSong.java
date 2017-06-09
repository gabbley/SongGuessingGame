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
    private CountDownTimer counter;
    private ImageButton opt1, opt2, opt3, opt4;
    private String justPlayed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_song);
        initialSetup();
    }

    public void buttonClick(View view){
        buttonClickSound();

        //returns tag of clicked button for comparison
        ImageButton b = (ImageButton) findViewById(view.getId());
        clickedTag = b.getTag().toString();

        //updates score accordingly
        score();
        playSong();

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
        mySong = randSong();

        playSong(); //plays random song, sets field

    }


    public void playSong(){
        justPlayed = mySong.getSongName();
       /* if (mySong.getThemeSong().isPlaying()){
            mySong.getThemeSong().stop();
        }*/

        mySong = randSong();

        while (mySong.getSongName().equals(justPlayed)) {
            mySong = randSong(); //gets random song
        }

        mySong.getThemeSong().start(); //starts playing
        playingTag = mySong.getSongName(); //sets field to song for comparison
        btnCorrect(mySong); //assigns a button to the song
        assignRandBtn(); //randomly assigns other buttons
        justPlayed = mySong.getSongName();
    }

    public void assignRandBtn(){ //hard coded
        Song s1 = randSong();
        Song s2 = randSong();
        Song s3 = randSong();

        opt1 = (ImageButton) findViewById(R.id.btnOption1);
        opt2 = (ImageButton) findViewById(R.id.btnOption2);
        opt4 = (ImageButton) findViewById(R.id.btnOption4);

        opt1.setTag(s1.getSongName());
        opt1.setImageResource(s1.getImgAlbum());

        opt2.setTag(s2.getSongName());
        opt2.setImageResource(s2.getImgAlbum());

        opt4.setTag(s3.getSongName());
        opt4.setImageResource(s3.getImgAlbum());
    }

    public void btnCorrect(Song s){
        opt3 = (ImageButton) findViewById(R.id.btnOption3);
        opt3.setTag(s.getSongName());
        opt3.setImageResource(s.getImgAlbum());
    }

    public Song randSong(){
        return playlist.get((int) (Math.random() * playlist.size()));
    }

    public void resetScreen(View view){
        if(counter != null) {
            counter.cancel();
            counter = null;
        }
        initialSetup();
    }

    //plays click sound every time button is clicked
    public void buttonClickSound(){
        MediaPlayer click = MediaPlayer.create(this, R.raw.click);
        click.start();
    }

    //brings user to home screen
    public void homeScreen(View view) {
        if(counter != null) {
            counter.cancel();
            counter = null;
        }
       goToClass(HomeScreen.class);
    }

    //updates score
    public void score(){
        check();
         if (clickedTag.equals(playingTag)){ //user correct answer
            mySong.getThemeSong().stop();
             numCorrect++;
            corr.setText(numCorrect + "");
        }
        else{ //user incorrect answer
             mySong.getThemeSong().stop();
            numIncorrect++;
            incorr.setText(numIncorrect + "");
        }

    }

    //checks score
    public void check(){
        if (numCorrect == 10){ //win condition
            if(counter != null) {
                counter.cancel();
                counter = null;
            }
            goToClass(WinScreen.class);
            // goToClass(BonusRound.class);
        }
        else if (numIncorrect == 10){ //lose condition
            goToClass(LoseScreen.class);
        }
    }

    //goes to specified class
    public void goToClass(Class c){
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }


    //adds "disco" effect to TextView
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

    //starts timer in game
    public void startTimer(){
        counter = new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("time left: " + millisUntilFinished / 1000 + " secs");
            }

            //calls lose screen if win condition is not achieved in 30 seconds
            public void onFinish() {
                timer.setText("time left: 0 secs");
                goToClass(LoseScreen.class);
            }
        }.start();

    }

    //hard coded songs
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
        MediaPlayer bluesTheme = MediaPlayer.create(a, R.raw.blues);
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

        Song lilostitch = new Song();
        lilostitch.setSongName("lilo");
        lilostitch.setFileName("lilostitch.mp3");
        lilostitch.setImgAlbum(R.drawable.lilo);
        MediaPlayer lilostitchTheme = MediaPlayer.create(a, R.raw.lilostitch);
        lilostitch.setThemeSong(lilostitchTheme);
        playlist.add(lilostitch);

        Song kim = new Song();
        kim.setSongName("kim");
        kim.setFileName("kim.mp3");
        kim.setImgAlbum(R.drawable.kim);
        MediaPlayer kimTheme = MediaPlayer.create(a, R.raw.kim);
        kim.setThemeSong(kimTheme);
        playlist.add(kim);

        Song proud = new Song();
        proud.setSongName("proud");
        proud.setFileName("proud.mp3");
        proud.setImgAlbum(R.drawable.proud);
        MediaPlayer proudTheme = MediaPlayer.create(a, R.raw.proud);
        proud.setThemeSong(proudTheme);
        playlist.add(proud);

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
        playlist.add(victorious);

        Song wizards = new Song();
        wizards.setSongName("wizards");
        wizards.setFileName("wizards.mp3");
        wizards.setImgAlbum(R.drawable.wizards);
        MediaPlayer wizardsTheme = MediaPlayer.create(a, R.raw.wizards);
        wizards.setThemeSong(wizardsTheme);
        playlist.add(wizards);



        return playlist;
    }
}

