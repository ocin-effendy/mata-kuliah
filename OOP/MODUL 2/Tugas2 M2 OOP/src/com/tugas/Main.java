package com.tugas;

import java.util.Scanner;

class Luas{
    private int jari;

    public void setJari(int jari){
        this.jari = jari;
    }

    private double getJari(){
        return this.jari * this.jari * 3.14;

    }

    public void display(){
        System.out.println("Jari-jari\t\t: " + this.jari);
        System.out.println("Luas lingkaran\t: " + getJari());
    }
}

class Keliling{
    private int jari;

    public void setJari(int jari){
        this.jari = jari;
    }

    private double getJari(){
        return this.jari * 2 * 3.14;
    }

    public void display(){
        System.out.println("Jari-jari\t\t\t: " + this.jari);
        System.out.println("Keliling Lingkaran\t: " + getJari());
    }

}

public class Main {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        int jari2;
        int pilih;
        Luas luasLingkaran = new Luas();
        Keliling kelilingLingkaran = new Keliling();

        System.out.println("==== Hitung Lingkaran ====");
        System.out.println("1. Luas Lingkaran");
        System.out.println("2. Keliling Lingkaran");
        System.out.print("Pilih : ");
        pilih = userInput.nextInt();

        if(pilih == 1){
            System.out.print("Masukkan jari-jari : ");
            jari2 = userInput.nextInt();
            luasLingkaran.setJari(jari2);
            luasLingkaran.display();
        }else if(pilih == 2){
            System.out.print("Masukkan jari-jari : ");
            jari2 = userInput.nextInt();
            kelilingLingkaran.setJari(jari2);
            kelilingLingkaran.display();

        }



    }
}
