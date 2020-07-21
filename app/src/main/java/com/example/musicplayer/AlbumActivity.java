package com.example.musicplayer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AlbumActivity extends AppCompatActivity {

    Album currentAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        ((TextView) findViewById(R.id.album_title)).setText("");
        ((TextView) findViewById(R.id.album_artist)).setText("");

        SongAdapter songAdapter = new SongAdapter(this, currentAlbum.getSongs());
        ((ListView) findViewById(R.id.list)).setAdapter(songAdapter);
    }
}
