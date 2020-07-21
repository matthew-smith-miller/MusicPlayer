package com.example.musicplayer;

import android.app.Activity;

import java.util.ArrayList;

public class Album {
    private static int idCounter;
    private int mId;
    private String mAlbumTitle;
    private String mArtistName;
    private int mAlbumArt;
    private Boolean mIsRecent;
    private ArrayList<Song> mSongs;

    public Album(String albumTitle,
                 String artistName,
                 int albumArt,
                 ArrayList<Song> songs) {
        mAlbumTitle = albumTitle;
        mArtistName = artistName;
        mAlbumArt = albumArt;
        mSongs = songs;
        idCounter++;
        mId = idCounter;
        mIsRecent = setRecentFlag();
    }

    public String getAlbumTitle() {
        return mAlbumTitle;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public int getAlbumId() {
        return mId;
    }

    public int getAlbumArt() {
        return mAlbumArt;
    }

    public ArrayList<Song> getSongs() {
        return mSongs;
    }

    public Boolean getIsRecent() {
        return mIsRecent;
    }

    private Boolean setRecentFlag() {
        if (Math.random() > 0.70) {
            return true;
        } else {
            return false;
        }
    }
}
