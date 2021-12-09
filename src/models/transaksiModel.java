package models;

import cotrollers.transaksiController;
import koneksi.Koneksi;
import menu.create.createTransaksi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class transaksiModel implements transaksiController {

    @Override
    public void lihatTransaksi() throws SQLException {
        try{
            Connection connection = Koneksi.getConn();
            String query = "select t.id_transaksi as id_transaksi, TO_CHAR(t.tanggal::DATE, 'dd-mm-yyyy') as tanggal, " +
                    "p.nama_pembeli as nama_pembeli, pr.nama_produk as nama_produk, dt.jumlah_produk as jml_produk, " +
                    "dt.diskon as diskon, pr.harga as harga, (pr.harga * dt.jumlah_produk - (pr.harga * dt.jumlah_produk * " +
                    "(dt.diskon / 100))) as harga_total\n from detail_transaksi dt join transaksi t on dt.id_transaksi = " +
                    "t.id_transaksi join pembeli p on t.id_pembeli = p.id_pembeli join produk pr on " +
                    "pr.id_produk = dt.id_produk;";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int idTransaksi = rs.getInt("id_transaksi");
                String tanggal = rs.getString("tanggal");
                String namaPembeli = rs.getString("nama_pembeli");
                String namaProduk = rs.getString("nama_produk");
                int jumlahProduk = rs.getInt("jml_produk");
                float diskon = rs.getFloat("diskon");
                int harga = rs.getInt("harga");
                int hargaTotal = rs.getInt("harga_total");

                System.out.print("\t" + idTransaksi + "\t\t\t\t" + tanggal + "\t\t\t");
                System.out.print(namaPembeli + "\t\t\t" + namaProduk + "\t\t\t\t" + jumlahProduk );
                System.out.print("\t\t\t" + "Rp. " + harga + "\t  "  +  "Rp. " + hargaTotal + "\t\t  " + diskon +"%" + "\n");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void detailTransaksi(int idTransaksi) throws SQLException {
        try{
            Connection connection = Koneksi.getConn();
            String query = "DELETE FROM detail_transaksi WHERE id_transaksi = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idTransaksi);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void hapusTransaksi(int idTransaksi) throws SQLException {
        try{
            Connection connection = Koneksi.getConn();
            String query = "DELETE FROM transaksi WHERE id_transaksi = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idTransaksi);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void tambahTransaksi(int idPegawai, int idPembeli, String keterangan) throws SQLException {
        try{
            Connection connection = Koneksi.getConn();
            String query = "INSERT INTO transaksi(tanggal, id_pegawai, id_pembeli, keterangan)" +
                    "VALUES (now(), ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idPegawai);
            preparedStatement.setInt(2, idPembeli);
            preparedStatement.setString(3, keterangan);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getIdTransaksi() throws SQLException, InterruptedException {
        try {
            createTransaksi idTransaksi = new createTransaksi();
            Connection connection = Koneksi.getConn();
            String query = "SELECT COUNT(*) as id_transaksi FROM transaksi";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int count = rs.getInt("id_transaksi");
                idTransaksi.setIdTransaksi(count);
                System.out.println(count);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void tambahDetailTransaksi(int idTransaksi, int idProduk, int jmlProduk, float diskon) throws SQLException {
        try{
            Connection connection = Koneksi.getConn();
            String query = "INSERT INTO detail_transaksi(id_transaksi, id_produk, jumlah_produk, diskon)" +
                    "VALUES ?, ?, ?, ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idTransaksi);
            preparedStatement.setInt(2, idProduk);
            preparedStatement.setInt(3, jmlProduk);
            preparedStatement.setFloat(4, diskon);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

}
