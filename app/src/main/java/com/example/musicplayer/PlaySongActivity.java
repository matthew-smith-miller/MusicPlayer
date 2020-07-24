package com.example.musicplayer;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlaySongActivity extends AppCompatActivity {

    Song currentSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);
        currentSong = MusicLibrary.getSongById(
                getIntent().getExtras().getInt("song"));

        //((TextView) findViewById(R.id.artist_name)).setText(currentSong.getArtistName());
        //((ImageView) findViewById(R.id.artist_image)).setImageResource(
        //       currentSong.getArtistImage());
    }
}