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
        setContentView(R.layout.activity_logo);//установка макета для активности.

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//установка флага на полноэкранный режим.

        mPlayer = MediaPlayer.create(this, R.raw.start);//создание объекта MediaPlayer для проигрывания звука.
        mPlayer.start();//запуск проигрывания звука.

        Animation logoAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.logo_anim);//загрузка анимации для изображения логотипа.
        Animation buttonLogoAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha_anim);// загрузка анимации для кнопки.

        ImageView logoImage = findViewById(R.id.imageView4);//получение ссылки на изображение логотипа.
        ImageButton bAnim = findViewById(R.id.button);//получение ссылки на кнопку.

        logoImage.startAnimation(logoAnim);//запуск анимации для изображения логотипа.
        bAnim.startAnimation(buttonLogoAnim);//запуск анимации для кнопки.
    }
    //объявление метода onClickStart, который будет вызываться при нажатии на кнопку.
    public void onClickStart(View view) {
        mPlayer.stop();//остановка проигрывания звука.

        Intent intent = new Intent(Logo_Activity.this,MainActivity.class);//создание намерения для перехода на другую активность.
        startActivity(intent);//запуск другой активности.

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();//вызов родительского метода onDestroy.
        finish();// завершение активности.

    }
    }

