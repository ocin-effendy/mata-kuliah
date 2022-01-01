package com.tugas;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
     //   int[] daftarPulsa = {5000,10000,15000,20000,50000};
      //  System.out.println("ini array nomor pulsa ke 1 :" + daftarPulsa[0]);
        String nomor;
        String inputPulsa;
        boolean isData = true;
        boolean isData1 = true;

        String[] daftarPulsa = {"5000","10000","15000","20000","50000"};
        char[] nomorIndo = new char[4];
        nomorIndo[0] = '0';
        nomorIndo[1] = '8';
        nomorIndo[2] = '1';
        nomorIndo[3] = '2';

        // Meninputkaan nomor sampai benar <0812>
        do{
            System.out.print("masukkan Nomor : ");
            nomor = userInput.nextLine();
            char[] arrNomor;
            arrNomor = nomor.toCharArray();
            for(int i=0; i < nomorIndo.length; i++){
                if (arrNomor[i] != nomorIndo[i]){
                    System.out.println("Nomor Yang Anda Inputkan Salah");
                    isData = true;
                    break;
                }else{
                    isData = false;
                }
            }

        }while(isData);

        // Menampilkan Daftar Pulsa
        System.out.println("= Daftar Pulsa = ");
        for (int i=0; i<daftarPulsa.length; i++) {
            System.out.printf("%s\n", daftarPulsa[i]);

        }

        do{
            System.out.print("Inputkan Pulsa : ");
            inputPulsa = userInput.nextLine();

            for (int i=0; i<daftarPulsa.length; i++){
                if (inputPulsa.equals(daftarPulsa[i])){
                    System.out.println("pulsa tersedia");
                    isData1 = false;
                    break;
                }else{
                    System.out.println("pulsa tidak tersedia");
                    isData1 = true;
                }
            }
        }while(isData1);

        System.out.println("\nTransaksi Berhasil\n");




//        do{
//            System.out.print("masukkan Nomor : ");
//            nomor = userInput.nextLine();
//            char[] arrNomor;
//            arrNomor = nomor.toCharArray();
//            isData = cekNomor(arrNomor, isData);
//        }while(isData);
//
//        System.out.println("= Daftar Pulsa = ");
//        for (int i=0; i<daftarPulsa.length; i++){
//            System.out.printf("%s\n", daftarPulsa[i]);
//        }
//
//        do{
//            System.out.print("Inputkan Pulsa : ");
//            inputPulsa = userInput.nextLine();
//            isData1 = cekPulsa(inputPulsa, isData1);
//
//        }while(isData1);
//

    }

//    private static boolean cekNomor(char dataNomor[], boolean cekData){
//        char[] nomorIndo = new char[4];
//        nomorIndo[0] = '0';
//        nomorIndo[1] = '8';
//        nomorIndo[2] = '1';
//        nomorIndo[3] = '2';
//
//        for(int i=0; i < nomorIndo.length; i++){
//            if (dataNomor[i] != nomorIndo[i]){
//                System.out.println("Nomor Yang Anda Inputkan Salah");
//                cekData = true;
//                break;
//            }else{
//                cekData = false;
//            }
//        }
//
//        return cekData;
//    }
//
//    private static boolean cekPulsa(String dataPulsa, boolean cekData){
//        String[] daftarPulsa = {"5000","10000","15000","20000","50000"};
//
//        for (int i=0; i<daftarPulsa.length; i++){
//            if (dataPulsa.equals(daftarPulsa[i])){
//                System.out.println("pulsa tersedia");
//                cekData = false;
//                break;
//            }else{
//                System.out.println("pulsa tidak tersedia");
//                cekData = true;
//            }
//        }
//        return cekData;
//    }



}
