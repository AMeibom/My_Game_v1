package com.example.my_game_v1;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;

public class Zagadka extends AppCompatActivity {

    EditText editText;

    Button btn_start2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zagadka);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//Установка флага FLAG_FULLSCREEN для активности, чтобы сделать ее на весь экран.
        editText = findViewById(R.id.editText);

        TextView textView = findViewById(R.id.textView); // получаем ссылку на TextView
        String text = ""; // создаем пустую строку
        try {
            InputStream is = getAssets().open("zigzagged.txt"); // открываем файл
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
        btn_start2.setEnabled(false);// отключение кнопки
        btn_start2.setVisibility(View.INVISIBLE); // текст становится невидимым
        final String requiredWord = "карта" ; // здесь указываем нужное слово
        //определяется объект editText типа EditText и устанавливается слушатель изменения текста при помощи метода addTextChangedListener().
        editText.addTextChangedListener(new TextWatcher() {//Добавляем слушатель изменения текста для поля ввода editText.
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {//В методе onTextChanged слушателя проверяем, не равен ли введенный текст переменной requiredWord.
                if (!s.toString().equals(requiredWord)) {
                    editText.setError("Неверное слово");//Если текст в текстовом поле не совпадает с правильным словом, то устанавливается сообщение об ошибке
                } else {
                    editText.setError(null);//убираем сообщение об ошибке,
                    btn_start2.setEnabled(true);//включение кнопки
                    btn_start2.setVisibility(View.VISIBLE); // текст становится видимым
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
  public void onClickStart(View view) {
        Intent intent = new Intent(Zagadka.this, Game_Over.class);//Создание интента для перехода на другую активность
        startActivity(intent);//остановка проигрывания звука.
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();

    }
}

