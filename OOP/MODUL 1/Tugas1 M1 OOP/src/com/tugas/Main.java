package com.tugas;

class Mahasiswa{
    private String nama;
    private String kelas;
    private String jurusan;
    private String fakultas;
    private String nim;


    public void setNama(String nama) {
        this.nama = nama;
    }

    private String getNama() {
        return this.nama;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    private String getkelas() {
        return this.kelas;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    private String getJurusan() {
        return this.jurusan;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    private String getFakultas() {
        return this.fakultas;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    private String getNim() {
        return this.nim;
    }

    public void tampilkan(){
        System.out.println("Nama\t\t: " + getNama());
        System.out.println("Kelas\t\t: " + getkelas());
        System.out.println("Jurusan\t\t: " + getJurusan());
        System.out.println("Fakultas\t: " + getFakultas());
        System.out.println("Nim\t\t\t: " + getNim());

    }

}

public class Main{

    public static void main(String[] args) {
        Mahasiswa mahasiswa1 = new Mahasiswa();
        // Nama
        mahasiswa1.setNama("Nico Ardia Effendy");
        // Kelas
        mahasiswa1.setKelas("2J");
        // Jurusan
        mahasiswa1.setJurusan("Informatika");
        // Fakultas
        mahasiswa1.setFakultas("Teknik");
        // Nim
        mahasiswa1.setNim("202010370311467");
        // Menampilkan data
        mahasiswa1.tampilkan();



    }
}
