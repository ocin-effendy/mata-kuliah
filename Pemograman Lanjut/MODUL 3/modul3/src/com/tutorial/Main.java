package com.tutorial;

import java.util.Scanner;

class Balok{
    private int panjang;
    private int lebar;
    private int tinggi;


    public int getPanjang() {
        return panjang;
    }

    public void setPanjang(int panjang) {
        this.panjang = panjang;
    }

    public int getLebar() {
        return lebar;
    }

    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    public int getTinggi() {
        return tinggi;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    public void hasil(){
        Perhitungan ph = new Perhitungan();
        System.out.println("Hasil luas kubus : " + ph.luas(this));
        System.out.println("Hasil volume kubus : " + ph.volume(this));
        System.out.println("hasil cekIsCube : " + isCube(ph.luas(this)));

    }

    boolean isCube(long input){
        boolean y;
        y = Math.round(Math.cbrt(input)) * Math.round(Math.cbrt(input)) * Math.round(Math.cbrt(input)) == input;
        return y;
    }





}

class Perhitungan{

    protected int luas(Balok sisi){
        return sisi.getPanjang() * sisi.getLebar() * sisi.getTinggi();
    }

    protected int volume(Balok sisi){
        return sisi.getPanjang() * sisi.getLebar() * sisi.getTinggi() * 4;
    }

}
public class Main {

    public static void main(String[] args) {

        int panjang;
        int lebar;
        int tinggi;
        Balok balok = new Balok();
        Scanner n = new Scanner(System.in);

        System.out.print("masukkan panjang : ");
        panjang = n.nextInt();
        System.out.print("masukkan lebar : ");
        lebar = n.nextInt();
        System.out.print("masukkan tinggi : ");
        tinggi = n.nextInt();
        balok.setPanjang(panjang);
        balok.setLebar(lebar);
        balok.setTinggi(tinggi);
        balok.hasil();


    }
}
