package com.anggota;

import com.tutorial.Company;

public class DirekturUtama extends Company {
    private String name;
    private final String jabatan;
    private String alamat1;
    private String tugas;


    public DirekturUtama(String jabatan){
        this.jabatan = jabatan;
    }

    public void setName(String name){
        this.name = name;
    }

    private String getName(){
        return this.name;
    }

    public void setAlamat1(String alamat1){
        this.alamat1 = alamat1;
    }

    private String getAlamat1(){
        return this.alamat1;
    }

    public void setTugas(String tugas){
        this.tugas = tugas;
    }

    private String getTugas(){
        return this.tugas;
    }



    public void tampil(){
        super.tampil();
        System.out.println("-----------------------------------");
        System.out.println("Posisi\t: " + this.jabatan);
        System.out.println("Nama\t: " + getName());
        System.out.println("Alamat\t: " + getAlamat1());
        System.out.println("Tugas\t: " + getTugas());

    }





}
