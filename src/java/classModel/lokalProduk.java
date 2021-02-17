package classModel;

import javax.servlet.http.Part;

public class lokalProduk {

    private int idProdukLokal;
    private String namaBarang;
    private double harga;
    private int kuantitas;
    private Part gambarProduk;
    private String keterangan;
    private boolean status;
    private AdminDesa admin ;

    public lokalProduk() {
        admin = new AdminDesa();
    }

    public int getIdProdukLokal() {
        return idProdukLokal;
    }

    public void setIdProdukLokal(int idProdukLokal) {
        this.idProdukLokal = idProdukLokal;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
    }

    public Part getGambarProduk() {
        return gambarProduk;
    }

    public void setGambarProduk(Part gambarProduk) {
        this.gambarProduk = gambarProduk;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
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
