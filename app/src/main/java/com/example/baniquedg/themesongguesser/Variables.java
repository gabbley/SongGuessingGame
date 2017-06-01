package com.example.baniquedg.themesongguesser;

import android.app.Application;

/**
 * Created by gabbley on 5/31/17.
 */

public class Variables extends Application{

    private String coins = "";
    private String username = "";

    public String getCoins(){
        return coins;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCoins(String coins) {
        this.coins = coins;
    }
}
