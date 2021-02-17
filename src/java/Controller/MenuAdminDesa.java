package Controller;

import classModel.AdminDesa;
import classModel.Wisata;
import classModel.WisataTampil;
import classModel.lokalProduk;
import classModel.lokalProdukTampil;
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

import javax.servlet.http.Part;
import koneksi.DbConnection;
import servlet.tampilLokalProduk;

public class MenuAdminDesa {

    public static int inputDataWisata(Wisata wisata) {
        DbConnection dbCon = new DbConnection();
        int count = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        InputStream inputStream = null;
        try {
            inputStream = wisata.getGambar().getInputStream();

        } catch (IOException ex) {
            Logger.getLogger(MenuAdminDesa.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "insert into pariwisata (NamaTempat,Alamat,Status,"
                + " GambarWisata,Keterangan,IdDesa) values (?,?,?,?,?,?)";
        try {

            conn = dbCon.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, wisata.getNamaTempat());
            pstmt.setString(2, wisata.getAlamat());
            pstmt.setBoolean(3, wisata.isStatus());
            if (inputStream != null) {
                pstmt.setBlob(4, inputStream);
            }
            pstmt.setString(5, wisata.getKeterangan());
            pstmt.setInt(6, wisata.getAdmin().getIdDesa());
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

    public static int inputLokalProduk(lokalProduk produk) {
        DbConnection dbCon = new DbConnection();
        int count = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        InputStream inputStream = null;
        try {
            inputStream = produk.getGambarProduk().getInputStream();
        } catch (IOException ex) {
            Logger.getLogger(MenuAdminDesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "insert into lokalproduk (NamaBarang,Kuantitas,HargaBarang,"
                + " GambarBarang,Keterangan,Status,IdDesa) values (?,?,?,?,?,?,?)";

        try {

            conn = dbCon.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, produk.getNamaBarang());
            pstmt.setInt(2, produk.getKuantitas());
            pstmt.setDouble(3, produk.getHarga());
            if (inputStream != null) {
                pstmt.setBlob(4, inputStream);
            }
            pstmt.setString(5, produk.getKeterangan());
            pstmt.setBoolean(6, produk.isStatus());
            pstmt.setInt(7, produk.getAdmin().getIdDesa());
            count = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MenuAdminDesa.class.getName()).log(Level.SEVERE, null, ex);
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

    public LinkedList<WisataTampil> getAllWisataDesa(int idDesa) throws IOException {
        LinkedList<WisataTampil> dp = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();
        String sql = "select * from pariwisata where IdDesa ='" + idDesa + "'";
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

    public WisataTampil getWisata(int Id) throws IOException {
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();
        WisataTampil p = null;

        String sql = "select * from pariwisata where IdPariwisata = '" + Id + "'";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                p = new WisataTampil();
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

            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuMember.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.getClosed();
        }

        return p;
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

    public LinkedList<lokalProdukTampil> getAllProduk(int id) throws IOException {
        LinkedList<lokalProdukTampil> dp = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();
        String sql = "select * from lokalproduk where IdDesa ='" + id + "'";
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

    public lokalProdukTampil getProduk(int id) throws IOException {
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();
        String sql = "select * from lokalproduk where KodeBarang ='" + id + "'";
        lokalProdukTampil p = null;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                p = new lokalProdukTampil();
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

            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuMember.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.getClosed();
        }

        return p;

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

    public int updateProduk(lokalProduk produk) throws SQLException {
        int count = 0;
        DbConnection dbConn = new DbConnection();
        Connection conn = null;
        Statement st = null;
        PreparedStatement pstmt = null;
        InputStream inputStream = null;
        conn = dbConn.getConnection();
        if (produk.getGambarProduk().getSize() > 0) {
            try {
                inputStream = produk.getGambarProduk().getInputStream();
            } catch (IOException ex) {
                Logger.getLogger(MenuAdminDesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(inputStream);
        String sql = null;
        System.out.println(produk.isStatus());

        if (inputStream == null) {
            sql = "update lokalproduk set NamaBarang = '" + produk.getNamaBarang() + "',Kuantitas ='" + produk.getKuantitas()
                    + "',HargaBarang ='" + produk.getHarga() + "', Status = 0, Keterangan ='" + produk.getKeterangan()
                    + "' where KodeBarang ='" + produk.getIdProdukLokal() + "'";
            st = conn.createStatement();
            count = st.executeUpdate(sql);

        } else if (inputStream != null) {
            sql = "update lokalproduk set NamaBarang = ?, Kuantitas = ? ,HargaBarang = ?, GambarBarang = ?, Keterangan = ?, Status = ? where KodeBarang =?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, produk.getNamaBarang());
            pstmt.setInt(2, produk.getKuantitas());
            pstmt.setDouble(3, produk.getHarga());
            if (inputStream != null) {
                pstmt.setBlob(4, inputStream);
            }
            pstmt.setString(5, produk.getKeterangan());
            pstmt.setBoolean(6, false);
            pstmt.setInt(7, produk.getIdProdukLokal());
            count = pstmt.executeUpdate();
        }

        return count;
    }

    public int updateDestinasi1(Wisata wisata) throws SQLException {
        int count = 0;
        DbConnection dbConn = new DbConnection();
        Connection conn = null;
        Statement st = null;
        PreparedStatement pstmt = null;
        InputStream inputStream = null;
        if (wisata.getGambar().getSize() > 0) {
            try {
                inputStream = wisata.getGambar().getInputStream();
            } catch (IOException ex) {
                Logger.getLogger(MenuAdminDesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(inputStream);
        String sql = null;
        conn = dbConn.getConnection();
        if (inputStream == null) {
            System.out.println("Dijalankan");
            sql = "update pariwisata set NamaTempat = '" + wisata.getNamaTempat() + "',"
                    + " Alamat ='" + wisata.getAlamat() + "',"
                    + "Keterangan ='" + wisata.getKeterangan() + "', Status = 0 where IdPariwisata ='" + wisata.getIdWisata() + "'";
            st = conn.createStatement();
            count = st.executeUpdate(sql);
        } else if (inputStream != null) {
            System.out.println("yang ini dijalankan");
            sql = "update pariwisata set NamaTempat = ? , Alamat = ? , GambarWisata = ?,Keterangan = ? , Status = ?"
                    + " where IdPariwisata = ?";
            try {
                conn = dbConn.getConnection();
                pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, wisata.getNamaTempat());
                pstmt.setString(2, wisata.getAlamat());
                if (inputStream != null) {
                    pstmt.setBlob(3, inputStream);
                }
                pstmt.setString(4, wisata.getKeterangan());
                pstmt.setBoolean(5, false);
                pstmt.setInt(6, wisata.getIdWisata());
                count = pstmt.executeUpdate();

            } catch (Exception e) {
                System.out.println(e);
            }

        }
        return count;
    }
}
