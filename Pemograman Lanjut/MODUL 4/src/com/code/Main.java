package com.code;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // NOTE : Scanner, arrayInt, modulus, soutMessage

        Scanner userInput = new Scanner(System.in);
          int hari;
        int[] arr = new int[5];
        System.out.println();


        // Konversi
        System.out.println("== Konversi ==");
        System.out.print("Masukkan Hari : ");
        hari = userInput.nextInt();
        KonversiHari(hari);

        // Sorting
        System.out.println("\n== Sorting ==");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("angka : ");
            arr[i] = userInput.nextInt();
        }

        SortingAngka(arr);



    }

    private static void SortingAngka(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int hasil : arr) {
            System.out.print(hasil + " ");
        }
    }

    private static void KonversiHari(int hari) {

        int tahun = hari / 365;
        int sisa1 = hari % 365;
        int bulan = sisa1 / 30;
        int sisa2 = sisa1 % 30;
        System.out.println(hari + " Hari = " + tahun + " Tahun, " + bulan + " Bulan, " + sisa2 + " Hari");
    }


}
