package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class koneksi {
    public static Connection conn;

    public static Connection getConn() throws SQLException {
        if(conn == null){
            try{
                String url = "jdbc:postgresql://localhost:5432/chrispyin";
                String username = "postgres";
                String password = "admin";
                conn = DriverManager.getConnection(url, username, password);
            } catch(Exception e){
                System.out.println("Koneksi Gagal: " + e);
            }
        }
        return conn;
    }
}
