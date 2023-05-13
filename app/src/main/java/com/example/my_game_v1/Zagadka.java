package com.example.my_game_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class Zagadka extends AppCompatActivity {

    EditText editText;

    Button btn_start2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zagadka);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        editText = findViewById(R.id.editText);

        TextView textView = findViewById(R.id.textView); // получаем ссылку на TextView
        String text = ""; // создаем пустую строку
        try {
            InputStream is = getAssets().open("zagadka.txt"); // открываем файл
            int size = is.available(); // получаем размер файла
            byte[] buffer = new byte[size]; // создаем буфер
            is.read(buffer); // считываем файл в буфер
            is.close(); // закрываем InputStream
            text = new String(buffer); // преобразуем буфер в строку
        } catch (IOException ex) {
            ex.printStackTrace(); // обрабатываем ошибки
        }
        textView.setText(text); // устанавливаем текст в TextView

        btn_start2 = findViewById(R.id.btn_start2);
        btn_start2.setEnabled(false);
        final String requiredWord = "карта" ; // здесь указываем нужное слово
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals(requiredWord)) {
                    editText.setError("Неверное слово");
                } else {
                    editText.setError(null);
                    btn_start2.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }

  public void onClickStart(View view) {
        Intent intent = new Intent(Zagadka.this, Game_Over.class);
        startActivity(intent);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();

    }
}

