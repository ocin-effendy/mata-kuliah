package com.tutorial;

public class Company {
    private static String namaPerusahaan;
    private static String alamatPerusahaan;

    public Company(){

    }

    protected void setNamaPerusahaan(String namaPerusahaan){
        Company.namaPerusahaan = namaPerusahaan;
    }

    private String getNamaPerusahaan(){
        return Company.namaPerusahaan;
    }


    protected void setAlamatPerusahaan(String alamatPerusahaan){
        Company.alamatPerusahaan = alamatPerusahaan;
    }

    private String getAlamat(){
        return Company.alamatPerusahaan;
    }

    public void jumlahGaji(int a, int b, int c){
        System.out.println("Gaji DIrektur\t: Rp." + (a+b+c));
    }

    public void jumlahGaji(int a, int b){
        System.out.println("Gaji Wakil Direktur\t: Rp." + (a + b));
    }

    public void jumlahGaji(int a){
        System.out.println("Gaji Manager\t: Rp." + a);
    }


    public void tampil(){
        System.out.println("\n");
        System.out.println("Nama Perusahaan\t: " + getNamaPerusahaan());
        System.out.println("Alamat Perusahaan\t: " + getAlamat());

    }

}
