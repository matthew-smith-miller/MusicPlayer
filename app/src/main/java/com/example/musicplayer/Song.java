package com.example.musicplayer;

public class Song {

    private String mTitle;
    private int mLength;

    public Song(String title) {
        mTitle = title;
        mLength = setRandomLength();
    }

    private int setRandomLength() {
        return (int) (120 + Math.random() * 240);
    }

    public String getSongTitle() {
        return mTitle;
    }

    public String getSongLength() {
        String lengthText = "";
        lengthText += (int) Math.floor(mLength / 60);
        lengthText += ":";
        if (mLength % 60 < 10) {
            lengthText += "0";
        }
        lengthText += mLength % 60;
        return lengthText;
    }
}
