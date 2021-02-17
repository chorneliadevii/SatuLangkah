/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classModel;

import java.util.LinkedList;

public class DaftarPembayaranVerif {

    private LinkedList<pembayaranVerif> daftar;

    public DaftarPembayaranVerif() {
    }

    public LinkedList<pembayaranVerif> getDaftar() {
        return daftar;
    }

    public void setDaftar(LinkedList<pembayaranVerif> daftar) {
        this.daftar = daftar;
    }
}
