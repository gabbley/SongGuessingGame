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



}
