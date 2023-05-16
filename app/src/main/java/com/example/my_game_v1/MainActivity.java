package com.example.my_game_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        TextView textView = findViewById(R.id.text); // получаем ссылку на TextView
        String text = ""; // создаем пустую строку
        try {
            InputStream is = getAssets().open("text.txt"); // открываем файл
            int size = is.available(); // получаем размер файла
            byte[] buffer = new byte[size]; // создаем буфер
            is.read(buffer); // считываем файл в буфер
            is.close(); // закрываем InputStream
            text = new String(buffer); // преобразуем буфер в строку
        } catch (IOException ex) {
            ex.printStackTrace(); // обрабатываем ошибки
        }
        textView.setText(text); // устанавливаем текст в TextView
        mPlayer = MediaPlayer.create(this, R.raw.heroy);
        mPlayer.start();//запуск проигрывания звука.
    }

    public void Start(View v) {
        Intent intent = new Intent(MainActivity.this, Door.class);//создание намерения для перехода на другую активность.
        startActivity(intent);//создание намерения для перехода на другую активность.
        mPlayer.stop();//остановка проигрывания звука.
            }
    //вызов родительского метода onDestroy.
 @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();// завершение активности.

    }
}