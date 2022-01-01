package com.company;

public class Main {

    public static void main(String[] args) {
        String pass = "ab";
        char[] charset = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        BruteForce bf = new BruteForce(charset, 1);
        int i = 0;
        String attempt = bf.toString();
        while (true) {
            if (attempt.equals(pass)) {
                System.out.println("Password sudah ditemukan :  " + attempt);
                System.out.println("Password ditemukan " + i + " kali percobaan");
                break;
            }
            i++;
            bf.increment();
            attempt = bf.toString();
            System.out.println("Array Pattern : " + attempt);
        }
    }
}
