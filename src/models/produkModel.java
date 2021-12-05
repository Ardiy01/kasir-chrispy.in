package models;

import cotrollers.produkController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class produkModel implements produkController {
    @Override
    public void tambahProduk(String namaProduk, int harga, String keterangan) throws SQLException {
        try {
            Connection connection = koneksi.Koneksi.getConn();

            String query = "INSERT INTO produk" +
                    "(nama_produk, harga, keterangan)" +
                    "VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, namaProduk);
            preparedStatement.setInt(2, harga);
            preparedStatement.setString(3, keterangan);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
