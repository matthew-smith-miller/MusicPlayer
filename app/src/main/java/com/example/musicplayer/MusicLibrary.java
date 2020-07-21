package com.example.musicplayer;

import java.util.ArrayList;
import java.util.Arrays;

public class MusicLibrary {

    public static ArrayList<Album> albums;
    public static ArrayList<Album> recentAlbums;

    public static void buildAlbums() {
        albums = new ArrayList<Album>(Arrays.asList(
                new Album("What's Goin' On", "Marvin Gaye"),
                new Album("DAMN.", "Kendrick Lamar"),
                new Album("The Miseducation of Lauryn Hill", "Lauryn Hill"),
                new Album("Stankonia", "Outkast"),
                new Album("That Carter III", "Lil Wayne"),
                new Album("Take Care", "Drake"),
                new Album("Things Fall Apart", "The Roots"),
                new Album("Awaken, My Love!", "Childish Gambino"),
                new Album("Victory Lap", "Nipsey Hussle")
        ));

        recentAlbums = new ArrayList<>();
        for (Album album : albums) {
            if (album.getIsRecent()) {
                recentAlbums.add(album);
            }
        }
    }

}
