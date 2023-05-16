package com.example.my_game_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class Penivaiz extends AppCompatActivity {
    MediaPlayer mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penivaiz);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mPlayer = MediaPlayer.create(this, R.raw.rew);//Создание переменной mPlayer и присваивание ей значения, полученного из медиа-ресурса.
        mPlayer.start();//запуск медиа ресурса
    }
    public void onClickStart(View view) {
        Intent intent = new Intent(Penivaiz.this, Door.class);//Создание интента для перехода на другую активность
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT); //перемещает activity, к которой осуществляется переход на вершину стека, если она ужее есть в стеке.
        startActivity(intent);//Запуск активности следующей активности
        mPlayer.stop();//остановка проигрывания звука.
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();

    }
}