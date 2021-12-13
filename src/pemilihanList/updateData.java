package pemilihanList;

import exceptions.namaKosong;
import menu.create.createPegawai;
import menu.create.createPembeli;
import menu.create.createProduk;
import menu.create.createTransaksi;
import menu.update.updatePegawai;
import menu.update.updateProduk;

import java.sql.SQLException;
import java.util.Scanner;

public class updateData extends updatePegawai {
    public void dataUpdate() throws SQLException, InterruptedException, namaKosong {
        Scanner input = new Scanner(System.in);
        System.out.println("\nList Update Data");
        System.out.println("1. Update Nama Pegawai");
        System.out.println("2. Update Data Produk");
        System.out.println("\n0. Back");

        System.out.print("Pilih nomor yang diinginkan : ");
        int pilihan = input.nextInt();

        if(pilihan == 1){
            // data pegawai
            updatePegawai upPegawai = new updatePegawai();
            upPegawai.updateNamaPegawai();
            pemiliihanPegawai update = new pemiliihanPegawai();
            update.pegawaiMemilih();
        }

        else if (pilihan == 2){
            // data produk
            updateProduk upProduk = new updateProduk();
            upProduk.upProduk();
            pemilihanProduk update = new pemilihanProduk();
            update.produkMilih();
        }
        else if (pilihan == 0){
            pemilihan menu = new pemilihan();
            menu.pemilihanMenu();
        }
        else{
            System.out.println("\nSystem eror. Pilhan yang dipilih tidak tersedia. Silahkan memasukkan pilihan yang sesuai.");
            dataUpdate();
        }
    }
}
