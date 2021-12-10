package models;

import cotrollers.produkController;
import koneksi.Koneksi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class produkModel implements produkController {
    @Override
    public void tambahProduk(String namaProduk, int harga, String keterangan) throws SQLException {
        try {
            Connection connection = Koneksi.getConn();

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

    @Override
    public void melihatProduk() throws SQLException {
        try{
            Connection connection = Koneksi.getConn();

            String query = "SELECT * FROM produk";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int idProduk = rs.getInt("id_produk");
                String namaProduk = rs.getString("nama_produk");
                int hargaProduk = rs.getInt("harga");
                String keterangan = rs.getString("keterangan");

                System.out.print("\t" + idProduk + "\t\t\t" + namaProduk + "\t\t\t");
                System.out.print("Rp. "+hargaProduk + "\t\t" + keterangan + "\n");

            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteProduk(int idProduk) throws SQLException {
        try{
            Connection connection = Koneksi.getConn();
            String query = "DELETE FROM produk WHERE id_produk = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idProduk);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void getProduk(int idProduk) throws SQLException {
        try{
            Connection connection = Koneksi.getConn();
            String query = "SELECT nama_produk FROM produk WHERE id_produk = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idProduk);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String namaProduk = rs.getString("nama_produk");
                System.out.print(namaProduk);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateProduk(int idProduk, String namaProduk, int harga, String keterangan) throws SQLException {
        try{
            Connection connection = Koneksi.getConn();
            String query = "UPDATE produk SET nama_produk = ?, harga = ?, keterangan = ? WHERE id_produk = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, namaProduk);
            preparedStatement.setInt(2, harga);
            preparedStatement.setString(3, keterangan);
            preparedStatement.setInt(4, idProduk);

            preparedStatement.executeUpdate();
            System.out.println("Data Produk Berhasil Di Update");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
