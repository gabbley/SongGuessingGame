package com.example.baniquedg.themesongguesser;

/**
 * Created by baniquedg on 6/1/2017.
 */

public class User {

    private String username;
    private int usercoins;

    public User(String name){
        username = name;
        usercoins = 0;
    }

    public User(String name, int coins){
        username = name;
        usercoins = coins;
    }

    public String getUsername() {
        return username;
    }

    public int getUsercoins() {
        return usercoins;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsercoins(int usercoins) {
        this.usercoins = usercoins;
    }
}
