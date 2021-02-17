package classModel;

import java.sql.Date;
import javax.servlet.http.Part;

public class pembayaran {

    

        private int idPembayaran;
        private Date tanggal;
        private Part buktiBayar;
        private boolean status;
        private int keranjang;

        public pembayaran() {
        }

        public int getIdPembayaran() {
            return idPembayaran;
        }

        public void setIdPembayaran(int idPembayaran) {
            this.idPembayaran = idPembayaran;
        }

        public Date getTanggal() {
            return tanggal;
        }

        public void setTanggal(Date tanggal) {
            this.tanggal = tanggal;
        }

        public Part getBuktiBayar() {
            return buktiBayar;
        }

        public void setBuktiBayar(Part buktiBayar) {
            this.buktiBayar = buktiBayar;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public int getKeranjang() {
            return keranjang;
        }

        public void setKeranjang(int keranjang) {
            this.keranjang = keranjang;
        }

    
}
