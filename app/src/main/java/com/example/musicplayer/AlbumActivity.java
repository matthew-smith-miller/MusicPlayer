package com.example.musicplayer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AlbumActivity extends AppCompatActivity {

    Album currentAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        currentAlbum = MusicLibrary.getAlbumById(
                getIntent().getExtras().getInt("album"));

        ((TextView) findViewById(R.id.album_title)).setText(currentAlbum.getAlbumTitle());
        ((TextView) findViewById(R.id.album_artist)).setText(MusicLibrary.getArtistById(
                currentAlbum.getArtistId()).getArtistName());
        ((ImageView) findViewById(R.id.album_art)).setImageResource(currentAlbum.getAlbumArt());

        SongAdapter songAdapter = new SongAdapter(this, currentAlbum.getSongs());
        ((ListView) findViewById(R.id.list)).setAdapter(songAdapter);
    }
}
