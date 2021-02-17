package Controller;

import classModel.AdminDesa;
import classModel.Member;
import classModel.adminSatuLangkah;
import classModel.daftarAkun;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import koneksi.DbConnection;

public class Akun {

    public int memberBaru(Member member) {
        DbConnection dbConn = new DbConnection();
        int count = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = dbConn.getConnection();
        String sql = "insert into pengunjungmember (Username,Password,Email,Alamat,Nohp) "
                + "values (?,?,?,?,?)";
        try {
            DbConnection dbCon = new DbConnection();
            conn = dbCon.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, member.getUsername());
            pstmt.setString(2, member.getPass());
            pstmt.setString(3, member.getEmail());
            pstmt.setString(4, member.getAlamat());
            pstmt.setString(5, member.getNoHp());
            count = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Akun.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Akun.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return count;
    }

    public int AdminDesaBaru(AdminDesa admin) {
        DbConnection dbConn = new DbConnection();
        int count = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = dbConn.getConnection();
        String sql = "insert into admindesa (Username,Password,Email, namaDesa,Alamat,Nohp) "
                + "values (?,?,?,?,?,?)";
        try {
            DbConnection dbCon = new DbConnection();
            conn = dbCon.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, admin.getUsername());
            pstmt.setString(2, admin.getPass());
            pstmt.setString(3, admin.getEmail());
            pstmt.setString(4, admin.getNamaDesa());
            pstmt.setString(5, admin.getAlamat());
            pstmt.setString(6, admin.getNoHp());
            count = pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Akun.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Akun.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return count;
    }

    public Member loginMember(String email, String pass) {
        DbConnection dbConn = new DbConnection();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Member member = null;
        String query = "SELECT *  FROM pengunjungmember where Email ='" + email + "' and Password='" + pass + "'";
        try {
            conn = dbConn.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                member = new Member();
                member.setIdUser(rs.getInt(1));
                member.setUsername(rs.getString(2));
                member.setPass(rs.getString(3));
                member.setEmail(rs.getString(4));
                member.setNoHp(rs.getString(5));
                member.setAlamat(rs.getString(6));
            }
        } catch (SQLException ex) {
            System.out.println("Message : " + ex.getMessage());
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Message : " + ex.getMessage());
            }
        }
        return member;
    }

    public AdminDesa loginAdmin(String email, String pass) {
        DbConnection dbConn = new DbConnection();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        AdminDesa adminDesa = null;
        try {
            String query = "SELECT *  FROM admindesa where Email ='" + email + "' and Password='" + pass + "'";
            conn = dbConn.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(query);

            if (rs.next()) {
                adminDesa = new AdminDesa();
                adminDesa.setIdDesa(rs.getInt(1));
                adminDesa.setUsername(rs.getString(2));
                adminDesa.setPass(rs.getString(3));
                adminDesa.setEmail(rs.getString(4));
                adminDesa.setNamaDesa(rs.getString(5));
                adminDesa.setAlamat(rs.getString(6));
                adminDesa.setNoHp(rs.getString(7));
            }
        } catch (SQLException ex) {
            System.out.println("Message : " + ex.getMessage());
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Message : " + ex.getMessage());
            }
        }
        return adminDesa;
    }

    public adminSatuLangkah loginAdminSatu(String email, String pass) {
        DbConnection dbConn = new DbConnection();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        adminSatuLangkah admin = null;
        try {
            String query = "SELECT *  FROM adminsatulangkah where Email ='" + email + "' and Password='" + pass + "'";
            conn = dbConn.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                admin = new adminSatuLangkah();
                admin.setIdAdmin(rs.getInt(1));
                admin.setNamaAdmin(rs.getString(2));
                admin.setAlamat(rs.getString(3));
                admin.setUsername(rs.getString(4));
                admin.setPass(rs.getString(5));
                admin.setEmail(rs.getString(6));
                admin.setNoHp(rs.getString(7));
            }
        } catch (SQLException ex) {
            System.out.println("Message : " + ex.getMessage());
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Message : " + ex.getMessage());
            }
        }
        return admin;
    }

    public Member DataMember(int id) {
        DbConnection dbConn = new DbConnection();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Member member = null;
        String query = "SELECT *  FROM pengunjungmember where IdUser = '" + id + "'";
        try {
            conn = dbConn.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                System.out.println("Ada data");
                member = new Member();
                member.setIdUser(rs.getInt(1));
                member.setUsername(rs.getString(2));
                member.setPass(rs.getString(3));
                member.setEmail(rs.getString(4));
                member.setNoHp(rs.getString(5));
                member.setAlamat(rs.getString(6));
            }
        } catch (SQLException ex) {
            System.out.println("Message : " + ex.getMessage());
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Message : " + ex.getMessage());
            }
        }
        return member;
    }

    public int updateProfile(Member member) {
        int count = 0;
        Connection conn = null;
        Statement st = null;
        DbConnection dbConn = new DbConnection();
        conn = dbConn.getConnection();
        String sql = "update pengunjungmember set Username='" + member.getUsername() + "'"
                + ",Password='" + member.getPass() + "',Email='" + member.getEmail() + "',Nohp='" + member.getNoHp() + "',"
                + "Alamat='" + member.getAlamat() + "'"
                + " where IdUser='" + member.getIdUser() + "'";
        try {
            st = conn.createStatement();
            count = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Akun.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Akun.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return count;
    }

    public AdminDesa DataAdmin(int id) {
        DbConnection dbConn = new DbConnection();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        AdminDesa adminDesa = null;
        try {
            String query = "SELECT *  FROM admindesa where IdDesa = '" + id + "'";
            conn = dbConn.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(query);

            if (rs.next()) {
                adminDesa = new AdminDesa();
                adminDesa.setIdDesa(rs.getInt(1));
                adminDesa.setUsername(rs.getString(2));
                adminDesa.setPass(rs.getString(3));
                adminDesa.setEmail(rs.getString(4));
                adminDesa.setNamaDesa(rs.getString(5));
                adminDesa.setAlamat(rs.getString(6));
                adminDesa.setNoHp(rs.getString(7));
            }
        } catch (SQLException ex) {
            System.out.println("Message : " + ex.getMessage());
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Message : " + ex.getMessage());
            }
        }
        return adminDesa;
    }

    public int updateProfile(AdminDesa adminDesa) {
        int count = 0;
        Connection conn = null;
        Statement st = null;
        DbConnection dbConn = new DbConnection();
        conn = dbConn.getConnection();
        String sql = "update admindesa set Username='" + adminDesa.getUsername() + "'"
                + ",Password='" + adminDesa.getPass() + "',Email='" + adminDesa.getEmail() + "',NamaDesa='" + adminDesa.getNamaDesa() + "',"
                + "Alamat='" + adminDesa.getAlamat() + "',NoHp='" + adminDesa.getNoHp() + "'"
                + " where IdDesa='" + adminDesa.getIdDesa() + "'";
        try {
            st = conn.createStatement();
            count = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Akun.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Akun.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return count;
    }
}
