package com.example.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_song, parent, false);
        }

        //Get the Album object located at this position in the list
        Song currentSong = getItem(position);

        //Set album title and album artist
        ((TextView) listItemView.findViewById(R.id.list_song_title)).setText(
                currentSong.getSongTitle());
        ((TextView) listItemView.findViewById(R.id.list_song_length)).setText(
                currentSong.getSongLength());
        listItemView.setTag(currentSong.getSongId());

        //Set OnClickListener to go to PlaySongActivity
        listItemView.findViewById(R.id.song_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, PlaySongActivity.class);
                MusicLibrary.playSongFromBeginning(MusicLibrary.getSongById((Integer.parseInt(
                        view.getTag().toString()))));
                context.startActivity(intent);
            }
        });

        return listItemView;
    }
}
