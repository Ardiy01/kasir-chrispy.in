package models;

import cotrollers.pegawaiController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class pegawaiModel implements pegawaiController {
    @Override
    public void tambahPegawai(String namaPegawai) throws SQLException {
        try {
            Connection connection = koneksi.Koneksi.getConn();

            String query = "INSERT INTO pegawai" +
                    "(nama_pegawai)" +
                    "VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, namaPegawai);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
