package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    // новые переменные
    private EditText textIn; // переводимое слово или фраза
    private TextView textOut; // переведённое слово или фраза

    // создание контейнеров для словарей
    private static HashMap<String, String> ruFr = new HashMap<>();
   

    // значение радиокнопки
    String radioValue = "";


    // создание жизненного цикла активности
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main ); // присваивание жизненному циклу активити представления activity_main

        // присваивание переменным активити элементов представления activity_main
        textIn = findViewById( R.id.textIn ); // ввод
        textOut = findViewById( R.id.textOut ); // вывод
        Button btn = findViewById( R.id.button ); // кнопка перевода

        // инициализация (заполнение) словарей
        dataInfo();

        // выполнение действий при нажании кнопки
        btn.setOnClickListener( listener ); // обработка нажатия кнопки "перевести"
    }

    // метод обработки нажатия кнопки "перевести"
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String dataIn = ""; // начальное поле ввода пустое

            // запись в поле dataIn написанного пользователем текста
            dataIn = textIn.getText().toString();
            textOut.setText( ruFr.get( dataIn ) ); // textOut.setText() - запись значения () в поле textOut;
            if (ruFr.get( dataIn ) == null) {
                textOut.setText( "В словаре такого слова не нашлось" );
            }
        }
    };

    // метод заполнения словарей
    public static void dataInfo() {
        // добавление данных для русско-французского словаря
        ruFr.put( "я", "je" );
        ruFr.put( "ты", "tu" );
        ruFr.put( "он", "il" );
        ruFr.put( "она", "lui" );
        ruFr.put( "мы", "nous" );
        ruFr.put( "они", "ils" );
        ruFr.put( "оно", "lui" );


    }
}