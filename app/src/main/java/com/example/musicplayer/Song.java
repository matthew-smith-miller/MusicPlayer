package com.example.musicplayer;

public class Song {

    private String mTitle;
    private int mLength;
    private static int idCounter;
    private int mId;
    private int mArtistId;
    private int mAlbumId;
    private int mTrackNumber;

    public Song(String title) {
        mTitle = title;
        mLength = setRandomLength();
        idCounter++;
        mId = idCounter;
    }

    private int setRandomLength() {
        return (int) (120 + Math.random() * 240);
    }

    public String getSongTitle() {
        return mTitle;
    }

    public String getSongLength() {
        return MusicLibrary.convertTime(mLength);
    }

    public int getSongLengthInt() {
        return mLength;
    }

    public int getSongId() {
        return mId;
    }

    public int getArtistId() {
        return mArtistId;
    }

    public void setArtistId(int artistId) {
        mArtistId = artistId;
    }

    public int getAlbumId() {
        return mAlbumId;
    }

    public void setAlbumId(int albumId) {
        mAlbumId = albumId;
    }

    public int getTrackNumber() {
        return mTrackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        mTrackNumber = trackNumber;
    }
}
