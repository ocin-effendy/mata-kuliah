package sample;

public class ModalTable {
    private String pasien;
    private String alamat;
    private String nmWali;
    private String umurr;
    private String rekamMedis;


    public ModalTable(String pasien,String alamat, String nmWali,String umurr,String rekamMedis){
        this.pasien = pasien;
        this.alamat = alamat;
        this.nmWali = nmWali;
        this.umurr = umurr;
        this.rekamMedis = rekamMedis;

    }

    public ModalTable() {

    }

    public String getPasien() {
        return pasien;
    }

    public void setPasien(String pasien) {
        this.pasien = pasien;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNmWali() {
        return nmWali;
    }

    public void setNmWali(String nmWali) {
        this.nmWali = nmWali;
    }

    public String getUmurr() {
        return umurr;
    }

    public void setUmurr(String umurr) {
        this.umurr = umurr;
    }

    public String getRekamMedis() {
        return rekamMedis;
    }

    public void setRekamMedis(String rekamMedis) {
        this.rekamMedis = rekamMedis;
    }
}
