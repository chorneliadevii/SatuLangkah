package classModel;

import java.util.LinkedList;

public class DaftarCart {

    private LinkedList<cartTampil> daftar;

    public DaftarCart() {
    }

    public LinkedList<cartTampil> getDaftar() {
        return daftar;
    }

    public void setDaftar(LinkedList<cartTampil> daftar) {
        this.daftar = daftar;
    }

}
