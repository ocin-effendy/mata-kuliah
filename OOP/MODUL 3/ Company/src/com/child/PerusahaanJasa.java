package com.child;

import com.company.Company;

public class PerusahaanJasa extends Company {

    public PerusahaanJasa(String name){
        super(name);
    }

    public PerusahaanJasa(String bidang, int tahun){
        super(bidang, tahun);
    }

    public PerusahaanJasa(int jumlahSaham, int hargaSaham){
        super(jumlahSaham, hargaSaham);
    }

    public PerusahaanJasa(long pendapatan, long gajiKaryawan, double pajak){
        super(pendapatan, gajiKaryawan, pajak);
    }


}
