package com.child;

import com.company.Company;

public class PerusahaanEkstraktif extends Company {

    public PerusahaanEkstraktif(String name){
        super(name);
    }

    public PerusahaanEkstraktif(String bidang, int tahun){
        super(bidang, tahun);
    }

    public PerusahaanEkstraktif(int jumlahSaham, int hargaSaham){
        super(jumlahSaham, hargaSaham);
    }

    public PerusahaanEkstraktif(long pendapatan, long gajiKaryawan, double pajak){
        super(pendapatan, gajiKaryawan, pajak);
    }
}
