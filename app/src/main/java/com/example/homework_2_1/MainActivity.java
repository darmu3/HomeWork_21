package com.example.homework_2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // переменные коржи и скидка на них
    private float biscuit_cakes = 10; // бисквитные коржи
    private int biscuitDiscount = 26; // скидка на коржи

    // переменные сливки и скидка на них
    private float cream = 14;
    private int creamDiscount = 5;

    // переменные фрукты и скидка на них
    private float fruits = 3;
    private int fruitsDiscount = 12;

    // переменные орехи и скидка на них
    private float nuts = 5;
    private int nutsDiscount = 55;

    // переменная ягоды
    private float berries = 7;

    // переменная баланса на счету+
    private float account = 45;

    // создание полей для вывода на экран полученных значений
    private TextView possibilityOut; // поле возможности покупки
    private TextView balanceOut; // поле возможного остатка от покупки

    // вывод полученных значений
    @Override
    protected void onCreate(Bundle savedInstanceState) { // создание жизненного цикла активности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // присваивание жизненному циклу активити
        // представления activity_main

        possibilityOut = findViewById(R.id.possibilityOut); // вывод информации о возможности покупки
        balanceOut = findViewById(R.id.balanceOut); // вывод информации о возможном остатке от покупки

        if (possibility()) {
            possibilityOut.setText("Имеется достаточно средств для покупки ингредиентов для приготовления торта");
            balanceOut.setText("Остаток от покупки " + balance() + " монет");
        } else {
            possibilityOut.setText("Недостаточно средств для покупки ингредиентов для приготовления торта");
            balanceOut.setText(" - ");
        }
    }

    // подсчёт стоимости ингредиентов
    private float calculation() {
        float count = (biscuit_cakes * (100 - biscuitDiscount) + cream * (100 - creamDiscount)
                + fruits * (100 - fruitsDiscount) + nuts * (100 - nutsDiscount)) / 100
                + berries;
        return count; // возврат подсчитанного значения
    }

    // определяем возможно ли купить ингредиенты
    private boolean possibility() {
        if (calculation() <= account) {
            return true;
        } else {
            return false;
        }
    }

    // метод определения возможной сдачи
    private float balance() {
        if(possibility()) { // если имеется возможность купить ингредиенты
            return account - calculation(); // возвращаем остаток от покупки
        } else { // иначе
            return -1; // возвращается маркер недостатка денежных средств
        }
    }
}