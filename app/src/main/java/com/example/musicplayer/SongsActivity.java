package com.example.musicplayer;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ((TextView) findViewById(R.id.list_header)).setText("Songs");

        AlbumAdapter albumAdapter = new AlbumAdapter(this, MusicLibrary.albums);
        ((ListView) findViewById(R.id.list)).setAdapter(albumAdapter);
    }
}
