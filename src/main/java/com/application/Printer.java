package com.application;


public class Printer {


        public static void printHangman(int mistakeCounter){
            switch (mistakeCounter){
                case 0:
                    System.out.println(
                            "    +---+\n" +
                            "        |\n" +
                            "        |\n" +
                            "        |\n" +
                            "        |\n" +
                            "        |\n" +
                            "=========");
                    break;
                case 1:
                    System.out.println(
                            "    +---+\n" +
                            "    |   |\n" +
                            "        |\n" +
                            "        |\n" +
                            "        |\n" +
                            "        |\n" +
                            "=========");
                    break;
                case 2:
                    System.out.println(
                            "    +---+\n" +
                            "    |   |\n" +
                            "    O   |\n" +
                            "        |\n" +
                            "        |\n" +
                            "        |\n" +
                            "=========");
                    break;
                case 3:
                    System.out.println(
                            "    +---+\n" +
                            "    |   |\n" +
                            "    O   |\n" +
                            "    |   |\n" +
                            "        |\n" +
                            "        |\n" +
                            "=========");
                    break;
                case 4:
                    System.out.println(
                            "    +---+\n" +
                            "    |   |\n" +
                            "    O   |\n" +
                            "   /|   |\n" +
                            "        |\n" +
                            "        |\n" +
                            "=========");
                    break;
                case 5:
                    System.out.println(
                            "    +---+\n" +
                            "    |   |\n" +
                            "    O   |\n" +
                            "   /|\\  |\n" +
                            "        |\n" +
                            "        |\n" +
                            "=========");
                    break;
                case 6:
                    System.out.println(
                            "    +---+\n" +
                            "    |   |\n" +
                            "    O   |\n" +
                            "   /|\\  |\n" +
                            "   /    |\n" +
                            "        |\n" +
                            "=========");
                    break;
                case 7:
                    System.out.println(
                            "    +---+\n" +
                            "    |   |\n" +
                            "    O   |\n" +
                            "   /|\\  |\n" +
                            "   / \\  |\n" +
                            "        |\n" +
                            "=========");
                    break;
                default:
                    System.out.println();
            }
        }


    public static void printWord(String word, boolean[] answers){
        if (!word.isEmpty()){
            char[] letters = word.toCharArray();


            for (int i = 0; i < word.length(); i++) {
                if (answers[i]) {
                    System.out.print(letters[i] + " ");
                } else {
                    System.out.print("_ ");
                }

            }
            System.out.println();
        }


    }
}
