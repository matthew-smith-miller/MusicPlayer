package com.example.musicplayer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlaySongActivity extends AppCompatActivity {

    Song currentSong;
    int songId;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        currentSong = MusicLibrary.getCurrentSong();
        songId = currentSong.getSongId();
        setTextAndImages(currentSong);
        setRefreshCycle();

        findViewById(R.id.button_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MusicLibrary.actionBack();
            }
        });

        findViewById(R.id.button_play_pause).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MusicLibrary.togglePlay();
                if (MusicLibrary.getIsSongPlaying()) {
                    findViewById(R.id.button_play_pause).setBackgroundResource(
                            R.drawable.ic_baseline_pause_circle_filled_96);
                } else {
                    findViewById(R.id.button_play_pause).setBackgroundResource(
                            R.drawable.ic_baseline_play_circle_filled_96);
                }
            }
        });

        findViewById(R.id.button_forward).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MusicLibrary.actionForward();
            }
        });
    }

    private void setRefreshCycle() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                setCurrentSongPositionText();
                setProgressBarLocation();
                if (songId != MusicLibrary.getCurrentSong().getSongId()) {
                    currentSong = MusicLibrary.getCurrentSong();
                    setTextAndImages(currentSong);
                }
                songId = currentSong.getSongId();
            }

            @Override
            public void onFinish() {
                setRefreshCycle();
            }
        }.start();
    }

    public void setCurrentSongPositionText() {
        ((TextView) findViewById(R.id.play_time_current)).setText(
                MusicLibrary.convertTime(MusicLibrary.getCurrentSongPosition()));
    }

    public void setTextAndImages(Song song) {
        ((TextView) findViewById(R.id.song_title)).setText(song.getSongTitle());
        setCurrentSongPositionText();
        ((TextView) findViewById(R.id.play_time_total)).setText(song.getSongLength());
        ((TextView) findViewById(R.id.artist_name)).setText(
                MusicLibrary.getArtistById(song.getArtistId()).getArtistName());
        ((ImageView) findViewById(R.id.album_art)).setImageResource(
                MusicLibrary.getAlbumById(song.getAlbumId()).getAlbumArt());
    }

    public void setProgressBarLocation() {
        int progressBarWidth = findViewById(R.id.progress_bar).getWidth();
        double leftMargin = ((double) MusicLibrary.getCurrentSongPosition() /
                (double) currentSong.getSongLengthInt() * progressBarWidth);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) findViewById(
                R.id.progress_dot).getLayoutParams();
        params.setMargins((int) leftMargin,
                params.topMargin,
                params.rightMargin,
                params.bottomMargin);
        findViewById(R.id.progress_dot).setLayoutParams(params);
    }
}