package com.child;

import com.company.Company;

public class PerusahaanAgraris extends Company {

    public PerusahaanAgraris(String name){
        super(name);
    }

    public PerusahaanAgraris(String bidang, int tahun){
        super(bidang, tahun);
    }

    public PerusahaanAgraris(int jumlahSaham, int hargaSaham){
        super(jumlahSaham, hargaSaham);
    }

    public PerusahaanAgraris(long pendapatan, long gajiKaryawan, double pajak){
        super(pendapatan, gajiKaryawan, pajak);
    }


}
