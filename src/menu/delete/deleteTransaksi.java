package menu.delete;

import models.transaksiModel;
import menu.melihat.melihaDataTransaksi;

import java.sql.SQLException;
import java.util.Scanner;

public class deleteTransaksi extends transaksiModel {
    transaksiModel deleteTransaksi = new transaksiModel();
    public void deleteTransaksi() throws SQLException {
        melihaDataTransaksi lihatTransaksi = new melihaDataTransaksi();
        lihatTransaksi.melihatTransaksi();
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan ID Transaksi yang Dihapus: ");
        int idTransaksi = input.nextInt();

        if (idTransaksi <= 0){
            System.out.println("Id Transaksi Salah");
        } else{
            deleteTransaksi.detailTransaksi(idTransaksi);
            deleteTransaksi.hapusTransaksi(idTransaksi);
            System.out.println("Data Transaksi Berhasil Dihapus");
        }

    }
}
