package classModel;

import java.util.LinkedList;

public class DaftarProduk {

    private LinkedList<lokalProdukTampil> daftar;

    public DaftarProduk() {
    }

    public LinkedList<lokalProdukTampil> getDaftar() {
        return daftar;
    }

    public void setDaftar(LinkedList<lokalProdukTampil> daftar) {
        this.daftar = daftar;
    }

}
