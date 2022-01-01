package com.child;

import com.company.Company;

public class PerusahaanPerdagangan extends Company {

    public PerusahaanPerdagangan(String name){
        super(name);
    }

    public PerusahaanPerdagangan(String bidang, int tahun){
        super(bidang, tahun);
    }

    public PerusahaanPerdagangan(int jumlahSaham, int hargaSaham){
        super(jumlahSaham, hargaSaham);
    }

    public PerusahaanPerdagangan(long pendapatan, long gajiKaryawan, double pajak){
        super(pendapatan, gajiKaryawan, pajak);
    }
}
