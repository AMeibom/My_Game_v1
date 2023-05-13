package com.example.my_game_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.WindowManager;

public class Penivaiz extends AppCompatActivity {
    MediaPlayer mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penivaiz);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mPlayer = MediaPlayer.create(this, R.raw.rew);
        mPlayer.start();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();

    }
}