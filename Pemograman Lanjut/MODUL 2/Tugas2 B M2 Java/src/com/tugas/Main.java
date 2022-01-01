package com.tugas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String[][] book = new String[10][100];
        book[0][0] = "Book, Malang. 2021";
        Scanner userInput = new Scanner(System.in);
        String inName;
        String inFrom;
        int inDate;
        boolean isData = true;
        boolean isData1 = true;
        boolean isData2 = true;

        System.out.println("--- Selama Datang ---");
        do{
            System.out.print("Name : ");
            inName = userInput.nextLine();
            isData = cekName(inName,isData);
        }while(isData);

        do{
            System.out.print("From : ");
            inFrom = userInput.nextLine();
            isData1 = cekFrom(inFrom,isData1);
        } while(isData1);

        do{
            System.out.print("Date : ");
            inDate = userInput.nextInt();
            isData2 = cekDate(inDate,isData2);
        } while(isData2);

        String copyData = String.format("%s, %s. %d", inName, inFrom, inDate);
        book[1][0] = copyData;
        lisBuku(book);

    }

    private static boolean cekName(String dataName, boolean cekData){
        String[][] book = new String[10][100];
        book[0][0] = "Book, Malang. 2021";
        for(int i=0; book[i][0] != null; i++){
            if (dataName.equals(book[i])){
                System.out.println("sama");
                cekData = true;
                break;
            }else{
                cekData = false;
            }
        }
        return cekData;
    }

    private static boolean cekFrom(String dataFrom, boolean cekData){
        String[] place = {"Jakarta", "Malang", "Makasar"};

        for(int i=0; i < place.length; i++){
            if (dataFrom.equals(place[i])){
                System.out.println("Data Tempat Rilis Sudah Tersedia");
                cekData = true;
                break;

            }else{
                cekData = false;
            }
        }
        return cekData;
    }

    private static boolean cekDate(int dataDate, boolean cekData){

        if(dataDate <= 2018 || dataDate >= 2021){
            System.out.println("Buku Harus Keluaran 2019 dan 2020");
            cekData = true;
        }else{
            cekData = false;
        }
        return cekData;
    }

    private static void lisBuku(String[][] dataBuku){
        System.out.println("\n-- List Buku -- ");
        for(int i=0; dataBuku[i][0] != null; i++){
            System.out.printf("%s\n", dataBuku[i]);
        }
    }
}
