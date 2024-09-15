package com.application;


public class Printer {


    public static void printHangman(int errorCount){
        switch (errorCount){
            case 0:
                System.out.println(
                        "    +---+\n" +
                        "        |\n" +
                        "        |\n" +
                        "        |\n" +
                        "        |\n" +
                        "        |\n" +
                        "=========");
            case 1:
                System.out.println(
                        "    +---+\n" +
                        "    |   |\n" +
                        "        |\n" +
                        "        |\n" +
                        "        |\n" +
                        "        |\n" +
                        "=========");
            case 2:
                System.out.println(
                        "    +---+\n" +
                        "    |   |\n" +
                        "    O   |\n" +
                        "        |\n" +
                        "        |\n" +
                        "        |\n" +
                        "=========");
            case 3:
                System.out.println(
                        "    +---+\n" +
                        "    |   |\n" +
                        "    O   |\n" +
                        "    |   |\n" +
                        "        |\n" +
                        "        |\n" +
                        "=========");
            case 4:
                System.out.println(
                        "    +---+\n" +
                        "    |   |\n" +
                        "    O   |\n" +
                        "   /|   |\n" +
                        "        |\n" +
                        "        |\n" +
                        "=========");
            case 5:
                System.out.println(
                        "    +---+\n" +
                        "    |   |\n" +
                        "    O   |\n" +
                        "   /|\\  |\n" +
                        "        |\n" +
                        "        |\n" +
                        "=========");
            case 6:
                System.out.println(
                        "    +---+\n" +
                        "    |   |\n" +
                        "    O   |\n" +
                        "   /|\\  |\n" +
                        "   /    |\n" +
                        "        |\n" +
                        "=========");
            case 7:
                System.out.println(
                        "    +---+\n" +
                        "    |   |\n" +
                        "    O   |\n" +
                        "   /|\\  |\n" +
                        "   / \\  |\n" +
                        "        |\n" +
                        "=========");
        }
    }
    //TODO реализовать печать слова
    public static void printWord(){


    }
}
