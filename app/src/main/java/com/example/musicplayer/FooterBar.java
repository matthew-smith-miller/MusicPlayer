package com.example.musicplayer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class FooterBar {

    private final Activity activity;
    int songId;
    CountDownTimer countDownTimer;

    public FooterBar(final Activity activity) {
        this.activity = activity;
        refreshTextAndImages();
        activity.findViewById(R.id.now_playing_footer).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Context context = view.getContext();
                        Intent intent = new Intent(context, PlaySongActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        activity.startActivityIfNeeded(intent, 0);
                    }
                });
    }

    public void setRefreshCycle() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (MusicLibrary.getIsSongPlaying()) {
                    MusicLibrary.setCurrentSongPositionText(activity);
                    MusicLibrary.setProgressBarWidth(activity);
                    if (songId != MusicLibrary.getCurrentSong().getSongId()) {
                        MusicLibrary.setTextAndImagesFooter(activity);
                    }
                    songId = MusicLibrary.getCurrentSong().getSongId();
                }
            }

            @Override
            public void onFinish() {
                setRefreshCycle();
            }
        }.start();
    }

    public void refreshTextAndImages() {
        if (MusicLibrary.getIsSongPlaying()) {
            MusicLibrary.setTextAndImagesFooter(activity);
        }
    }
}
