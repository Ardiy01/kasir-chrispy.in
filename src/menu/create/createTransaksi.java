package menu.create;

import models.transaksiModel;

import java.sql.SQLException;
import java.util.Scanner;

public class createTransaksi extends transaksiModel{
    transaksiModel createTransaksi = new transaksiModel();
    private int idTransaksi, idPegawai, idPembeli, jmlProduk;
    private String keterangan;
    private float diskon;

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getIdTransaksiP() {
        return idTransaksi;
    }

    public void setTransaksi(int newIdPegawai, int newIdPembeli, String newKeterangan){
        this.idPegawai = newIdPegawai;
        this.idPembeli = newIdPembeli;
        this.keterangan = newKeterangan;
    }

    public void setDetailTransaksi(int newJmlProduk, float newDiskon){
        this.jmlProduk = newJmlProduk;
        this.diskon = newDiskon;
    }

    public void craeteTransaksi() throws SQLException, InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan ID Pegawai: ");
        int idPegawai = input.nextInt();
        System.out.print("Masukan ID Pembeli: ");
        int idPembeli = input.nextInt();
        System.out.print("Masukan ID Produk: ");
        int idProduk = input.nextInt();
        System.out.print("Masukan Jumlah Produk: ");
        int jmlProduk = input.nextInt();
        System.out.print("Masukan Diskon: ");
        float diskon = input.nextFloat();
        input.nextLine();
        System.out.print("Keterangan: ");
        String keterangan = input.nextLine();


        if (keterangan.isEmpty()){
            System.out.println("Data Tidak Boleh Kosong");
        } else {
            createTransaksi.tambahTransaksi(idPegawai, idPembeli, keterangan);
//            createTransaksi.tambahDetailTransaksi(getIdTransaksi(), idProduk, jmlProduk, diskon);
            createTransaksi.getIdTransaksi();
            System.out.println(getIdTransaksiP());
            System.out.println("Data Transaksi Berhasil Ditambahkan");
        }

    }
}
