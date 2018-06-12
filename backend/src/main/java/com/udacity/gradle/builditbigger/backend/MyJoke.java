package com.udacity.gradle.builditbigger.backend;

/** The object model for the data we are sending through endpoints */
public class MyJoke {

    private String myTextJoke;

    public String getMyTextJoke() {
        return myTextJoke;
    }

    public void setData(String data) {
        myTextJoke = data;
    }
}