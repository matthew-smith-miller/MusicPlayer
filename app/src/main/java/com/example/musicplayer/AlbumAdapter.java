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

public class AlbumAdapter extends ArrayAdapter<Album> {

    public AlbumAdapter(Context context, ArrayList<Album> albums) {
        super(context, 0, albums);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_album, parent, false);
        }

        //Get the Album object located at this position in the list
        Album currentAlbum = getItem(position);

        //Set album title and album artist
        ((TextView) listItemView.findViewById(R.id.list_album_title)).setText(
                currentAlbum.getAlbumTitle());
        ((TextView) listItemView.findViewById(R.id.list_album_artist)).setText(
                currentAlbum.getArtistName());

        return listItemView;
    }
}
