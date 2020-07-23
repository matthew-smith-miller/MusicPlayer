package com.example.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ArtistAdapter extends ArrayAdapter<Artist> {

    public ArtistAdapter(Context context, ArrayList<Artist> artists) {
        super(context, 0, artists);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_artist, parent, false);
        }

        //Get the Album object located at this position in the list
        Artist currentArtist = getItem(position);

        //Set album title and album artist
        ((TextView) listItemView.findViewById(R.id.list_artist_artist)).setText(
                currentArtist.getArtistName());
        ((ImageView) listItemView.findViewById(R.id.list_artist_image)).setImageResource(
                currentArtist.getArtistImage());
        listItemView.setTag(currentArtist.getArtistId());

        //Set OnClickListener to go to AlbumActivity
        listItemView.findViewById(R.id.album_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, AlbumActivity.class);
                intent.putExtra("album", Integer.parseInt(view.getTag().toString()));
                context.startActivity(intent);
            }
        });

        return listItemView;
    }
}
