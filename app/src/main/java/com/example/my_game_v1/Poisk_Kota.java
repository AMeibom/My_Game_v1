package com.example.my_game_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Poisk_Kota extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Button btn_start;
    private TextView coordinatesOut;// окно поиска кортинки
    private float x; // задание поля для координаты X
    private float y; // задание поля для координаты Y

    private String sDown; // строка для записи координат нажатия
    private String sMove; // строка для записи координат движения
    private String sUp; // строка для записи координат отпускания

    // задание дополнительных полей координат кота Шрёдингера
    private final float xCat = 500; // задание поля для координаты X
    private final float yCat = 500; // задание поля для координаты Y
    private final float deltaCat = 40; // допустимая погрешность в нахождении кота

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poisk_kota);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mediaPlayer = MediaPlayer.create(this, R.raw.z);

        // присваивание переменной активити элемента представления activity_main
        coordinatesOut = findViewById(R.id.coordinatesOut);
        btn_start = findViewById(R.id.start);

        coordinatesOut.setOnTouchListener(listener);
        btn_start.setEnabled(false);

    }
    // объект обработки касания экрана (слушатель)
    private View.OnTouchListener listener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) { // в motionEvent пишутся координаты
            x = motionEvent.getX(); // инициализация координат X
            y = motionEvent.getY(); // инициализация координат Y
            String resultX = String.format("%.2f", x);// округление координаты х до сотых
            String resultY = String.format("%.2f", y);// округление координаты у до сотых
            switch (motionEvent.getAction()) { // метод getAction() считывает состояние касания (нажатие/движение/отпускание)
                case MotionEvent.ACTION_DOWN: // нажатие

                    break;

                case MotionEvent.ACTION_MOVE: // движение
                    sMove = "X=" + resultX + ", Y=" + resultY;
                    // задание условия нахождения кота Шрёдингера
                    if (x < (xCat + deltaCat) && x > (xCat - deltaCat) && y < (yCat + deltaCat) && y > (yCat - deltaCat)) { // если пользователь коснулся места нахождения кота
                        // размещаем тост (контекст, сообщение, длительность сообщения)
                        LayoutInflater inflater = getLayoutInflater(); //Создаём объект LayoutInflater через вызов метода getLayoutInflater().
 // Получаем View объект, который представляет наш кастомный Toast, вызывая метод inflate() у inflater объекта и передавая ему id нашего Toast layout'а из файлов ресурсов.
                        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast));

                        Toast toast = new Toast(getApplicationContext());//Создаём объект Toast, и передаем его в качестве параметра конструктора Toast.
                        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);// задание позиции на экране (положение, смещение по оси Х, смещение по оси Y)
                        toast.setDuration(Toast.LENGTH_SHORT);//Устанавливаем время отображения Toast
                        toast.setView(layout);//определение View компонента для отображения во всплывающем сообщении.
                        toast.show();// демонстрация тоста на экране
                        mediaPlayer.start();//Устанавливаем время отображения Toast, используя метод setDuration() и параметр Toast.LENGTH_SHORT.
                        btn_start.setEnabled(true);//Активируем кнопку

                    }
                    break;
                case MotionEvent.ACTION_UP: // отпускание
                case MotionEvent.ACTION_CANCEL: // внутрений сбой (аналогичен ACTION_UP)

                    break;
            }
            return true; // подтверждение нашей обработки событий
        }
    };
    public void Start(View view) {
        Intent intent = new Intent(Poisk_Kota.this, Main_key.class);
        startActivity(intent);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    }

