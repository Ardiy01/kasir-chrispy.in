package models;

import cotrollers.pembeliController;
import koneksi.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pembeliModel extends Koneksi implements pembeliController {
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
    public void melihatPembeli() throws SQLException {
        try{
            Connection connection = Koneksi.getConn();

            String query = "SELECT * FROM pembeli";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int idPembeli = rs.getInt("id_pembeli");
                String namaPembeli = rs.getString("nama_pembeli");
                System.out.print("\t" + idPembeli + "\t\t\t" + namaPembeli);
                System.out.println();
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void deletePembeli(int idPembeli) throws SQLException {
        try{
            Connection connection = Koneksi.getConn();
            String query = "DELETE FROM pembeli WHERE id_pembeli = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idPembeli);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getDataPembeli(int idPembeli) throws SQLException {
        try{
            Connection connection = Koneksi.getConn();
            String query = "SELECT nama_pembeli FROM pembeli WHERE id_pembeli = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idPembeli);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                String namaPembeli = rs.getString("nama_pembeli");
                System.out.print(namaPembeli);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}


