package com.example.musicplayer;

public class Artist {
    private static int idCounter;
    String mName;
    int mArtistImage;
    int mId;

    public Artist(String name, int artistImage) {
        mName = name;
        mArtistImage = artistImage;
        idCounter++;
        mId = idCounter;
    }

    public String getArtistName() {
        return mName;
    }

    public int getArtistImage() {
        return mArtistImage;
    }

    public int getArtistId() {
        return mId;
    }
}
