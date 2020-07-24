package com.example.musicplayer;

import java.util.ArrayList;

public class Artist {
    private static int idCounter;
    private String mName;
    private ArrayList<Album> mAlbums;
    int mArtistImage;
    int mId;

    public Artist(String name, int artistImage, ArrayList<Album> albums) {
        mName = name;
        mArtistImage = artistImage;
        mAlbums = albums;
        idCounter++;
        mId = idCounter;
    }

    public String getArtistName() {
        return mName;
    }

    public ArrayList<Album> getAlbums() {
        return mAlbums;
    }

    public int getArtistImage() {
        return mArtistImage;
    }

    public int getArtistId() {
        return mId;
    }
}
