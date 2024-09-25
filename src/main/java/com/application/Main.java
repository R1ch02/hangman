package com.application;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
    Thread gameThread = new Thread(new ConsoleApp(new Dictionary()));
    gameThread.start();

    }

}