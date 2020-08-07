package com.example.musicplayer;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ArtistsListActivity extends AppCompatActivity {

    FooterBar footerBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArtistAdapter artistAdapter = new ArtistAdapter(this, MusicLibrary.artists);
        ((ListView) findViewById(R.id.list)).setAdapter(artistAdapter);

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
