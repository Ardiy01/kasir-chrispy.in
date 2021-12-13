package menu.delete;

import menu.melihat.melihatDataProduk;
import models.produkModel;


import java.sql.SQLException;
import java.util.Scanner;

public class deleteProduk extends produkModel {
    produkModel deleteProduk = new produkModel();
    public void produkDelete() throws SQLException {
        melihatDataProduk lihatProduk = new melihatDataProduk();
        lihatProduk.produkLihat();
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan ID Produk yang ingin dihapus: ");
        int idProduk = input.nextInt();

        if (idProduk <= 0){
            System.out.println("ID Produk Salaha");
        } else{
            System.out.println("Nama Produk");
            deleteProduk.getProduk(idProduk);
            System.out.print(" Berhasil Dihapus\n");
            deleteProduk.deleteProduk(idProduk);
        }
    }
}
