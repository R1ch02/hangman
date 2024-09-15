package com.application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleApp implements Runnable {

    private volatile boolean running = true;

    //TODO ошибка ввода. Из-за отдельного потока?
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
        //TODO реализовать выход. Закрытие потока.

        System.out.print("Выход из игры");
        for (int i = 0; i < 3; i++) {
            pause(700);
            System.out.print(".");
        }

        System.out.println('\n' + "Программа завершена!");
        scanner.close();

    }

    private void playGame(Scanner scanner) {
        String word = Dictionary.fetchRandomNoun();
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

            choice = scanner.nextLine().toUpperCase();

            if (choice.length() == 1) {
                boolean correctGuess = false;  // Флаг для правильного ввода
                for (int i = 0; i < wordSize; i++) {
                    if (choice.charAt(0) == word.charAt(i)) {
                        answers[i] = true;
                        correctGuess = true;
                        System.out.println("Вы открыли букву!");
                    }
                }
                if (!correctGuess) {
                    System.out.println("Такой буквы нету");
                    mistakeCounter++;
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

            } else {
                System.out.println("Буква введена неверно, попробуйте снова.");
            }
        }
    }

    public void stop() {
        running = false;  // Метод для завершения работы потока
    }

    public static void pause(int mils){
        try {
            Thread.sleep(mils);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Пауза прервана");
            throw new RuntimeException(e);
        }
    }
}

