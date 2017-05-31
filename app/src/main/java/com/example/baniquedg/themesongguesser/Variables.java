package com.example.baniquedg.themesongguesser;

import android.app.Application;

/**
 * Created by gabbley on 5/31/17.
 */

public class Variables extends Application{

    private String coins = "";

    public String getCoins(){
        return coins;
    }

    public void setCoins(){
        this.coins = coins;
    }

}
