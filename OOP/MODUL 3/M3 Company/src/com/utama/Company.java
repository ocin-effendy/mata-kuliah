package com.utama;

public class Company {
     String name;
     String jabatan;
     String tugas;
     int jatah;
     int totalSaham;
     double totalAset;
     int pajak;
     double hargaSaham;

    public Company(){

    }
    public Company(String name){
        this.name = name;
        System.out.println("Nama\t: " + this.name);
    }

    public Company(String jabatan, String tugas){
        this.jabatan = jabatan;
        this.tugas = tugas;
        System.out.println("Jabatan\t: " + this.jabatan);
        System.out.println("Tugas\t: " + this.tugas);
    }

    public Company(int jatah, int totalSaham, double hargaSaham){
        this.jatah = jatah;
        this.totalSaham = totalSaham;
        this.hargaSaham = hargaSaham;
        this.totalAset = this.jatah * this.totalSaham * this.hargaSaham / 100;
        System.out.println("Total Aset yang Dimiliki :Rp." + this.totalAset);
    }






}
