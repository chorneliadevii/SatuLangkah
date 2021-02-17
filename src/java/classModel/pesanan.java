
package classModel;

import java.sql.Date;

public class pesanan {
    private int idPesanan;
    private Date tanggal ;
    private boolean status;
    private pembayaran bayar;

    public pesanan() {
    }

    public int getIdPesanan() {
        return idPesanan;
    }

    public void setIdPesanan(int idPesanan) {
        this.idPesanan = idPesanan;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public pembayaran getBayar() {
        return bayar;
    }

    public void setBayar(pembayaran bayar) {
        this.bayar = bayar;
    }
    
    
}
