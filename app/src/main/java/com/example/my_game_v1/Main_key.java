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

        btn_start2 = findViewById(R.id.btn_start2);//Создание переменной btn_start2 и присваивание ей значения, полученного по id из ресурсов.
        key = findViewById(R.id.key);//Создание переменной key и присваивание ей значения, полученного по id из ресурсов.
        btn_start2.setEnabled(false); //Отключение кнопки btn_start2.
        mPlayer = MediaPlayer.create(this, R.raw.z); //Создание переменной mPlayer и присваивание ей значения, полученного из медиа-ресурса.
    }
    // Объявление метода onClickStart2, который срабатывает при нажатии на кнопку.
            public void onClickStart2(View view) {
                // Создаем анимацию
                mPlayer.start();//Запуск медиа-ресурса.
                Animation animation = AnimationUtils.loadAnimation(Main_key.this, R.anim.logo_anim_key);//Создание переменной animation и присваивание ей значения, полученного из анимации в ресурсах.
                ImageView logoImage = findViewById(R.id.key);//Получение элемента ImageView с помощью id из ресурсов и присваивание его переменной logoImage.
                logoImage.startAnimation(animation);//Запуск анимации для logoImage.
                btn_start2.setEnabled(true);//Включение кнопки btn_start2.
                       }
    public void onClickStart(View view) {
        Intent intent = new Intent(Main_key.this, Zagadka.class);//Создание интента для перехода на другую активность
        startActivity(intent);//Запуск активности Zagadka
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();

    }
}

