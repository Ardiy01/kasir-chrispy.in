package models;

import controllers.pembeliController;
import views.pembeliView;

import java.sql.*;
import java.util.Scanner;

public class pembeliModel implements pembeliController{
    @Override
    public void tambahPembeli(String namaPembeli) throws SQLException {
        try{
            Connection conn = koneksi.koneksi.getConn();

            String query = "INSERT INTO pembeli " +
                            "(nama_pembeli) " +
                            "VALUES (?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1, namaPembeli);

            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void lihatPembeli() throws SQLException {

    }
}
