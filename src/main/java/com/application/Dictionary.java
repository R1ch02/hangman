package com.application;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//TODO Брать слово из файла
public class Dictionary {

    private static final List<String> wordsList = new ArrayList<>(Arrays.asList("Указатель", "Радуга", "Мармелад", "Поиск", "Прятки", "Сторож", "Копейка", "Леопард", "Аттракцион",
            "Дрессировка", "Ошейник", "Карамель", "Водолаз", "Защита", "Батарея", "Решётка", "Квартира", "Дельфинарий", "Непогода", "Вход", "Полиция", "Перекрёсток", "Башня", "Стрелка",
            "Градусник", "Бутылка", "Щипцы", "Наволочка", "Павлин", "Карточка", "Записка", "Лестница", "Переулок", "Сенокос", "Рассол", "Закат", "Сигнализация", "Журнал", "Заставка", "Тиранозавр",
            "Микрофон", "Прохожий", "Квитанция", "Пауза", "Новости", "Скарабей", "Серебро", "Творог", "Осадок", "Песня", "Корзина", "Сдача", "Овчарка", "Хлопья", "Телескоп", "Микроб", "Угощение",
            "Экскаватор", "Письмо", "Пришелец", "Айсберг", "Пластик", "Доставка", "Полка", "Билет", "Вторник", "Льдина", "Интерес", "Троллейбус", "Футболист", "Лисёнок", "Пример", "Баклажан",
            "Лягушка", "Джокер", "Котлета", "Накидка", "Дикобраз", "Барбарис", "Работник", "Кристалл", "Доспехи", "Халва", "Велосипед", "Крючок", "Кочка", "Черепаха", "Петля", "Осень", "Яйцо"
    ));

    public static String fetchRandomNoun(){

            String randomWord = "";
            if (!wordsList.isEmpty()) {
                Random random = new Random();
                randomWord = wordsList.get(random.nextInt(wordsList.size()));
            }


        return randomWord.toUpperCase();
    }

}
