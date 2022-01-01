package com.child;

import com.utama.Company;

public class DirekturUtama extends Company {

    public DirekturUtama(){

    }

    public DirekturUtama(String name){
        super(name);
    }

    public DirekturUtama(String jabatan, String tugas){
        super(jabatan,tugas);
    }

    public DirekturUtama(int jatah, int totalSaham, double hargaSaham){
        super(jatah,totalSaham, hargaSaham);
    }




}
