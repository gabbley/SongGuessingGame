package com.example.baniquedg.themesongguesser;

import android.media.MediaPlayer;

/**
 * Created by baniquedg on 4/26/2017.
 */

public class Song {

    //fields
    private String songName;
    private String fileName;
    private MediaPlayer themeSong;

    //arraylist in app/main class that doesn't go away
    //how to use a class between different screens

    //default constructor
    Song(){
        songName = "no song";
        fileName = "file name";
        themeSong = null; //no file specified
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

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setThemeSong(MediaPlayer themeSong) {
        this.themeSong = themeSong;
    }





}
