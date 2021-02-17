
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {
     private String jdbcURL = "jdbc:mysql://localhost:3306/rplProyek";
    private String user = "root";
    private String pass = "";
    private Connection connection = null;

    public DbConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, user, pass);
            System.out.println("Koneksi Berhasil");
        } catch (ClassNotFoundException ex) {
            System.out.println("Message : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Message : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean isConnected() {
        if (connection != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getClosed() {

        if (isConnected()) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        new DbConnection();
    }
}
