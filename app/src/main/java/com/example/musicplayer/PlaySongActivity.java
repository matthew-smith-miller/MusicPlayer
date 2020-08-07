package com.example.musicplayer;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlaySongActivity extends AppCompatActivity {

    int songId;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        songId = MusicLibrary.getCurrentSong().getSongId();
        if (!MusicLibrary.recentAlbums.contains(MusicLibrary.getAlbumById(
                MusicLibrary.getCurrentSong().getAlbumId()))) {
            MusicLibrary.recentAlbums.add(MusicLibrary.getAlbumById(
                    MusicLibrary.getCurrentSong().getAlbumId()));
        }

        refreshView();
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

    @Override
    protected void onResume() {
        super.onResume();
        refreshView();
    }

    private void setRefreshCycle() {
        final Activity activity = this;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                MusicLibrary.setCurrentSongPositionText(activity);
                MusicLibrary.setProgressBallLocation(activity);
                if (songId != MusicLibrary.getCurrentSong().getSongId()) {
                    MusicLibrary.setTextAndImages(activity);
                }
                songId = MusicLibrary.getCurrentSong().getSongId();
            }

            @Override
            public void onFinish() {
                setRefreshCycle();
            }
        }.start();
    }

    private void refreshView() {
        MusicLibrary.setProgressBallLocation(this);
        MusicLibrary.setTextAndImages(this);
    }
}