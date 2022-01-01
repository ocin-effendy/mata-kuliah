package com.code;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        double input;
        Tabung t = new Tabung();
        Balok b = new Balok();

        System.out.print("Input Jari - Jari dan Panjang : ");
        input = userInput.nextDouble();
        t.getLuasPermukaan(input);
        t.getVolume(input);

        b.getLuasPermukaan(input);
        b.getVolume(input);


    }
}
