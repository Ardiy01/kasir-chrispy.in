package menu.create;

import models.produkModel;
import views.produkView;

import java.sql.SQLException;
import java.util.Scanner;

public class createProduk {
    public void produkCreate() throws SQLException {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        produkView produk = new produkView();
        System.out.print("Nama Produk: ");
        String namaProduk = input.next();
        System.out.print("Harga Produk: ");
        int harga = input.nextInt();
        System.out.print("Keterangan Produk: ");
        String keterangan = input.next();

        produk.tambahProduk(namaProduk, harga, keterangan);

        produkModel produkmodel = new produkModel();
        produkmodel.tambahProduk(produk.getNamaProduk(), produk.getHarga(), produk.getKeterangan());
    }
}
