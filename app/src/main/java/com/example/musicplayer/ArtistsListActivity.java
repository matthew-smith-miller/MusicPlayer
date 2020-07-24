package com.example.musicplayer;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ArtistsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArtistAdapter artistAdapter = new ArtistAdapter(this, MusicLibrary.artists);
        ((ListView) findViewById(R.id.list)).setAdapter(artistAdapter);
    }
}
