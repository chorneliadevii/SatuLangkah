package classModel;

public class lokalProdukTampil {

    private int idProdukLokal;
    private String namaBarang;
    private double harga;
    private int kuantitas;
    private String base64Image;
    private String keterangan;
    private boolean status;
    private int IdAdmin ;

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

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
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

    public int getIdAdmin() {
        return IdAdmin;
    }

    public void setIdAdmin(int IdAdmin) {
        this.IdAdmin = IdAdmin;
    }

}
