package Controller;

import classModel.WisataTampil;
import classModel.cart;
import classModel.cartTampil;
import classModel.lokalProdukTampil;
import classModel.pembayaran;
import classModel.pembayaranTampil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.DbConnection;

public class MenuMember {

    public LinkedList<WisataTampil> getAllWisata() throws IOException {
        LinkedList<WisataTampil> dp = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();
        String sql = "select * from pariwisata where status = true";
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
        String sql = "select * from lokalproduk where status = true";
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

    public LinkedList<cartTampil> getAllCart(int id) throws IOException {
        LinkedList<cartTampil> dp = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();
        String sql = "SELECT cart.idcart, lokalproduk.NamaBarang, lokalproduk.Kuantitas, lokalproduk.HargaBarang, lokalproduk.KodeBarang, lokalproduk.GambarBarang "
                + "FROM cart INNER JOIN lokalproduk ON cart.KodeBarang=lokalproduk.KodeBarang WHERE IdUser='" + id + "'";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cartTampil p = new cartTampil();
                p.setIdcart(rs.getInt(1));
                p.setNamaBarang(rs.getString(2));
                p.setKuantitas(rs.getInt(3));
                p.setHargaBarang(rs.getDouble(4));
                p.setKodeBarang(rs.getInt(5));

                Blob blob = rs.getBlob(6);
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
                System.out.println("dicetak");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuMember.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.getClosed();
        }
        return dp;
    }

    public static int inputCart(cart cart) {
        DbConnection dbCon = new DbConnection();
        int count = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "insert into cart (IdUser,KodeBarang) values (?,?)";
        try {
            conn = dbCon.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, cart.getMember().getIdUser());
            pstmt.setInt(2, cart.getProduk());
            count = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Message : " + e.getMessage());
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MenuMember.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return count;
    }

    public int kirimPesanan(int id) {
        DbConnection dbCon = new DbConnection();
        int count = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        InputStream inputStream = null;

        String sql = "insert into pesanan (Tanggal,Status,idpembayaran) values (?,?,?)";
        try {
            conn = dbCon.getConnection();
            pstmt = conn.prepareStatement(sql);
            java.util.Date utilDate = new java.util.Date();
            java.sql.Timestamp sqlTS = new java.sql.Timestamp(utilDate.getTime());
            pstmt.setTimestamp(1, sqlTS);
            pstmt.setInt(3, id);
            pstmt.setBoolean(2, false);
            count = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Message : " + e.getMessage());
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MenuMember.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return count;
    }

    public int getIdPembayaran(int idCart) throws IOException {
        int id = 0;
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();
        String sql = "Select idpembayaran from pembayaran where idcart = '" + idCart + "'";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt(1);
                System.out.println("dicetak");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuMember.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.getClosed();
        }
        return id;
    }

    public int editCart(int idCart) {
        int count = 0;
        DbConnection dbConn = new DbConnection();
        Connection conn = null;
        Statement st = null;

        conn = dbConn.getConnection();
        String sql = "update cart set status ='" + 1 + "' where idcart= '" + idCart + "'";

        try {
            st = conn.createStatement();
            count = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MenuMember.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MenuMember.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return count;

    }

    public static int inputPembayaran(pembayaran pembayaran) {
        DbConnection dbCon = new DbConnection();
        int count = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        InputStream inputStream = null;
        try {
            inputStream = pembayaran.getBuktiBayar().getInputStream();

        } catch (IOException ex) {
            Logger.getLogger(MenuMember.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "insert into pembayaran (Tanggal,buktiBayar,Status,"
                + " IdCart) values (?,?,?,?)";
        try {
            conn = dbCon.getConnection();
            pstmt = conn.prepareStatement(sql);
            java.util.Date utilDate = new java.util.Date();
            java.sql.Timestamp sqlTS = new java.sql.Timestamp(utilDate.getTime());
            pstmt.setTimestamp(1, sqlTS);
            pstmt.setInt(4, pembayaran.getKeranjang());
            pstmt.setBoolean(3, pembayaran.isStatus());
            if (inputStream != null) {
                pstmt.setBlob(2, inputStream);
            }
            count = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Message : " + e.getMessage());
        } finally {
            try {
                pstmt.close();
                conn.close();
                inputStream.close();
            } catch (SQLException ex) {
                Logger.getLogger(MenuAdminDesa.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MenuAdminDesa.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return count;
    }

    public pembayaranTampil getDetailPembayaran(int idCart) throws IOException {
        pembayaranTampil dp = new pembayaranTampil();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();
        String sql = "SELECT lokalproduk.gambarbarang, lokalproduk.kuantitas, lokalproduk.hargabarang,lokalproduk.namabarang,pengunjungmember.alamat,cart.idcart,lokalproduk.kodebarang "
                + "FROM ((pengunjungmember INNER JOIN cart ON pengunjungmember.iduser = cart.iduser) "
                + "INNER JOIN lokalproduk ON cart.kodebarang = lokalproduk.kodebarang) WHERE cart.Idcart='" + idCart + "';";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dp.setKuantitas(rs.getInt(2));
                dp.setHargaBarang(rs.getDouble(3));
                dp.setNamaBarang(rs.getString(4));
                dp.setAlamat(rs.getString(5));
                dp.setIdCart(rs.getInt(6));
                dp.setIdBarang(rs.getInt(7));
                Blob blob = rs.getBlob(1);
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                dp.setBase64Image(base64Image);
                inputStream.close();
                outputStream.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuMember.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.getClosed();
        }
        return dp;
    }

    public int hapusCart(int idCart) {
        int count = 0;
        DbConnection dbConn = new DbConnection();
        Connection conn = null;
        Statement st = null;

        conn = dbConn.getConnection();
        String sql = "delete from cart where IdCart=  '" + idCart + "'";

        try {
            st = conn.createStatement();
            count = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MenuMember.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MenuMember.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return count;
    }
}
