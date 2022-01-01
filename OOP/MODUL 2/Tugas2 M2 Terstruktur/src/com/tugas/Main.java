package com.tugas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        int jari2, menu=0;
        double luas, keliling;

        System.out.println("== Selamat Datang == ");
        System.out.println("1. Hitung Luas Lingkaran");
        System.out.println("2. Hitung Keliling Lingkaran");
        System.out.print("Pilih : ");
        menu = userInput.nextInt();
        switch (menu){
            case 1:
                System.out.print("Inputkan Jari-jari : ");
                jari2 = userInput.nextInt();
                luas = hitungLuas(jari2);
                System.out.println("Luas Lingkaran adalah : " + luas);
                break;
            case 2:
                System.out.print("Inputkan Jari-jari : ");
                jari2 = userInput.nextInt();
                keliling = hitungKeliling(jari2);
                System.out.println("Keliling Lingkaran adalah : " + keliling);
                break;
            default:
                System.out.println("inputan salah");
        }

    }

    private static double hitungLuas(int dataJari2){
        double hasil;
        hasil =  dataJari2 * dataJari2 * 3.14;
        return hasil;
    }

    private static double hitungKeliling(int dataJari2){
        double hasil;
        hasil = dataJari2 * 2 * 3.14;
        return hasil;
    }
}
