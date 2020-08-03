package com.example.musicplayer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlaySongActivity extends AppCompatActivity {

    Song currentSong;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

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

        currentSong = MusicLibrary.getSongById(
                getIntent().getExtras().getInt("song"));
        setTextAndImages(currentSong);
        Log.d(this.getLocalClassName(), MusicLibrary.getIsSongPlaying().toString());
        if (MusicLibrary.getIsSongPlaying()) {
            Log.d(this.getLocalClassName(), "it's playing we will set timer");
            startProgressBarAndPlayTime();
        }

        findViewById(R.id.button_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                if (MusicLibrary.getCurrentSongPosition() < 5 &&
                        currentSong.getTrackNumber() != 0) {
                    currentSong = MusicLibrary.getAlbumById(
                            currentSong.getAlbumId()).getSongs().get(
                            currentSong.getTrackNumber() - 1);
                    //setTextAndImages(currentSong);
                }
                MusicLibrary.playSongFromBeginning(currentSong);
                startProgressBarAndPlayTime();
            }
        });

        findViewById(R.id.button_play_pause).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MusicLibrary.togglePlay();
                if (MusicLibrary.getIsSongPlaying()) {
                    startProgressBarAndPlayTime();
                } else {
                    countDownTimer.cancel();
                }
            }
        });

        findViewById(R.id.button_forward).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                if (currentSong.getTrackNumber() + 1 == MusicLibrary.getAlbumById(
                        currentSong.getAlbumId()).getSongs().size()) {
                    currentSong = MusicLibrary.getAlbumById(
                            currentSong.getAlbumId()).getSongs().get(0);
                    MusicLibrary.togglePlay();
                } else {
                    currentSong = MusicLibrary.getAlbumById(
                            currentSong.getAlbumId()).getSongs().get(
                            currentSong.getTrackNumber() + 1);
                    MusicLibrary.playSongFromBeginning(currentSong);
                    setTextAndImages(currentSong);
                    startProgressBarAndPlayTime();
                }
            }
        });
    }

    public void setCurrentSongPositionText(int position) {
        ((TextView) findViewById(R.id.play_time_current)).setText(
                MusicLibrary.convertTime(position));
    }

    public void setTextAndImages(Song song) {
        ((TextView) findViewById(R.id.song_title)).setText(song.getSongTitle());
        setCurrentSongPositionText(MusicLibrary.getCurrentSongPosition());
        ((TextView) findViewById(R.id.play_time_total)).setText(song.getSongLength());

        ((TextView) findViewById(R.id.artist_name)).setText(
                MusicLibrary.getArtistById(song.getArtistId()).getArtistName());
        ((ImageView) findViewById(R.id.album_art)).setImageResource(
                MusicLibrary.getAlbumById(song.getAlbumId()).getAlbumArt());
    }

    public void startProgressBarAndPlayTime() {
        setTextAndImages(currentSong);
        setCurrentSongPositionText(MusicLibrary.getCurrentSongPosition());
        countDownTimer = new CountDownTimer(((currentSong.getSongLengthInt() -
                MusicLibrary.getCurrentSongPosition() + 1) * 1000), 1000) {
            public void onTick(long millisUntilFinished) {
                setCurrentSongPositionText(MusicLibrary.getCurrentSongPosition());
                int progressBarWidth = findViewById(R.id.progress_bar).getWidth();
                double leftMargin = ((double) MusicLibrary.getCurrentSongPosition() /
                        (double) currentSong.getSongLengthInt() * progressBarWidth);
                Log.d(this.getClass().getName(), "leftMargin: " + leftMargin);
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) findViewById(
                        R.id.progress_dot).getLayoutParams();
                params.setMargins((int) leftMargin,
                        params.topMargin,
                        params.rightMargin,
                        params.bottomMargin);
                findViewById(R.id.progress_dot).setLayoutParams(params);
            }

            public void onFinish() {
                countDownTimer.cancel();
                startProgressBarAndPlayTime();
            }
        }.start();
    }
}