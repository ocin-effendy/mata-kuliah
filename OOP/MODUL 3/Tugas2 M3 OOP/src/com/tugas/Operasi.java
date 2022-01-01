package com.tugas;

public class Operasi {
    String name;
    int number1;
    int number2;
    int number3;
    int hasil;


    public void jumlah(int number1, int number2){
        hasil = number1 + number2;
        System.out.println("hasil penjumlahan 2 angka : " + hasil);
    }

    public void jumlah(int number1, int number2, int number3){
        hasil = number1 + number2 + number3;
        System.out.println("hasil penjumlahan 3 angka : " + hasil);
    }

    public void perkalian(int number1, int number2, int number3){
        hasil = number1 * number2 * number3;
        System.out.println("hasil perkalian 3 angka : " + hasil);
    }







}
