package com.example.musicplayer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ArtistActivity extends AppCompatActivity {

    Artist currentArtist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);
        currentArtist = MusicLibrary.getArtistById(
                getIntent().getExtras().getInt("artist"));

        ((TextView) findViewById(R.id.artist_name)).setText(currentArtist.getArtistName());
        ((ImageView) findViewById(R.id.artist_image)).setImageResource(
                currentArtist.getArtistImage());

        AlbumAdapter albumAdapter = new AlbumAdapter(this, currentArtist.getAlbums());
        ((ListView) findViewById(R.id.artist_albums)).setAdapter(albumAdapter);
    }
}