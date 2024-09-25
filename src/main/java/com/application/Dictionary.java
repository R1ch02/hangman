package com.application;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Dictionary {

    private static final List<String> wordsList = new ArrayList<>();

    public Dictionary() throws FileNotFoundException {
        String separator = File.separator;
        File file = new File("src" + separator + "main" + separator + "resources" + separator + "Dictionary.md");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            wordsList.add(scanner.nextLine());
        }

        scanner.close();

    }

    public String fetchRandomNoun(){

            String randomWord = "";
            if (!wordsList.isEmpty()) {
                Random random = new Random();
                randomWord = wordsList.get(random.nextInt(wordsList.size()));
            }


        return randomWord.toUpperCase();
    }

}
