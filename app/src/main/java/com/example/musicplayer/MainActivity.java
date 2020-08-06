package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    FooterBar footerBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!MusicLibrary.getIsMusicLibraryCreated()) {
            MusicLibrary.buildMusicLibrary();
        }
        populateRecentAlbums();

        //Set onClickListeners for buttons on bottom
        findViewById(R.id.button_albums).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), AlbumsListActivity.class));
            }
        });
        findViewById(R.id.button_artists).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), ArtistsListActivity.class));
            }
        });
        findViewById(R.id.button_songs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), SongsListActivity.class));
            }
        });

        MusicLibrary.setFooter(this);
        footerBar = new FooterBar(this);
        footerBar.setRefreshCycle();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MusicLibrary.setFooter(this);
        footerBar.refreshTextAndImages();
        populateRecentAlbums();
    }

    private void populateRecentAlbums() {
        AlbumAdapter albumAdapter = new AlbumAdapter(this, MusicLibrary.recentAlbums);
        ((ListView) findViewById(R.id.recent_albums)).setAdapter(albumAdapter);
    }

}