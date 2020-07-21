package com.example.musicplayer;

public class Album {
    private static int mId;
    private String mAlbumTitle;
    private String mArtistName;
    private Boolean mIsRecent;

    public Album(String albumTitle,
                 String artistName) {
        mAlbumTitle = albumTitle;
        mArtistName = artistName;
        mId = mId + 1;
        mIsRecent = setRecentFlag();
    }

    public String getAlbumTitle() {
        return mAlbumTitle;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public Boolean getIsRecent() {
        return mIsRecent;
    }

    private Boolean setRecentFlag() {
        if (Math.random() > 0.75) {
            return true;
        } else {
            return false;
        }
    }
}
