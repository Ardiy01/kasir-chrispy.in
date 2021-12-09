package models;

import cotrollers.pegawaiController;
import koneksi.Koneksi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pegawaiModel implements pegawaiController {
    @Override
    public void tambahPegawai(String namaPegawai) throws SQLException {
        try {
            Connection connection = Koneksi.getConn();

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

    @Override
    public void melihatPegawai() throws SQLException {
        try{
            Connection connection = Koneksi.getConn();
            String query = "SELECT * FROM pegawai";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int idPegawai = rs.getInt("id_pegawai");
                String namaPegawai = rs.getString("nama_pegawai");

                System.out.print("\t" + idPegawai + "\t\t\t\t" + namaPegawai);
                System.out.println();
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void hapusPegawai(int idPegawai) throws SQLException {
        try{
            Connection connection = Koneksi.getConn();
            String query = "DELETE FROM pegawai WHERE id_pegawai = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idPegawai);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getDataPegawai(int idPegawai) throws SQLException {
        try{
            Connection connection = Koneksi.getConn();
            String query = "SELECT nama_pegawai FROM pegawai WHERE id_pegawai = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idPegawai);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String namaPegawai = rs.getString("nama_pegawai");
                System.out.print(namaPegawai);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
