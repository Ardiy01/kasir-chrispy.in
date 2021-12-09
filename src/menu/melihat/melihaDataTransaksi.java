package menu.melihat;

import models.transaksiModel;


import java.sql.SQLException;

public class melihaDataTransaksi extends transaksiModel{

    transaksiModel lihatTransaksi = new transaksiModel();
    public void melihatTransaksi() throws SQLException {
        System.out.println("ID Transaksi \t\t Tanggal \t\t\t Nama Pembeli \t\t    Nama Produk \t Jumlah Produk \t Harga Produk \t Harga Total \t Diskon");
        lihatTransaksi.lihatTransaksi();
    }
}
