package com.application;
public class Main {
    public static void main(String[] args) {
    Thread gameThread = new Thread(new ConsoleApp());
    gameThread.start();

    }

}