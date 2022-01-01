package com.tugas;

class Pembeli {
    String nama;
    int uang;
    int sisaUang;
    private Barang barang;

     Pembeli(String nama){
        this.nama = nama;
        this.uang = 100000;
    }

    public void setBarang(Barang barang){
        this.barang = barang;
    }


   private int getSisaUang(){
        return this.sisaUang = this.uang - this.barang.getHarga();
   }

    public void display(){
        System.out.println("Uang " + this.nama + " adalah Rp." + this.uang);
        System.out.println(this.nama + " membayar " + this.barang.getNama() + " seharga Rp." + this.barang.getHarga());
        System.out.println("Sisa uang " + this.nama + " menjadi : " + getSisaUang());
    }



}

class Barang{
    private String nama;
    private int harga;

    public void setNama(String nama){
        this.nama = nama;
    }
    public void setHarga(int harga){
        this.harga = harga;
    }

    public int getHarga(){
        return this.harga;
    }
    public String getNama(){
        return this.nama;
    }



}


public class Main {

    public static void main(String[] args) {
        Pembeli pembeli1 = new Pembeli("Nico");
        Barang barang1 = new Barang();
        barang1.setNama("Sekolah");
        barang1.setHarga(1000);
        pembeli1.setBarang(barang1);
        pembeli1.display();


    }
}
