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

//TODO парсинг
public class Dictionary {

    private static final List<String> wordsList = new ArrayList<>(Arrays.asList("Указатель", "Радуга", "Мармелад", "Поиск", "Прятки", "Сторож", "Копейка", "Леопард", "Аттракцион",
            "Дрессировка", "Ошейник", "Карамель", "Водолаз", "Защита", "Батарея", "Решётка", "Квартира", "Дельфинарий", "Непогода", "Вход", "Полиция", "Перекрёсток", "Башня", "Стрелка",
            "Градусник", "Бутылка", "Щипцы", "Наволочка", "Павлин", "Карточка", "Записка", "Лестница", "Переулок", "Сенокос", "Рассол", "Закат", "Сигнализация", "Журнал", "Заставка", "Тиранозавр",
            "Микрофон", "Прохожий", "Квитанция", "Пауза", "Новости", "Скарабей", "Серебро", "Творог", "Осадок", "Песня", "Корзина", "Сдача", "Овчарка", "Хлопья", "Телескоп", "Микроб", "Угощение",
            "Экскаватор", "Письмо", "Пришелец", "Айсберг", "Пластик", "Доставка", "Полка", "Билет", "Вторник", "Льдина", "Интерес", "Троллейбус", "Футболист", "Лисёнок", "Пример", "Баклажан",
            "Лягушка", "Джокер", "Котлета", "Накидка", "Дикобраз", "Барбарис", "Работник", "Кристалл", "Доспехи", "Халва", "Велосипед", "Крючок", "Кочка", "Черепаха", "Петля", "Осень", "Яйцо"
    ));

    public static String fetchRandomNoun(){

//        String url = "https://slotobzor.com/nastolnye-igry-dlya-vzroslyh/slozhnye-slova-dlya-ugadyvaniya-na-igru-viselitsa-interesnye-primery/";
//        List<String> words = new ArrayList<>();
//        String randomWord = "";
//
//        try {
//            // Получение HTML-документа
//            Document doc = Jsoup.connect(url).get();
//            Elements elements = doc.select("p, li");
//            for (Element element : elements) {
//                String text = element.text();
//                // Разделяем текст на слова
//                String[] splitWords = text.split("\\W+");
//                for (String word : splitWords) {
//                    if (!word.isEmpty() && word.length() > 3 ) {
//                        words.add(word);
//                    }
//                }
//            }
//
//            System.out.println(words);

            // Выбор случайного слова

            String randomWord = "";
            if (!wordsList.isEmpty()) {
                Random random = new Random();
                randomWord = wordsList.get(random.nextInt(wordsList.size()));
            }


        return randomWord.toUpperCase();
    }

}
