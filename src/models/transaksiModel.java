package models;

import cotrollers.transaksiController;
import koneksi.Koneksi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class transaksiModel implements transaksiController {

    @Override
    public void lihatTransaksi() throws SQLException {
        try{
            Connection connection = Koneksi.getConn();
            String query = "select t.id_transaksi as id_transaksi, t.tanggal as tanggal, p.nama_pembeli as nama_pembeli, " +
                    "pr.nama_produk as nama_produk, t.jumlah_produk as jml_produk, dt.diskon as diskon, pr.harga as harga, " +
                    "(pr.harga * t.jumlah_produk - (pr.harga * t.jumlah_produk * (dt.diskon / 100))) as harga_total\n" +
                    "from detail_transaksi dt join transaksi t on dt.id_transaksi = t.id_transaksi\n" +
                    "join pembeli p on t.id_pembeli = p.id_pembeli\n" +
                    "join produk pr on pr.id_produk = dt.id_produk;";

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
}
