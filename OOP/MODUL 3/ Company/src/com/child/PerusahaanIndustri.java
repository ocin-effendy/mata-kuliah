package com.child;

import com.company.Company;

public class PerusahaanIndustri extends Company {

    public PerusahaanIndustri(String name){
        super(name);
    }

    public PerusahaanIndustri(String bidang, int tahun){
        super(bidang, tahun);
    }

    public PerusahaanIndustri(int jumlahSaham, int hargaSaham){
        super(jumlahSaham, hargaSaham);
    }

    public PerusahaanIndustri(long pendapatan, long gajiKaryawan, double pajak){
        super(pendapatan, gajiKaryawan, pajak);
    }
}
