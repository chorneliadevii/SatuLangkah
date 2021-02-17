package Controller;

import classModel.WisataTampil;
import classModel.lokalProdukTampil;
import classModel.pembayaranVerif;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.DbConnection;

public class MenuAdminSatuLangkah {

    public LinkedList<WisataTampil> getAllWisata() throws IOException {
        LinkedList<WisataTampil> dp = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();
        String sql = "select * from pariwisata where status = false";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                WisataTampil p = new WisataTampil();
                p.setIdPariwisata(rs.getInt(1));
                p.setNamaTempat(rs.getString(2));
                p.setAlamat(rs.getString(3));
                p.setStatus(rs.getBoolean(4));

                Blob blob = rs.getBlob(5);
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                p.setBase64Image(base64Image);
                inputStream.close();
                outputStream.close();

                p.setKeterangan(rs.getString(6));
                p.setIdDesa(rs.getInt(7));
                dp.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuMember.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.getClosed();
        }

        return dp;
    }

    public LinkedList<lokalProdukTampil> getAllProduk() throws IOException {
        LinkedList<lokalProdukTampil> dp = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();
        String sql = "select * from lokalproduk where status = false";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                lokalProdukTampil p = new lokalProdukTampil();
                p.setIdProdukLokal(rs.getInt(1));
                p.setNamaBarang(rs.getString(2));
                p.setKuantitas(rs.getInt(3));
                p.setHarga(rs.getDouble(4));

                Blob blob = rs.getBlob(5);
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                p.setBase64Image(base64Image);
                inputStream.close();
                outputStream.close();

                p.setKeterangan(rs.getString(6));
                p.setStatus(rs.getBoolean(7));
                p.setIdAdmin(rs.getInt(8));
                dp.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuMember.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.getClosed();
        }

        return dp;
    }

    public int verifikasiWisata(int idPariwisata) {
        int count = 0;
        DbConnection dbConn = new DbConnection();
        Connection conn = null;
        Statement st = null;

        conn = dbConn.getConnection();
        String sql = "update pariwisata set status ='" + 1 + "' where IdPariwisata= '" + idPariwisata + "'";

        try {
            st = conn.createStatement();
            count = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MenuAdminSatuLangkah.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MenuAdminSatuLangkah.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return count;

    }

    public int verifikasiProduk(int idproduk) {
        int count = 0;
        DbConnection dbConn = new DbConnection();
        Connection conn = null;
        Statement st = null;

        conn = dbConn.getConnection();
        String sql = "update lokalproduk set status ='" + 1 + "' where kodeBarang= '" + idproduk + "'";

        try {
            st = conn.createStatement();
            count = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MenuAdminSatuLangkah.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MenuAdminSatuLangkah.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return count;

    }

    public int hapusProduk(int idproduk) {
        int count = 0;
        DbConnection dbConn = new DbConnection();
        Connection conn = null;
        Statement st = null;

        conn = dbConn.getConnection();
        String sql = "delete from lokalproduk where kodeBarang= '" + idproduk + "'";

        try {
            st = conn.createStatement();
            count = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MenuAdminSatuLangkah.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MenuAdminSatuLangkah.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return count;

    }

    public int hapusDestinasi(int idWisata) {
        int count = 0;
        DbConnection dbConn = new DbConnection();
        Connection conn = null;
        Statement st = null;

        conn = dbConn.getConnection();
        String sql = "delete from pariwisata where IdPariwisata=  '" + idWisata + "'";

        try {
            st = conn.createStatement();
            count = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MenuAdminSatuLangkah.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MenuAdminSatuLangkah.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return count;
    }
    public LinkedList<pembayaranVerif> getAllPembayaran() throws IOException {
        LinkedList<pembayaranVerif> dp = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();
        String sql = "SELECT pesanan.idpesanan, lokalproduk.namabarang, lokalproduk.hargabarang, "
                + "pembayaran.buktibayar "
                + "FROM (((pesanan "
                + "INNER JOIN pembayaran ON pesanan.idpembayaran = pembayaran.idpembayaran) "
                + "INNER JOIN cart ON pembayaran.idcart = cart.idcart) "
                + "INNER JOIN lokalproduk ON cart.kodebarang = lokalproduk.kodebarang) "
                + "WHERE pembayaran.status='0';";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                pembayaranVerif p = new pembayaranVerif();
                p.setIdPesanan(rs.getInt(1));
                p.setNamaBarang(rs.getString(2));
                p.setHargaBarang(rs.getDouble(3));

                Blob blob = rs.getBlob(4);
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                p.setBase64Image(base64Image);
                inputStream.close();
                outputStream.close();

                dp.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuMember.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.getClosed();
        }

        return dp;
    }
}
