package com.company;

public class Company {

    String name;
    String bidang;
    int tahun;
    int jumlahSaham;
    int hargaSaham;
    long kapitalisasiPasar;
    long pendapatan;
    long gajiKaryawan;
    double pajak;
    double pendapatanBersih;

    public Company(){

    }

    public Company(String name){
        this.name = name;
        System.out.println("Nama Perusahaan \t: " + this.name);

    }

    public Company(String bidang, int tahun){
        this.bidang = bidang;
        this.tahun = tahun;
        System.out.println("Bidang \t: " + this.bidang);
        System.out.println("Tahun berdiri \t: " + this.tahun);
    }

    public Company(int jumlahSaham, int hargaSaham){
        this.jumlahSaham = jumlahSaham;
        this.hargaSaham = hargaSaham;
        kapitalisasiPasar = (long)jumlahSaham * (long)hargaSaham;
        System.out.println("Kapitalisasi Pasar :Rp." + this.kapitalisasiPasar);

    }

    public Company(long pendapatan, long gajiKaryawan, double pajak){
        this.pendapatan = pendapatan;
        this.gajiKaryawan = gajiKaryawan;
        this.pajak = pajak;
        pendapatanBersih = (this.pendapatan * this.pajak / 100) - this.gajiKaryawan;
        System.out.println("Pendapatan Bersih Per Tahun : " + this.pendapatanBersih);
        System.out.println("\n");
    }

    public void display(){
        System.out.println("Perusahaan Indonesia");
    }

}
