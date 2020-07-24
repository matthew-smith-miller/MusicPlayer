package com.example.musicplayer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MusicLibrary {

    public static ArrayList<Artist> artists;
    public static ArrayList<Album> albums;
    public static ArrayList<Album> recentAlbums;
    public static ArrayList<Song> songs;
    private static HashMap<Integer, Artist> artistHashMap;
    private static HashMap<Integer, Album> albumHashMap;
    private static HashMap<Integer, Song> songHashMap;

    public static void buildMusicLibrary() {
        artists = new ArrayList<>(Arrays.asList(
                new Artist(
                        "Dale Earkins",
                        R.drawable.artist_2,
                        new ArrayList<>(Arrays.asList(
                                new Album("Wide Open Highway",
                                        "Dale Earkins",
                                        R.drawable.album_0,
                                        new ArrayList<Song>(Arrays.asList(
                                                new Song("Cowboy Love"),
                                                new Song("Alberta Skies"),
                                                new Song("I Bet You Can't"),
                                                new Song("Calgary Girls"),
                                                new Song("Ain't it Friday Yet?"),
                                                new Song("Busted Tires But I'm Still Smiling"),
                                                new Song("My First Bass"),
                                                new Song("Tomatoes and Tomatillos (feat. Juan Ruiz)"),
                                                new Song("Missoula")))),
                                new Album("Next Time",
                                        "Dale Earkins",
                                        R.drawable.album_1,
                                        new ArrayList<Song>(Arrays.asList(
                                                new Song("Sally Goodin"),
                                                new Song("Next Time"),
                                                new Song("Bend in the River (feat. Alice Laramore)"),
                                                new Song("Turbo"),
                                                new Song("Hot Cheetos 'n Suds"),
                                                new Song("Curtis the Slugger"),
                                                new Song("Pickup Truck Angel"),
                                                new Song("Kalispell"),
                                                new Song("Damned if I Do"),
                                                new Song("Lake Trout"),
                                                new Song("Always"),
                                                new Song("Daddy's Train"),
                                                new Song("I'll Fly Away"))))
                        ))),
                new Artist(
                        "M-Cat",
                        R.drawable.artist_3,
                        new ArrayList<>(Arrays.asList(
                                new Album("What's The News",
                                        "M-Cat",
                                        R.drawable.album_7,
                                        new ArrayList<Song>(Arrays.asList(
                                                new Song("INTRO (GET IT)"),
                                                new Song("A-2 (FEAT. THA N-DAWG)"),
                                                new Song("STUDIO VIBE"),
                                                new Song("AVOCADO TOAST"),
                                                new Song("3 AM"),
                                                new Song("DROP IT"),
                                                new Song("TRUTH"),
                                                new Song("THYME OUT"),
                                                new Song("P.A.S.T.A"))))
                        )))));

        albums = new ArrayList<>();
        recentAlbums = new ArrayList<>();
        songs = new ArrayList<>();
        albumHashMap = new HashMap<>();
        artistHashMap = new HashMap<>();
        songHashMap = new HashMap<>();
        for (Artist artist : artists) {
            artistHashMap.put(artist.getArtistId(), artist);
            for (Album album : artist.getAlbums()) {
                albums.add(album);
                for (Song song : album.getSongs()) {
                    songs.add(song);
                    songHashMap.put(song.getSongId(), song);
                }
                albumHashMap.put(album.getAlbumId(), album);
                if (album.getIsRecent()) {
                    recentAlbums.add(album);
                }
            }
        }
    }

    public static Album getAlbumById(int id) {
        if (albumHashMap == null) {
            albumHashMap = new HashMap<>();
        }
        return albumHashMap.get(id);
    }

    public static Artist getArtistById(int id) {
        if (artistHashMap == null) {
            artistHashMap = new HashMap<>();
        }
        return artistHashMap.get(id);
    }

    public static Song getSongById(int id) {
        if (songHashMap == null) {
            songHashMap = new HashMap<>();
        }
        return songHashMap.get(id);
    }

}
