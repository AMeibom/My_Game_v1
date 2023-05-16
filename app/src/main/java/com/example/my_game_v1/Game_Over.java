package com.example.my_game_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class Game_Over extends AppCompatActivity {
    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mPlayer = MediaPlayer.create(this, R.raw.fanfary);//Создание переменной mPlayer и присваивание ей значения, полученного из медиа-ресурса.
        mPlayer.start();//Запуск медиа-ресурса.
    }


    public void Exit(View view) {
        mPlayer.stop();//остановка проигрывания звука.
        finishAffinity();// Завершить все активности текущего приложения

    }
}