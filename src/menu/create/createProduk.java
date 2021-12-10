package menu.create;

import models.produkModel;

import java.sql.SQLException;
import java.util.Scanner;

public class createProduk extends produkModel{
    produkModel addProduk = new produkModel();
    private String namaProduk;
    private int hargaProduk;
    private String keterangan;

    public void setProduk(String newNamaProduk, int newHargaProduk, String newKeterangan) {
        this.namaProduk = newNamaProduk;
        this.hargaProduk = newHargaProduk;
        this.keterangan = newKeterangan;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public int getHargaProduk() {
        return hargaProduk;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void produkCreate() throws SQLException {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Nama Produk: ");
        String namaProduk = input.next();
        System.out.print("Harga Produk: ");
        int harga = input.nextInt();
        System.out.print("Keterangan Produk: ");
        String keterangan = input.next();
        if (namaProduk.isEmpty() || harga <= 0 || keterangan.isEmpty()){
            System.out.println("Data Salah");
        } else{
            setProduk(namaProduk, harga, keterangan);
            addProduk.tambahProduk(getNamaProduk(), getHargaProduk(), getKeterangan());
        }
    }
}
