package com.example.musicplayer;

import android.os.CountDownTimer;
import android.util.Log;

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
    private static Boolean isSongPlaying;
    private static Song currentSong;
    private static int currentSongPosition;
    private static CountDownTimer countDownTimer;

    public static void buildMusicLibrary() {
        countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                //nothing
            }

            @Override
            public void onFinish() {
                //nothing
            }
        };

        artists = new ArrayList<>(Arrays.asList(
                new Artist(
                        "Dale Erkins",
                        R.drawable.artist_2,
                        new ArrayList<>(Arrays.asList(
                                new Album("Wide Open Highway",
                                        R.drawable.album_10,
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
                                        R.drawable.album_8,
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
                        "Frankie Pirelli",
                        R.drawable.artist_0,
                        new ArrayList<>(Arrays.asList(
                                new Album("Frankie Sings Frank",
                                        R.drawable.album_2,
                                        new ArrayList<Song>(Arrays.asList(
                                                new Song("All or Nothing"),
                                                new Song("I'll Never Smile Again"),
                                                new Song("My Way"),
                                                new Song("I've Got the World On A String"),
                                                new Song("Young At Heart"),
                                                new Song("New York, New York"),
                                                new Song("Fly Me To The Moon"),
                                                new Song("Summer Wind"),
                                                new Song("That's Life"),
                                                new Song("Chicago"))))
                        ))),
                new Artist(
                        "Jimmy Tropic",
                        R.drawable.artist_1,
                        new ArrayList<>(Arrays.asList(
                                new Album("Margarita Town",
                                        R.drawable.album_0,
                                        new ArrayList<Song>(Arrays.asList(
                                                new Song("Palm Trees"),
                                                new Song("Adios Amigos"),
                                                new Song("Margarita Town"),
                                                new Song("Party O'Clock"),
                                                new Song("Miranda"),
                                                new Song("Hey, Bartender"),
                                                new Song("Seashells"),
                                                new Song("I Commute on a Surfboard"),
                                                new Song("Sandy Feet"),
                                                new Song("Anything But Mine"),
                                                new Song("Seagulls"),
                                                new Song("Ferris Wheel"),
                                                new Song("Rum and Papayas"))))
                        ))),
                new Artist(
                        "Juan Ruiz",
                        R.drawable.artist_4,
                        new ArrayList<>(Arrays.asList(
                                new Album("Águila",
                                        R.drawable.album_5,
                                        new ArrayList<Song>(Arrays.asList(
                                                new Song("El muro parte II"),
                                                new Song("Nuestra América"),
                                                new Song("Sin duda"),
                                                new Song("Hasta que el cuerpo aguante"),
                                                new Song("Mira"),
                                                new Song("La Rosita"),
                                                new Song("Altura"),
                                                new Song("Renacimiento"),
                                                new Song("Fantasma"),
                                                new Song("Justicia"),
                                                new Song("Ya no"),
                                                new Song("La puerta"),
                                                new Song("Calibán")))),
                                new Album("Vagabundo",
                                        R.drawable.album_9,
                                        new ArrayList<Song>(Arrays.asList(
                                                new Song("Arco iris"),
                                                new Song("Si no me ves"),
                                                new Song("Radio Libertad"),
                                                new Song("Tenochtitlan"),
                                                new Song("El muro"),
                                                new Song("TRON feat. M-Cat"),
                                                new Song("Telaraña"),
                                                new Song("Ojalá que venga la primavera"),
                                                new Song("Juventud"),
                                                new Song("Seguro"))))
                        ))),
                new Artist(
                        "M-Cat",
                        R.drawable.artist_3,
                        new ArrayList<>(Arrays.asList(
                                new Album("What's The News",
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
                album.setArtistId(artist.getArtistId());
                albums.add(album);
                ArrayList albumSongs = album.getSongs();
                for (int i = 0; i < albumSongs.size(); i++) {
                    ((Song) albumSongs.get(i)).setArtistId(artist.getArtistId());
                    ((Song) albumSongs.get(i)).setAlbumId(album.getAlbumId());
                    ((Song) albumSongs.get(i)).setTrackNumber(i);
                    songs.add((Song) albumSongs.get(i));
                    songHashMap.put(((Song) albumSongs.get(i)).getSongId(),
                            (Song) albumSongs.get(i));
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

    public static boolean getIsSongPlaying() {
        return isSongPlaying;
    }

    public static String convertTime(int lengthInSeconds) {
        String lengthText = "";
        lengthText += (int) Math.floor(lengthInSeconds / 60);
        lengthText += ":";
        if (lengthInSeconds % 60 < 10) {
            lengthText += "0";
        }
        lengthText += lengthInSeconds % 60;
        return lengthText;
    }

    public static int getCurrentSongPosition() {
        return currentSongPosition;
    }

    public static Song getCurrentSong() {
        return currentSong;
    }

    public static void playSongFromBeginning(Song song) {
        countDownTimer.cancel();
        currentSong = song;
        currentSongPosition = -1;
        isSongPlaying = true;
        playSongFromCurrentPosition();
    }

    public static void togglePlay() {
        if (isSongPlaying) {
            isSongPlaying = false;
            countDownTimer.cancel();
        } else {
            playSongFromCurrentPosition();
        }
    }

    public static void playSongFromCurrentPosition() {
        countDownTimer.cancel();
        isSongPlaying = true;
        countDownTimer = new CountDownTimer(((currentSong.getSongLengthInt() -
                currentSongPosition) * 1000), 1000) {
            public void onTick(long millisUntilFinished) {
                Log.d(this.getClass().getName(), String.valueOf(currentSongPosition));
                currentSongPosition++;
            }

            public void onFinish() {
                actionForward();
                playSongFromCurrentPosition();
            }
        }.start();
    }

    public static void actionForward() {
        countDownTimer.cancel();
        if (currentSong.getTrackNumber() + 1 == getAlbumById(
                currentSong.getAlbumId()).getSongs().size()) {
            currentSong = getAlbumById(
                    currentSong.getAlbumId()).getSongs().get(0);
            currentSongPosition = 0;
            isSongPlaying = false;
        } else {
            currentSong = MusicLibrary.getAlbumById(
                    currentSong.getAlbumId()).getSongs().get(
                    currentSong.getTrackNumber() + 1);
            if (isSongPlaying) {
                playSongFromBeginning(currentSong);
            } else {
                currentSongPosition = 0;
            }
        }
    }

    public static void actionBack() {
        countDownTimer.cancel();
        if (currentSongPosition < 3 && currentSong.getTrackNumber() != 0) {
            currentSong = getAlbumById(
                    currentSong.getAlbumId()).getSongs().get(currentSong.getTrackNumber() - 1);
        }
        if (isSongPlaying) {
            playSongFromBeginning(currentSong);
        } else {
            currentSongPosition = 0;
        }
    }
}
