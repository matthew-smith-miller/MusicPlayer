package com.example.musicplayer;

import android.app.Activity;

import java.util.ArrayList;

public class Album {
    private static int idCounter;
    private int mId;
    private int mArtistId;
    private String mAlbumTitle;
    private int mAlbumArt;
    private Boolean mIsRecent;
    private ArrayList<Song> mSongs;

    public Album(String albumTitle,
                 int albumArt,
                 ArrayList<Song> songs) {
        mAlbumTitle = albumTitle;
        mAlbumArt = albumArt;
        mSongs = songs;
        idCounter++;
        mId = idCounter;
        mIsRecent = setRecentFlag();
    }

    public String getAlbumTitle() {
        return mAlbumTitle;
    }

    public int getAlbumId() {
        return mId;
    }

    public int getArtistId() {
        return mArtistId;
    }

    public void setArtistId(int artistId) {
        mArtistId = artistId;
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
