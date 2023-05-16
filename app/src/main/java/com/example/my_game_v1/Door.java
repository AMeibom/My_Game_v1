package com.example.my_game_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Door extends AppCompatActivity {
    public  AnimationDrawable mAnimation1;
    public  AnimationDrawable mAnimation2;
    public  AnimationDrawable mAnimation3;
    ImageView door1;
    ImageView door2;
    ImageView door3;

    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_door);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mPlayer = MediaPlayer.create(this, R.raw.zvuk);

        //Создание переменных door и присваивание им значения, полученные по id из ресурсов.
        door1=findViewById(R.id.btn_door);
        door2=findViewById(R.id.btn_door2);
        door3=findViewById(R.id.btn_door3);

        //Находим кнопки дверей и устанавливаем им фон с открытыми дверьми.
        door1.setBackgroundResource(R.drawable.door_open);
        door2.setBackgroundResource(R.drawable.door_open);
        door3.setBackgroundResource(R.drawable.door_open);

        //Получаем анимацию фона для каждой двери.
        mAnimation1 = (AnimationDrawable) door1.getBackground();
        mAnimation2 = (AnimationDrawable) door2.getBackground();
        mAnimation3= (AnimationDrawable) door3.getBackground();

        //Устанавливаем слушатель кликов на первую дверь.
        door1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // В обработчике клика создаем анимацию и запускаем звуковой файл.
              mPlayer.start();
              Animation animation = AnimationUtils.loadAnimation(Door.this, R.anim.logo_anim_door);
              ImageView logoImage = findViewById(R.id.btn_door);
                // Устанавливаем слушатель завершения анимации
                animation.setAnimationListener(new Animation.AnimationListener() {
                  @Override
                  public void onAnimationStart(Animation animation) {
                        // Начало анимации
                  }
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        // Завершение анимации
                        // Создаем интент для перехода в другую активность
                        Intent intent = new Intent(Door.this, Penivaiz.class);
                        startActivity(intent);
                    }
                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        // Повторение анимации (если нужно)
                    }
                });
                // Запускаем анимацию на кнопке
               mAnimation1.start();
               logoImage.startAnimation(animation);
            }
        });
        door2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создаем анимацию
                mPlayer.start();
                Animation animation = AnimationUtils.loadAnimation(Door.this, R.anim.logo_anim_door2);
                ImageView logoImage = findViewById(R.id.btn_door2);
                // Устанавливаем слушатель завершения анимации
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        // Начало анимации
                    }
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        // Завершение анимации
                        // Создаем интент для перехода в другую активность
                        Intent intent = new Intent(Door.this, Poisk_Kota.class);
                        startActivity(intent);
                    }
                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        // Повторение анимации (если нужно)
                    }
                });
                // Запускаем анимацию на кнопке
                mAnimation2.start();
                logoImage.startAnimation(animation);
            }
        });
        door3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создаем анимацию
                mPlayer.start();///запуск проигрывания звука.
                Animation animation = AnimationUtils.loadAnimation(Door.this, R.anim.logo_anim_door3);
                ImageView logoImage = findViewById(R.id.btn_door3);
                // Устанавливаем слушатель завершения анимации
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        // Начало анимации
                    }
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        // Завершение анимации
                        // Создаем интент для перехода в другую активность
                        Intent intent = new Intent(Door.this, Penivaiz.class);//Создание интента для перехода на другую активность
                        startActivity(intent);//Запуск активности следующей активности
                    }
                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        // Повторение анимации (если нужно)
                    }
                });
                // Запускаем анимацию на кнопке
                mAnimation3.start();
                logoImage.startAnimation(animation);
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();

    }
}


