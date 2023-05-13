package com.example.my_game_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Main_key extends AppCompatActivity {

    ImageView key;
    Button btn_start2;

    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poisk_key);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btn_start2=findViewById(R.id.btn_start2);
        key=findViewById(R.id.key);
        btn_start2.setEnabled(false);
        mPlayer = MediaPlayer.create(this, R.raw.z);

           }

            public void onClickStart2(View view) {
                // Создаем анимацию
                mPlayer.start();
                Animation animation = AnimationUtils.loadAnimation(Main_key.this, R.anim.logo_anim_key);
                ImageView logoImage = findViewById(R.id.key);
                logoImage.startAnimation(animation);
                btn_start2.setEnabled(true);
                       }


    public void onClickStart(View view) {
        Intent intent = new Intent(Main_key.this, Zagadka.class);
        startActivity(intent);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();

    }
}

