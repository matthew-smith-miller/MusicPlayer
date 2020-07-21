package com.example.musicplayer;

import android.content.Context;
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
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
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

        return listItemView;
    }
}