package com.example.baniquedg.themesongguesser;

import android.app.Activity;
import android.app.Application;
import android.media.MediaPlayer;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by baniquedg on 4/26/2017.
 */

public class Song extends Application {

    //fields
    private String songName;
    private String fileName;
    private MediaPlayer themeSong;
    private String imgAlbum;
    private String btnTag;
    public Activity a;


    //arraylist in app/main class that doesn't go away
    //how to use a class between different screens

    //default constructor
    Song(){
        songName = "no song";
        fileName = "file name";
        themeSong = null; //no file specified
        imgAlbum = "no image";
        btnTag = "no btn";

    }

    public String getSongName() {
        return songName;
    }

    public String getFileName(){
        return fileName;
    }

    public MediaPlayer getThemeSong(){
        return themeSong;
    }

    public String getImgAlbum(){
        return imgAlbum;
    }

    public String getBtnTag(){
        return btnTag;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setThemeSong(MediaPlayer themeSong) {
        this.themeSong = themeSong;
    }

    public void setImgAlbum(String imgAlbum){
        this.imgAlbum = imgAlbum;
    }

    public void setBtnTag(String btnTag) {
        this.btnTag = btnTag;
    }

    /*   public Song tempSongs(){

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

        return playlist.get(1); //make this one random
    }*/


}
