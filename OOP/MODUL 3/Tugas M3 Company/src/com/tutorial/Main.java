package com.tutorial;

import com.anggota.DirekturUtama;
import com.anggota.Manager;
import com.anggota.WakilDirektur;

public class Main {

    public static void main(String[] args) {
        int a = 1000;
        int b = 500;
        int c = 100;
        String namaPerusahaan = "Gudang Garam";
        String alamatPerusahaan = "Surabaya";
        Company com = new Company();
        com.setNamaPerusahaan(namaPerusahaan);
        com.setAlamatPerusahaan(alamatPerusahaan);


        // Direktur Utama
        DirekturUtama du = new DirekturUtama("Direktur Utama");
        du.setName("Bambang Pamungkas");
        du.setAlamat1("Jl.Soekarno Hatta");
        du.setTugas("tugas direktur utama");
        du.tampil();

        // Wakil Direktur
        WakilDirektur wd = new WakilDirektur("Wakil Direktur");
        wd.setName("Bimbing Pimingkis");
        wd.setAlamat1("Jl.Bromo Utata");
        wd.setTugas("tugas wakil direktur");
        wd.tampil();

        // Manager
        Manager m = new Manager("Manager");
        m.setName("Bumbung Pumungkus");
        m.setAlamat1("Jl.Raya Bandung");
        m.setTugas("tugas wakil manager");
        m.tampil();

        //daftar gaji
        System.out.println("\n====================");
        System.out.println("    Daftar Gaji     ");
        System.out.println("====================");
        du.jumlahGaji(a,b,c);
        wd.jumlahGaji(a,b);
        m.jumlahGaji(a);

    }
}
