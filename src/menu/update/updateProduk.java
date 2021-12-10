package menu.update;

import menu.melihat.melihatDataProduk;
import models.produkModel;

import java.sql.SQLException;
import java.util.Scanner;

public class updateProduk {
    public void upProduk() throws SQLException {
        Scanner input = new Scanner(System.in);
        melihatDataProduk lihatProduk = new melihatDataProduk();
        lihatProduk.produkLihat();

        System.out.print("\nMasukan ID Produk Yang Ingin Dirubah: ");
        int idProduk = input.nextInt();
        input.nextLine();
        System.out.print("\nMasukan Nama Produk: ");
        String namaProduk = input.nextLine();
        System.out.print("\nMasukan Harga Produk: Rp. ");
        int harga = input.nextInt();
        input.nextLine();
        System.out.print("\nMasukan Keterangan: ");
        String keterangan = input.nextLine();

        if (namaProduk.isEmpty() || harga <= 0){
            System.out.println("Data TIdak Boleh Kosong");
        } else {
            produkModel upProduk = new produkModel();
            upProduk.updateProduk(idProduk, namaProduk, harga, keterangan);
        }
    }
}
