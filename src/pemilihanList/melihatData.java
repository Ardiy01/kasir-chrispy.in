package pemilihanList;

import exceptions.namaKosong;
import menu.melihat.melihatDataProduk;
import menu.melihat.melihatNamapegawai;
import menu.melihat.melihatNamapem;
import menu.melihat.melihaDataTransaksi;

import java.sql.SQLException;
import java.util.Scanner;

public class melihatData extends menuInput {
    public void dataMelihat() throws SQLException, InterruptedException, namaKosong {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.println("\nList Delete Data");
        System.out.println("1. Melihat Nama Pembeli");
        System.out.println("2. Melihat Nama Pegawai");
        System.out.println("3. Melihat Data Produk");
        System.out.println("4. Melihat Data Transaksi");
        System.out.println("\n0. Back");

        System.out.print("Pilih nomor yang diinginkan : ");
        int pilihan = input.nextInt();

        if(pilihan == 1){
            // nama pembeli
            melihatNamapem pembeli = new melihatNamapem();
            pembeli.melihatPembeli();
            menuInput pilihInput = new menuInput();
            pilihInput.inputMenu();
        }
        else if (pilihan == 2){
            // nama pegawai
            melihatNamapegawai pegawai = new melihatNamapegawai();
            pegawai.pegawaiNama();
            menuInput pilihInput = new menuInput();
            pilihInput.inputMenu();
        }
        else if (pilihan == 3){
            //melihat produk
            melihatDataProduk produk = new melihatDataProduk();
            produk.produkLihat();
            menuInput pilihInput = new menuInput();
            pilihInput.inputMenu();
        }
        else if (pilihan == 4){
            //melihat transaksi
            melihaDataTransaksi transaksi = new melihaDataTransaksi();
            transaksi.melihatTransaksi();
            menuInput pilihInput = new menuInput();
            pilihInput.inputMenu();
        }
        else if (pilihan == 0){
            pemilihan menu = new pemilihan();
            menu.pemilihanMenu();
        }
        else{
            System.out.println("\nSystem eror. Pilhan yang dipilih tidak tersedia. Silahkan memasukkan pilihan yang sesuai.");
            dataMelihat();
        }
    }
}
