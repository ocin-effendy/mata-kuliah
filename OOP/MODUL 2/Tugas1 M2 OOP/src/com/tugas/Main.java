package com.tugas;

class Kilogram{
    int g = 1000;
    int kg;

    public void ubahKeKg(){
        kg = g / 1000;
        System.out.println(this.g + " gr sama dengan : " + this.kg + " Kg");
    }
}

class Hektogram{
    int g = 1000;
    int hg;

    public void ubahKeHekto(){
        hg = g / 100;
        System.out.println(this.g + " gr sama dengan : " + this.hg + " Hg");
    }
}

class Dekagram{
    int g = 1000;
    int dag;

    public void ubahKeDeka(){
        dag = g / 10;
        System.out.println(this.g + " gr sama dengan : " + this.dag + " Dag");
    }
}

class Desigram{
    int g = 1000;
    int dg;

    public void ubahKeDesi(){
        dg = g * 10;
        System.out.println(this.g + " gr sama dengan : " + this.dg + " Dg");
    }
}

class Centigram{
    int g = 1000;
    int cg;

    public void ubahKeCenti(){
        cg = g * 100;
        System.out.println(this.g + " gr sama dengan : " + this.cg + " Cg");
    }
}

class Miligram{
    int g = 1000;
    int mg;

    public void ubahKeDesi(){
        mg = g * 1000;
        System.out.println(this.g + " gr sama dengan : " + this.mg + " Mg");
    }
}
public class Main {

    public static void main(String[] args) {

        // Gram ke KG
        Kilogram kilo = new Kilogram();
        kilo.ubahKeKg();

        // Gram ke HG
        Hektogram hekto = new Hektogram();
        hekto.ubahKeHekto();

        // Gram ke DAG
        Dekagram deka = new Dekagram();
        deka.ubahKeDeka();

        // Gram ke DG
        Desigram desi = new Desigram();
        desi.ubahKeDesi();

        // Gram ke CG
        Centigram centi = new Centigram();
        centi.ubahKeCenti();

        // Gram ke MG
        Miligram mili = new Miligram();
        mili.ubahKeDesi();





    }
}
