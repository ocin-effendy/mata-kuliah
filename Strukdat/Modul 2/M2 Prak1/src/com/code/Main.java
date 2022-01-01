package com.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Angsa");list.add("Bebek");list.add("Cicak");
        list.add("Domba");list.add("Elang");list.add("Gajah");

        ArrayList<String> listName = new ArrayList<>(list);
        boolean loop = true;
        int pilih;
        System.out.println("1. Tambah Data List");
        System.out.println("2. Hapus Nama Hewan");
        System.out.println("3. Tampil Element pada index ke-0 dan ke-2");
        System.out.println("4. Ubah Data List ");
        System.out.println("5. Tambah Data List Berdasarkan Index");
        System.out.println("6. Hapus elemen di antara indeks");
        System.out.println("7. Tampilkan Elemen Pertama dan Terakhir");
        System.out.println("8. Tampilkan Jumlah Element pada ArrayList");
        System.out.println("9. Cari Posisi Index pada Element");
        while(loop) {
            System.out.print("pilih menu : ");
            pilih = userInput.nextInt();
            switch (pilih) {
                case 1 -> tambahData(listName);
                case 2 -> hapusData(listName);
                case 3 -> tampilIndex(listName, 0, 2);
                case 4 -> ubahDataAtauTambah(listName, true);
                case 5 -> ubahDataAtauTambah(listName, false);
                case 6 -> hapusDataAntaraIndeks(listName);
                case 7 -> pertamaDanTerakhir(listName);
                case 8 -> System.out.println("Jumlah element arrayList = " + listName.size());
                case 9 -> cariIndeksData(listName);
            }
            loop = stopOrNext("\nlanjut ? : ");
        }

    }

    private static void hapusDataAntaraIndeks(ArrayList<String> listName) {
        System.out.print("hapus data dari indeks sampai indeks : ");
        listName.subList(userInput.nextInt() + 1, userInput.nextInt()).clear();
        System.out.println(listName);
    }


    public static void tambahData(ArrayList<String> listName){
        int count, amount;
        System.out.print("masukkan berapa hewan : ");
        count = userInput.nextInt();
        for (int i = 0;i < count; i++ ) listName.add(userInput.next());
        System.out.println(listName);
        System.out.print("Posisi Index : "+ listName.indexOf("Bebek") + ", " + listName.lastIndexOf("Bebek"));
        amount = Collections.frequency(listName, "Bebek");
        System.out.println("\nBebek : " + amount);
    }

    public static void hapusData(ArrayList<String> listName){
        System.out.print("nama hewan yang dihapus : ");
        listName.remove(userInput.next());
        System.out.println(listName);
    }

    public static void tampilIndex(ArrayList<String> listName, int i, int j){
        System.out.println("index ke - " + i + " : " + listName.get(i) );
        System.out.println("index ke - " + j + " : " + listName.get(j) );
        listName.remove(i);
        System.out.println("Hewan indeks " + i + " dihapus");
        System.out.println(listName);
    }


    private static void ubahDataAtauTambah(ArrayList<String> listName, boolean ubah) {
        int i; String newName;
        String message = ubah ? "yang dirubah" : "yang ditambahkan";
        System.out.print("indeks " + message + " : ");
        i = userInput.nextInt();
        System.out.print("nama hewan : ");
        newName = userInput.next();
        if (ubah) listName.set(i, newName);
        else listName.add(i, newName);
        System.out.println(listName);
    }

    private static void pertamaDanTerakhir(ArrayList<String> listName) {
        System.out.println("Element Pertama : " + listName.get(0));
        System.out.println("Element Terakhir : " + listName.get(listName.size()-1));
    }

    private static void cariIndeksData(ArrayList<String> listName) {
        System.out.print("nama hewan : ");
        System.out.println("Indeksnya = " + listName.indexOf(userInput.next()));
    }

    public static boolean stopOrNext(String massage){
        System.out.print(massage);
        String Input = userInput.next();
        return Input.equalsIgnoreCase("y");
    }
}
