package com.code;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

class DataPraktikan {
    HashMap<String, String> tabelSesiLogin = new HashMap<>();

    public boolean login(){
        tabelSesiLogin.put("admin@webmail.umm.ac.id", "admin");
        tabelSesiLogin.put("niko", "asd");

        boolean check = false;
        Scanner userInput = new Scanner(System.in);
        System.out.print("Masukkan Email : ");
        String email = userInput.nextLine();
        System.out.print("Masukkan Password : ");
        String pass = userInput.nextLine();
        for (Object n : tabelSesiLogin.keySet()){
            if (tabelSesiLogin.get(n).equals(pass) && n.equals(email)){
                check = true;
            }
        }
        return check;
    }

    public boolean tambahData(HashMap<String, String> data, String nimPraktikan, String namaAsisten){
        boolean check = false;
        if (nimPraktikan.contains("IF")){
            data.put(nimPraktikan,namaAsisten);
            check = true;
        }
        return check;
    }

    public void tampil(HashMap<String, String> data){
        System.out.println("| No |\t\t  Nim\t\t   |\t Nama Asisten\t    |");
        System.out.println("-----------------------------------------------------");
        int i = 1;
        for (Object n : data.keySet()){
            System.out.printf("| %-3d", i);
            System.out.printf("|\t%-19s", n);
            System.out.printf("|\t%-5s", data.get(n));
            System.out.println( );
            i++;
        }
        System.out.println("Total data : " + data.size());
    }

    public void listNinPraktikan(HashMap<String, String> data){
        System.out.println("NIM : " );
        int i = 1;
        for (Object n : data.keySet()){
            System.out.print(i+". ");
            System.out.print(n+ "\n");
            i++;
        }

    }

    public void listNamaAsisten(HashMap<String, String> data){
        int i = 1;
        System.out.println("Nama Asisten : " );
        for (Object n : data.keySet()){
            System.out.print(i+". ");
            System.out.print(data.get(n)+ "\n");
            i++;
        }
    }
    public boolean hapusData(HashMap<String, String> data, String nimPraktikan){
        boolean check = false;
        if (data.containsKey(nimPraktikan)){
            data.remove(nimPraktikan);
            check = true;
        }
        return check;
    }

    public void editData(HashMap<String, String> data, String nimPraktikan, String namaAsisten){
        if (data.containsKey(nimPraktikan)){
            data.replace(nimPraktikan,namaAsisten);
            System.out.println("Data berhasil di edit");

        }else{
            System.out.println("Data tidak tersedia");
        }
    }
}




public class Main {

    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        HashMap<String, String> tabelData = new HashMap<>();
        tabelData.put("IF2020", "Nico");
        tabelData.put("IF2021", "Ahmad");
        tabelData.put("IF2022", "Yanuar");
        tabelData.put("IF2023", "Zibran");
        tabelData.put("IF2025", "Nico");
        tabelData.put("IF202510370311467", "Ahmad");


        String pilih;
        boolean loop = true;
        DataPraktikan dataPraktikan = new DataPraktikan();

        if (dataPraktikan.login()){
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampil Data");
            System.out.println("3. List Nim Praktikan");
            System.out.println("4. List Nama Asisten");
            System.out.println("5. Total Data");
            System.out.println("6. Hapus Data");
            System.out.println("7. Edit Data");
            System.out.println("8. Mencari Nim ang Asisten sama");
            System.out.println("9. Log Out");
            while(loop) {
                System.out.print("\npilih menu : ");
                pilih = userInput.nextLine();
                switch (pilih) {
                    case "1" -> tambahDanEditData(tabelData,dataPraktikan, true);
                    case "2" -> dataPraktikan.tampil(tabelData);
                    case "3" -> dataPraktikan.listNinPraktikan(tabelData);
                    case "4" -> dataPraktikan.listNamaAsisten(tabelData);
                    case "5" -> System.out.println("Total Data : " + tabelData.size());
                    case "6" -> hapusData(tabelData, dataPraktikan);
                    case "7" -> tambahDanEditData(tabelData, dataPraktikan,false);
                    case "8" -> searchNim(tabelData);
                    case "9" -> loop = false;
                    default -> System.out.println("Salah input");
                }
            }
        }
    }

    public static void tambahDanEditData(HashMap<String, String> data, DataPraktikan data2, boolean check){
        String nim, namaAsisten;
        String message = check ? "Input" : "Edit";
        System.out.println("======== " + message + " Data =========");
        System.out.print("Masukkan Nim : ");
        nim = userInput.nextLine();
        System.out.print("Masukkan Nama Asisten : ");
        namaAsisten = userInput.nextLine();
        if (check){
            if (data2.tambahData(data, nim, namaAsisten)) System.out.println("Data Berhasil di Input");
            else System.out.println("Data Gagal di Input");
        }else data2.editData(data, nim, namaAsisten);
    }



    public static void hapusData(HashMap<String, String> data, DataPraktikan data2){
        String nim;
        System.out.println("========== Hapus Data ===========");
        System.out.print("Masukkan Nim : ");
        nim = userInput.nextLine();
        if (data2.hapusData(data,nim)) System.out.println("Data Berhasil di Hapus");
        else System.out.println("Data Gagal di Hapus");
    }

    public static void searchNim(HashMap<String, String> data){
        System.out.println("========== Search Data ===========");
        System.out.print("Masukkan Nama Asisten : ");
        String namaAsisten = userInput.nextLine();
        System.out.println("Nama Asisten : " + namaAsisten);
        for (Object n : data.keySet()) {
            if (data.get(n).equals(namaAsisten)) {
                System.out.println("Nim : " + n);
            }else if(!data.containsValue(namaAsisten)){
                System.out.println("Data tidak tersedia");
                break;
            }
        }
    }




    public static boolean stopOrNext(String massage){
        System.out.print(massage);
        String Input = userInput.nextLine();
        return Input.equalsIgnoreCase("y");
    }

}
