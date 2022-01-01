package com.company;

import com.child.*;

public class Main {

    public static void main(String[] args) {


        // Ekstraktif
        PerusahaanEkstraktif pe = new PerusahaanEkstraktif("PT Pertamina");
        pe.display();
        PerusahaanEkstraktif pe1 = new PerusahaanEkstraktif("Energi, Minyak dan Gas Bumi", 2002);
        PerusahaanEkstraktif pe2 = new PerusahaanEkstraktif(12000000, 3055);
        PerusahaanEkstraktif pe3 = new PerusahaanEkstraktif(300000000, 1500000,10.0);


        // Agraris
        PerusahaanAgraris pa = new PerusahaanAgraris("PT Astra Argo Lestari Tbk");
        pa.display();
        PerusahaanAgraris pa1 = new PerusahaanAgraris("Perkebunan", 1984);
        PerusahaanAgraris pa2 = new PerusahaanAgraris(87000000, 5703);
        PerusahaanAgraris pa3 = new PerusahaanAgraris(240000000, 920000,12.3);


        // Industri
        PerusahaanIndustri pi = new PerusahaanIndustri("PT Miwon Indonesia Tbk");
        pi.display();
        PerusahaanIndustri pi1 = new PerusahaanIndustri("Monosodium Glutamate", 1973);
        PerusahaanIndustri pi2 = new PerusahaanIndustri(481000000, 1525);
        PerusahaanIndustri pi3 = new PerusahaanIndustri(210000000, 420000,14.5);

        // Perdagangan
        PerusahaanPerdagangan pp = new PerusahaanPerdagangan("PT Ace Hardware Indonesia");
        pp.display();
        PerusahaanPerdagangan pp1 = new PerusahaanPerdagangan("Perlengkapan Ruangan", 1995);
        PerusahaanPerdagangan pp2 = new PerusahaanPerdagangan(710000000, 805);
        PerusahaanPerdagangan pp3 = new PerusahaanPerdagangan(900000000, 7300000,11.1);

        // Jasa
        PerusahaanJasa pj = new PerusahaanJasa("Alam Sutera Reality");
        pj.display();
        PerusahaanJasa pj1 = new PerusahaanJasa("Property Developers", 1993);
        PerusahaanJasa pj2 = new PerusahaanJasa(9900000, 5040);
        PerusahaanJasa pj3 = new PerusahaanJasa(120000000, 105000,8.9);



    }
}
