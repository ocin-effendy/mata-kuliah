package com.tugas;

import java.util.Scanner;

class Luas{
    private Jari jari;

    public void setJari(Jari jari){
        this.jari = jari;
    }

    private double getJari(){
        return this.jari.getJari2() * this.jari.getJari2() * 3.14;
    }


//    public void setJari(int jari){
//        this.jari = jari;
//    }

//    private double getJari(){
//        return this.jari * this.jari * 3.14;
//
//    }

    public void display(){
        System.out.println("Jari-jari\t\t: "+ this.jari.getJari2());
        System.out.println("Luas lingkaran\t: " + getJari());
    }
}

class Keliling{
    private Jari jari;

    public void setJari(Jari jari){
        this.jari = jari;
    }

    private double getJari(){
        return this.jari.getJari2() * 2 * 3.14;
    }

    public void display(){
        System.out.println("Jari-jari\t\t\t: " + this.jari.getJari2());
        System.out.println("Keliling Lingkaran\t: " + getJari());
    }

}

class Jari{
    private int jari2;

    public void setJari2(int jari2) {
        this.jari2 = jari2;
    }

    public int getJari2() {
        return jari2;
    }
}


public class Main {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        int jari2;
        int pilih;
        Luas luasLingkaran = new Luas();
        Keliling kelilingLingkaran = new Keliling();
        Jari jariJari = new Jari();

        System.out.println("==== Hitung Lingkaran ====");
        System.out.println("1. Luas Lingkaran");
        System.out.println("2. Keliling Lingkaran");
        System.out.print("Pilih : ");
        pilih = userInput.nextInt();

        if(pilih == 1){
            System.out.print("Masukkan jari-jari : ");
            jari2 = userInput.nextInt();
            jariJari.setJari2(jari2);
            luasLingkaran.setJari(jariJari);
            luasLingkaran.display();
        }else if(pilih == 2){
            System.out.print("Masukkan jari-jari : ");
            jari2 = userInput.nextInt();
            jariJari.setJari2(jari2);
            kelilingLingkaran.setJari(jariJari);
            kelilingLingkaran.display();

        }



    }
}
