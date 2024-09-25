package com.application;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class ConsoleApp implements Runnable {

    private volatile boolean running = true;

    private final Dictionary dictionary;

    public ConsoleApp(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        outerLoop:
        while (running) {
            System.out.println("Выберите действие:");
            System.out.println("1. Начать новую игру");
            System.out.println("2. Выход из игры");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();  // Чистим буфер
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод, попробуйте снова.");
                scanner.nextLine();  // Чистим буфер
                continue;
            }

            switch (choice) {
                case 1:
                    playGame(scanner);
                    break;
                case 2:
                    running = false;
                    break outerLoop;

                default:
                    System.out.println("Команда введена неверно, попробуйте ещё раз...");

            }

        }

        System.out.print("Выход из игры");
        for (int i = 0; i < 3; i++) {
            pause(700);
            System.out.print(".");
        }

        System.out.println('\n' + "Программа завершена!");
        scanner.close();

    }

    private void playGame(Scanner scanner) {
        String word = dictionary.fetchRandomNoun();
        Set<String> letterSet = new HashSet<>();
        int wordSize = word.length();
        int mistakeCounter = 0;
        int trueCount;
        int turn = 1;
        String choice;
        boolean[] answers = new boolean[wordSize];
        boolean isGame = true;


        while (isGame) {
            System.out.println("ХОД - " + turn);
            Printer.printHangman(mistakeCounter);
            Printer.printWord(word, answers);

            if (letterSet.isEmpty()) {
                System.out.println("Вы не использовали ни одной буквы");
            } else {
                System.out.print("Использованные буквы - ");
                for (String s : letterSet) {
                    System.out.print(s + " ");
                }
                System.out.println();
            }

            choice = scanner.nextLine().toUpperCase();
            System.out.println();

            if (choice.length() != 1)   {

                System.out.println("Буква введена неверно, попробуйте снова.");

            } else if (letterSet.contains(choice.toUpperCase())) {

                System.out.println("Буква уже была введена. Попробуйте ввести другую.");

            } else {

                boolean correctGuess = false;  // Флаг для правильного ввода
                boolean isOpen = false;
                for (int i = 0; i < wordSize; i++) {
                    if (choice.charAt(0) == word.charAt(i)) {
                        answers[i] = true;
                        correctGuess = true;
                        letterSet.add(choice);
                        isOpen = true;


                    }
                }

                if (isOpen){
                    System.out.println("Вы открыли букву!");
                }

                if (!correctGuess) {
                    System.out.println("Такой буквы нету");
                    mistakeCounter++;
                    letterSet.add(choice);
                }
                turn++;

                // Проверка поражения и победы...
                if (mistakeCounter >= 8) {
                    System.out.println("Вы проиграли...");
                    System.out.println("Загаданное слово - " + word);
                    break;
                }

                for (boolean answer : answers) {
                    if (!answer) {
                        break;
                    }
                    trueCount = 0;
                    for (boolean b : answers) {
                        if (b) trueCount++;
                    }
                    if (trueCount == wordSize) {
                        System.out.println("Вы победили!!!");
                        isGame = false;
                        break;
                    }
                }
            }
        }
    }

    public void stop() {
        running = false;  // Метод для завершения работы потока
    }

    public static void pause(int mils) {
        try {
            Thread.sleep(mils);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Пауза прервана");
            throw new RuntimeException(e);
        }
    }
}

