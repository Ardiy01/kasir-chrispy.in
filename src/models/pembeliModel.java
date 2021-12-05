package models;

import cotrollers.pembeliController;
import koneksi.Koneksi;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class pembeliModel implements pembeliController {
    @Override
    public void tambahPembeli(String namaPembeli) throws SQLException {
        try {
            Connection connection = Koneksi.getConn();

            String query = "INSERT INTO pembeli" +
                    "(nama_pembeli)" +
                    "VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, namaPembeli);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void melihatPembeli(String lihatPembeli) throws SQLException {

    }
}


