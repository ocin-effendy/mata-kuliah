package com.code;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Binary Search And Interpolation Search");
        System.out.print("Input Numbers of Array : ");
        int count = userInput.nextInt();
        System.out.print("Enter Numbers : ");
        // 10 27 40 50 20 5 41 70 2 25 -> 10
        // 4 39 22 13 48 38 29 30 47 31 20 12 7 15 45 18 3 9 25 37 28 33 -> 22
        // 2 4 6 8 10 12 14 16 18 20 -> 10
        int[] arrInt = new int[count];
        for (int i = 0; i < count; i++){
            arrInt[i] = userInput.nextInt();
        }
        sort(arrInt);
        printArray(arrInt);

        while(true){
            System.out.println("\n1. Binary Search");
            System.out.println("2. Interpolation Search");
            System.out.print("Choose :" );
            int input = userInput.nextInt();
            switch (input) {
                case 1 -> {
                    System.out.print("Search : ");
                    int index = binarySearch(arrInt,0,arrInt.length-1, userInput.nextInt());
                    if (index < arrInt.length) System.out.println("Data berada pada indeks ke-" + index);
                    else System.out.println("Data tidak ditemukan");

                }
                case 2 -> {
                    System.out.print("Search : ");
                    int index = interSearch(arrInt, 0,arrInt.length-1,userInput.nextInt());
                    if (index < arrInt.length){
                        System.out.println("Data berada di indek ke-" + index);
                    }else System.out.println("Data tidak ditemukan");
                }
            }
        }




    }

    public static int interSearch(int[] arrInt, double low, double high, double key){
        double pos = low + (key - arrInt[(int) low]) / (arrInt[(int)high] - arrInt[(int)low]) * (high-low);
        int index =0;
        if (pos < low || pos > high) return arrInt.length;
        int pos2 = (int)Math.round(pos);
        System.out.println("pos : " + pos2);
        if (arrInt[pos2] < key){
            low = pos2 + 1;
            if (arrInt[(int) low] > key) index = arrInt.length;
            else index = interSearch(arrInt,low, high,key);
        }else if (arrInt[pos2] > key){
            high = pos2 -1;
            if (arrInt[(int) high] < key) index = arrInt.length;
            else index = interSearch(arrInt,low, high,key);
        }else if(arrInt[pos2] == key) index = pos2;

        return  index;
    }

    public static int binarySearch(int[] arrInt,int low, int high ,int key){
        int middle = (low + high) / 2;
        System.out.println("mid : " + middle);
        int index = 0;
        if (key < arrInt[middle]){
            high = middle - 1;
            if (low == middle) index = arrInt.length;
            else index = binarySearch(arrInt, low, high, key);
        }else if(key > arrInt[middle]){
            low = middle + 1;
            if (high == middle) index = arrInt.length;
            else index = binarySearch(arrInt, low, high, key);
        }else if (key == arrInt[middle]) index = middle;

        return index;
    }

    public static void sort(int[] arrInt){
        for (int i=0; i < arrInt.length; i++){
            for (int j=0; j < arrInt.length-1; j++){
                if (arrInt[j] > arrInt[j+1]){
                    int temp = arrInt[j];
                    arrInt[j] = arrInt[j+1];
                    arrInt[j+1] = temp;
                }
            }
        }
    }

    public static void printArray(int[] arrInt){
        for (int j : arrInt) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
