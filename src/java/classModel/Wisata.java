package classModel;

import javax.servlet.http.Part;

public class Wisata {

    private int idWisata;
    private String namaTempat;
    private String alamat;
    private String keterangan;
    private Part gambar;
    private boolean status;
    private AdminDesa admin;

    public Wisata() {
        admin = new AdminDesa();
    }

    public int getIdWisata() {
        return idWisata;
    }

    public void setIdWisata(int idWisata) {
        this.idWisata = idWisata;
    }

    public String getNamaTempat() {
        return namaTempat;
    }

    public void setNamaTempat(String namaTempat) {
        this.namaTempat = namaTempat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Part getGambar() {
        return gambar;
    }

    public void setGambar(Part gambar) {
        this.gambar = gambar;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public AdminDesa getAdmin() {
        return admin;
    }

    public void setAdmin(AdminDesa admin) {
        this.admin = admin;
    }

}