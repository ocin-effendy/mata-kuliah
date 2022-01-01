package com.code;

import java.util.Scanner;

class Segitiga<T extends Number>{

    private T alas;
    private T tinggi;

    public Segitiga(T alas, T tinggi){
        this.setAlas(alas);
        this.setTinggi(tinggi);
    }

    public T getAlas() {
        return alas;
    }

    public void setAlas(T alas) {
        this.alas = alas;
    }

    public T getTinggi() {
        return tinggi;
    }

    public void setTinggi(T tinggi) {
        this.tinggi = tinggi;
    }

    public int getResultAsInt(){
        return (Integer)this.getAlas() * (Integer)this.getTinggi() / 2;
    }
    public double getResultAsDouble(){
        return (Double)this.getAlas() * (Double)this.getTinggi() / 2;
    }

}

public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Segitiga<Integer> luasTipeInt;
        Segitiga<Double> luasTipeDouble;


        int pilih, alas1, tinggi1;
        double alas2, tinggi2;
        System.out.println("Mau Menghasilkan Luas dalam bentuk? :");
        System.out.println("1. Hasil To Integer");
        System.out.println("2. Hasil To Boolean");
        System.out.print("Masukan pilihan 1/2 : ");
        pilih = userInput.nextInt();


        switch (pilih) {
            case 1 -> {
                System.out.print("Masukkan nilai alas dan tinggi secara berurutan : ");
                alas1 = userInput.nextInt();
                tinggi1 = userInput.nextInt();
                luasTipeInt = new Segitiga<>(alas1, tinggi1);
                System.out.println("Luas Segitiga = " + luasTipeInt.getResultAsInt());
            }
            case 2 -> {
                System.out.print("Masukkan nilai alas dan tinggi secara berurutan : ");
                alas2 = userInput.nextDouble();
                tinggi2 = userInput.nextDouble();
                luasTipeDouble = new Segitiga<>(alas2, tinggi2);
                System.out.println("Luas Segitiga = " + luasTipeDouble.getResultAsDouble());

            }
            default -> System.err.println("Salah input");

        }
    }





}
