package menu.melihat;

import models.produkModel;

import java.sql.SQLException;

public class melihatDataProduk extends produkModel{
    produkModel lihatProduk = new produkModel();
    public void produkLihat() throws SQLException {
        System.out.print("ID Produk \t    Nama Produk \t\t Harga \t\t\t Keterangan\n");
        lihatProduk.melihatProduk();
    }
}
