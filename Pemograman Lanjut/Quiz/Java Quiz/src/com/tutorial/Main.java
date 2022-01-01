package com.tutorial;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        // panjang segitiga sama sisi = alas segitiga sama sisi
        double panjang;
        double alas;
        double tinggi;
        double luas;
        double keliling;


        System.out.print("Masukkan Panjang : ");
        panjang = userInput.nextDouble();

        System.out.print("Masukkan Alas : ");
        alas = userInput.nextDouble();

        System.out.print("Masukkan Tinggi : ");
        tinggi = userInput.nextDouble();

        luas = alas * tinggi / 2;
        keliling = alas + alas + alas;


        try{

            if (panjang < 0 || alas < 0 || tinggi < 0){
                throw new Exception("Angka Inputan Negatif");


            }else{
                System.out.println("Luas Segitiga Sama Sisi Adalah\t: " + luas);
                System.out.println("Keliling Segitiga Sama Sisi Adalah\t: " + keliling);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
