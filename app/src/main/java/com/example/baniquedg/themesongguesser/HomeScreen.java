package com.example.baniquedg.themesongguesser;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {

    public ArrayList<Song> playlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        initialSetup();
    }

    public void playGame(View view){
        goToClass(GuessSong.class);
    }

    public void initialSetup(){
        playlist = new ArrayList<>();

    }

    public void testBonus(View view){
        goToClass(BonusRound.class);

    }

    public void goToClass(Class c){
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }

    public Song getRandomSong(){

        return new Song();
    }

    public ArrayList<Song> fillPlaylist(ArrayList<Song> arr, int n){

        for (int i = 0; i<n; i++){
            arr.add(getRandomSong());
        }

        return arr;
    }


}
