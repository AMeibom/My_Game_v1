package com.example.my_game_v1;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Logo_Activity extends AppCompatActivity {

    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mPlayer = MediaPlayer.create(this, R.raw.start);
        mPlayer.start();

        Animation logoAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.logo_anim);
        Animation buttonLogoAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha_anim);

        ImageView logoImage = findViewById(R.id.imageView4);
        ImageButton bAnim = findViewById(R.id.button);

        logoImage.startAnimation(logoAnim);
        bAnim.startAnimation(buttonLogoAnim);
    }
    public void onClickStart(View view) {
        mPlayer.stop();

        Intent intent = new Intent(Logo_Activity.this,MainActivity.class);
        startActivity(intent);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();

    }
    }

