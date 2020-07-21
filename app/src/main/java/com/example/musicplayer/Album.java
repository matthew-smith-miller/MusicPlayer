package com.example.musicplayer;

import java.util.ArrayList;

public class Album {
    private static int mId;
    private String mAlbumTitle;
    private String mArtistName;
    private Boolean mIsRecent;
    private ArrayList<Song> mSongs;

    public Album(String albumTitle,
                 String artistName,
                 ArrayList<Song> songs) {
        mAlbumTitle = albumTitle;
        mArtistName = artistName;
        mSongs = songs;
        mId = mId + 1;
        mIsRecent = setRecentFlag();
    }

    public String getAlbumTitle() {
        return mAlbumTitle;
    }

    public String getArtistName() {
        return mArtistName;
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
