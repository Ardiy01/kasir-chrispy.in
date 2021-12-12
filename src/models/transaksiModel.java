package models;

import cotrollers.transaksiController;
import koneksi.Koneksi;

import java.sql.*;

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
    public void tambahDetailTransaksi(int idProduk, int jmlProduk, float diskon) throws SQLException {
        try{
            Connection connection = Koneksi.getConn();
            String query = "INSERT INTO detail_transaksi(id_transaksi, id_produk, jumlah_produk, diskon)" +
                    "VALUES ((SELECT MAX(id_transaksi) FROM transaksi), ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idProduk);
            preparedStatement.setInt(2, jmlProduk);
            preparedStatement.setFloat(3, diskon);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void detailPembeli() throws SQLException {
        try {
            Connection connection = Koneksi.getConn();
            String query = "SELECT TO_CHAR(t.tanggal::DATE, 'dd-mm-yyyy') AS tanggal, p.nama_pembeli AS nama_pembeli " +
                    "FROM transaksi t JOIN pembeli p ON (t.id_pembeli = p.id_pembeli) " +
                    "WHERE t.id_transaksi = (SELECT MAX(id_transaksi) FROM transaksi)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String tanggal = rs.getString("tanggal");
                String namaPembeli = rs.getString("nama_pembeli");
                System.out.println("\nTanggal\t\t\t: " + tanggal);
                System.out.println("Nama Pembeli\t: " + namaPembeli);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void detailPesanana() throws SQLException {
        try {
            Connection connection = Koneksi.getConn();
            String query = "SELECT pr.nama_produk AS nama_produk, pr.harga AS harga, dt.jumlah_produk AS jumlah_produk, " +
                    "dt.diskon AS diskon FROM transaksi t join pembeli p ON t.id_pembeli = p.id_pembeli\n" +
                    "JOIN detail_transaksi dt ON t.id_transaksi = dt.id_transaksi\n" +
                    "JOIN produk pr ON dt.id_produk = pr.id_produk\n" +
                    "WHERE t.id_transaksi = (SELECT MAX(id_transaksi) FROM transaksi);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            int i = 0;
            while (rs.next()){
                String namaProduk = rs.getString("nama_produk");
                int harga = rs.getInt("harga");
                int jumlah_produk = rs.getInt("jumlah_produk");
                int diskon = rs.getInt("diskon");
                i++;
                System.out.println( i + ". " + namaProduk);
                System.out.println("\tHarga: Rp. " + harga + " X " + jumlah_produk + "\tDiskon: " + diskon);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void subTotal() throws SQLException {
        try {
            Connection connection = Koneksi.getConn();
            String query = "SELECT SUM((dt.jumlah_produk * p.harga - " +
                    "(dt.jumlah_produk * p.harga * (dt.diskon / 100)))) AS total " +
                    "FROM detail_transaksi dt LEFT JOIN produk p USING(id_produk)\n" +
                    "WHERE dt.id_transaksi = 1\n" +
                    "GROUP BY (dt.id_transaksi)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int totalBayar = rs.getInt("total");
                System.out.println("Total\t\t: Rp. " + totalBayar);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void kembalian(int bayar) throws SQLException {
        try{
            Connection connection = Koneksi.getConn();
            String query = "SELECT (? - SUM((dt.jumlah_produk * p.harga - " +
                    " (dt.jumlah_produk * p.harga * (dt.diskon / 100))))) AS kembalian " +
                    " FROM detail_transaksi dt LEFT JOIN produk p USING(id_produk)\n"+
                    " WHERE dt.id_transaksi = 1 \n" +
                    " GROUP BY (dt.id_transaksi)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bayar);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int kembalian = rs.getInt("kembalian");
                System.out.println("Kembalian\t: Rp. " + kembalian);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


}
