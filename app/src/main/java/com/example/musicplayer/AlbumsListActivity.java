package com.example.musicplayer;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class AlbumsListActivity extends AppCompatActivity {

    FooterBar footerBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        AlbumAdapter albumAdapter = new AlbumAdapter(this, MusicLibrary.albums);
        ((ListView) findViewById(R.id.list)).setAdapter(albumAdapter);

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
