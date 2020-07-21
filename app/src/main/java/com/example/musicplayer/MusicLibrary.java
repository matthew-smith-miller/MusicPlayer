package com.example.musicplayer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MusicLibrary {

    public static ArrayList<Album> albums;
    public static ArrayList<Album> recentAlbums;
    public static ArrayList<Song> songs;
    private static HashMap<Integer, Album> albumHashMap;

    public static void buildAlbums() {
        albums = new ArrayList<Album>(Arrays.asList(
                new Album("What's Going On",
                        "Marvin Gaye",
                        R.drawable.album_0,
                        new ArrayList<Song>(Arrays.asList(
                                new Song("What's Going On"),
                                new Song("What's Happening Brother"),
                                new Song("Flyin' High (In the Friendly Sky)"),
                                new Song("Save the Children"),
                                new Song("God Is Love"),
                                new Song("Mercy Mercy Me (The Ecology)"),
                                new Song("Right On"),
                                new Song("Wholy Holy"),
                                new Song("Inner City Blues (Make Me Wanna Holler)")))),
                new Album("DAMN.",
                        "Kendrick Lamar",
                        R.drawable.album_1,
                        new ArrayList<Song>(Arrays.asList(
                                new Song("BLOOD."),
                                new Song("DNA."),
                                new Song("YAH."),
                                new Song("ELEMENT."),
                                new Song("FEEL."),
                                new Song("LOYALTY. (FEATURING RIHANNA)"),
                                new Song("PRIDE."),
                                new Song("HUMBLE."),
                                new Song("LUST."),
                                new Song("LOVE. (FEATURING ZACARI)"),
                                new Song("XXX. (FEATURING U2)"),
                                new Song("FEAR."),
                                new Song("GOD."),
                                new Song("DUCKWORTH.")))),
                new Album("Stankonia",
                        "Outkast",
                        R.drawable.album_2,
                        new ArrayList<Song>(Arrays.asList(
                                new Song("Intro"),
                                new Song("Gasoline Dreams (featuring Khujo)"),
                                new Song("I'm Cool (interlude)"),
                                new Song("So Fresh, So Clean"),
                                new Song("Ms. Jackson"),
                                new Song("Snappin' & Trappin' (featuring Killer Mike and J-Sweet)"),
                                new Song("D.F. (interlude)"),
                                new Song("Spaghetti Junction"),
                                new Song("Kim & Cookie (interlude)"),
                                new Song("I'll Call B4 I Cum (featuring Gangsta Boo and Eco)"),
                                new Song("B.O.B."),
                                new Song("Xplosion (featuring B-Real)"),
                                new Song("Good Hair (interlude)"),
                                new Song("We Luv Deez Hoez (featuring Backbone and Big Gipp)"),
                                new Song("Humble Mumble (featuring Erykah Badu)"),
                                new Song("Drinkin' Again (interlude)"),
                                new Song("?"),
                                new Song("Red Velvet"),
                                new Song("Cruisin' in the ATL (interlude)"),
                                new Song("Gangsta Shit (featuring Slimm Calhoun, C-Bone and T-Mo)"),
                                new Song("Toilet Tisha"),
                                new Song("Slum Beautiful (featuring Cee-Lo)"),
                                new Song("Pre-Nump (interlude)"),
                                new Song("Stankonia (Stanklove) (featuring Big Rube and Sleepy Brown)")))),
                new Album("Awaken, My Love!",
                        "Childish Gambino",
                        R.drawable.album_3,
                        new ArrayList<Song>(Arrays.asList(
                                new Song("Me and Your Mama"),
                                new Song("Have Some Love"),
                                new Song("Boogieman"),
                                new Song("Zombies"),
                                new Song("Riot"),
                                new Song("Redbone"),
                                new Song("California"),
                                new Song("Terrified"),
                                new Song("Baby Boy"),
                                new Song("The Night Me and Your Mama Met"),
                                new Song("Stand Tall"))))));
                            /*new Album("That Carter III", "Lil Wayne"),
                            new Album("Take Care", "Drake"),
                            new Album("Things Fall Apart", "The Roots"),
                            new Album("Victory Lap", "Nipsey Hussle"),
                            new Album("The Miseducation of Lauryn Hill","Lauryn Hill")*/

        recentAlbums = new ArrayList<>();
        songs = new ArrayList<>();
        albumHashMap = new HashMap<>();
        for (Album album : albums) {
            songs.addAll(album.getSongs());
            albumHashMap.put(album.getAlbumId(), album);
            if (album.getIsRecent()) {
                recentAlbums.add(album);
            }
        }
    }

    public static Album getAlbumById(int id) {
        if (albumHashMap == null) {
            albumHashMap = new HashMap<>();
        }
        return albumHashMap.get(id);
    }

}
