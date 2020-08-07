package com.example.musicplayer;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SongsListActivity extends AppCompatActivity {

    FooterBar footerBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        SongAdapter songAdapter = new SongAdapter(this, MusicLibrary.songs);
        ((ListView) findViewById(R.id.list)).setAdapter(songAdapter);

        MusicLibrary.setFooter(this);
        footerBar = new FooterBar(this);
        footerBar.setRefreshCycle();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MusicLibrary.setFooter(this);
        footerBar.refreshTextAndImages();
    }
}
