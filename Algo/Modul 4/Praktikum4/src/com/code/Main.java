package com.code;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String[][] arrString = {
                {"Taufik", "Firdaus", "Lenka","Dodit"},
                {"Yusuf", "Niko", "Surya", "Miqdad"},
                {"Bayu", "Jojo", "Handika","William"},
                {"Cristoper", "Risky", "Ozan", "Eriko"}
        };

        sort(arrString);

        System.out.print("Nama yang dicari : ");
        String cek = userInput.nextLine();
        int low = 0;
        int high = arrString.length -1;

        for (String[] strings : arrString) {
            for (int i = 0; i < arrString.length; i++) System.out.print(strings[i] + ", ");
            System.out.println();
        }

        System.out.println("=============================");

        for (int i = 0; i < arrString.length; i++){
            int index = search(arrString[i], low, high, cek);
            if (index < arrString.length){
                System.out.println("posisi : " + i+", " + index);
                break;
            }else if(i == arrString.length-1){
                System.out.println("Data tidak ditemukan");
            }
        }

    }
    public static void sort(String[][] arrString){
        int baris = 0;
        int kolom = 0;
        String temp;
        for (int k = 0; k < arrString.length*arrString.length; k++){
            if (kolom == arrString.length){
                kolom = 0;
                baris++;
            }
            for (int i = 0; i < arrString.length; i++) {
                for (int j = 0; j < arrString.length; j++) {
                    if (arrString[baris][kolom].compareTo(arrString[i][j]) < 0) {
                        temp = arrString[i][j];
                        arrString[i][j] = arrString[baris][kolom];
                        arrString[baris][kolom] = temp;
                    }
                }
            }
            kolom++;
        }
    }



    public static int search(String[] arr, int low, int high, String cek) {
        int mid = (low + high) / 2;
        int index = 0;
        if (cek.compareTo(arr[mid]) < 0) {
            high = mid - 1;
            if (mid == low) index = arr.length;
            else index = search(arr, low, high, cek);

        } else if (cek.compareTo(arr[mid]) > 0) {
            low = mid + 1;
            if (mid == high) index = arr.length;
            else index = search(arr, low, high, cek);

        } else if (arr[mid].equals(cek)) index = mid;

        return index;
    }

}

