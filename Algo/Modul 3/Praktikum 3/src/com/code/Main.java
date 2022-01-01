package com.code;

import java.util.Random;

public class Main {

    static int random(String[] arr,int low,int high){

        Random rand= new Random();
        int pivot = rand.nextInt(high-low)+low;
        System.out.println("ini pivot di random : "+pivot);
        String temp=arr[pivot];
        arr[pivot]=arr[high];
        arr[high]=temp;
        return pivot;
    }

    public static int  partisi(String[] arr, int start, int end){
        int index = 0;
        int index2 = 0;
        int indekPivot = random(arr,start,end);
        System.out.println("ini end di partisi : " + end);
        String pivot = arr[indekPivot];
        System.out.println("ini pivot di partisi : "+ pivot);
            for (int j=0; j < arr.length; j++) {
                if (arr[j].compareTo(pivot)> 0 && j < indekPivot) {
                    String temp = arr[j];
                    arr[j] = arr[indekPivot];
                    arr[indekPivot] = temp;
                    indekPivot = j;

                } else if (arr[j].compareTo(pivot)< 0 && j > indekPivot) {
                    String temp = arr[j];
                    arr[j] = arr[indekPivot];
                    arr[indekPivot] = temp;
                    indekPivot = j;
                }
            }

        return indekPivot;
    }

    public static void sort(String[] arr, int start, int end){
        if (start < end){
            int indexPivot = partisi(arr, start, end);
            sort(arr, start, indexPivot - 1);
            sort(arr, indexPivot + 1,end);
        }
    }



    public static void main(String[] args) {
//        int[] arr = { 2,4,8,75,79,80,81,5,74,3,6,54};
        String[] arr = {"iguana","kuda","mama","ikan","flaminggo", "cicak", "ayam","iga", "bebek", "gajah","cucok","nana","babi"};
        int n = arr.length;
        sort(arr,0,n-1);
        System.out.println("==== hasil ====");
        printArray(arr, n);


//        int index = 0;
//        int index2 = 0;
//        int pivot = arr[arr.length-1];
//        int indekPivot = arr.length-1;
        boolean c = true;
//        while(c) {
//            c = false;
//            for (int i = 0; i < arr.length; i ++){
//                if (arr[i] > pivot){
//                    int temp = arr[i];
//                    arr[i] = pivot;
    //                    arr[pivot] = temp;
//                    c= true;
//                }
//            }
//        }

//            for (int i=0; i < arr.length; i++){
//                for (int j=0; j < arr.length; j++) {
//                    if (arr[j] > pivot && j < indekPivot) {
//                        int temp = arr[j];
//                        arr[j] = arr[indekPivot];
//                        arr[indekPivot] = temp;
//                        indekPivot = j;
//
//                    } else if (arr[j] < pivot && j > indekPivot ) {
//                        int temp = arr[j];
//                        arr[j] = arr[indekPivot];
//                        arr[indekPivot] = temp;
//                        indekPivot = j;
//                    }
//
//                }
//
//                if (arr[i] < pivot) index++;
//                else if(arr[i] > pivot) index2++;
//
//            }



//        printArray(arr, n);
//        int pivotPartisi1 = arr[indekPivot-1];
//        int indekPivotPartisi1 = indekPivot-1;
//        for (int i = 0; i < index; i++ ){
//            for (int j = 0; j < index; j++){
//                if (arr[j] > pivotPartisi1 && j < indekPivotPartisi1){
//                    int temp = arr[j];
//                    arr[j] = arr[indekPivotPartisi1];
//                    arr[indekPivotPartisi1] = temp;
//                    indekPivotPartisi1 = j;
//                }else if(arr[j] < pivotPartisi1 && j > indekPivotPartisi1){
//                    int temp = arr[j];
//                    arr[j] = arr[indekPivotPartisi1];
//                    arr[indekPivotPartisi1] = temp;
//                    indekPivotPartisi1 = j;
//                }
//            }
//        }

//        printArray(arr, n);

//        System.out.println();
//        int pivotPartisi2 = arr[arr.length-1];
//        for (int i = indekPivot+1; i < arr.length; i++){
//            if (arr[i] > pivotPartisi2){
//                int temp = arr[i];
//                arr[i] = arr[arr.length-1];
//                arr[arr.length-1] = temp;
//            }
//        }












//        quickSort(arr, 0, n - 1);
//        System.out.println("Sorted array: ");
//        printArray(arr, n);
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        System.out.println("ini i : " + i);

        for(int j = low; j <= high - 1; j++){
            if (arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }


    static void quickSort(int[] arr, int low, int high){
        if (low < high){
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static void printArray(String[] arr, int size){
        for(int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }



}
