package com.code;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        RekapNilai rn = new RekapNilai();
        int nilai;
        String matkul;
        String nama;

        try{
            System.out.print("Masukkan nama : ");
            nama = userInput.nextLine();
            rn.setNama(nama);
            System.out.print("Masukkan matkul : ");
            matkul = userInput.nextLine();
            rn.setMatkul(matkul);
            System.out.print("Masukkan nilai : ");
            nilai = userInput.nextInt();
            rn.setNilai(nilai);

            if(rn.getNama() == null){
                throw new Exception();
            }else if (rn.getMatkul() == null){
                throw new Exception();
            }
//            }else if (rn.getNilai() = 0){
//                throw new Exception();
//            }





        }catch (Exception e){
            System.out.println("nama tidak boleh kosong");
        } catch (Exception b){
            System.out.println("nilai tidak boleh kosong");
        }finally {
            System.out.println("Terimakasih telah mengisi bio data");
        }


    }
}
