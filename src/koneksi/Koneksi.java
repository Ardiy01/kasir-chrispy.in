package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    public static Connection connection;

    public static Connection getConn() throws SQLException {
        if(connection == null){
            try {
                String url = "jdbc:postgresql://localhost/chrispyin";
                String username = "postgres";
                String password = "admin";
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e){
                System.out.println("Koneksi gagal");
            }
        }
        return connection;
    }
}
