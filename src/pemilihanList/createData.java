package pemilihanList;

import exceptions.namaKosong;
import menu.create.createPegawai;
import menu.create.createPembeli;
import menu.create.createProduk;
import menu.create.createTransaksi;

import java.sql.SQLException;
import java.util.Scanner;

public class createData {
    public void dataCreate() throws SQLException, namaKosong, InterruptedException {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.println("\nList Delete Data");
        System.out.println("1. Menambah Nama Pembeli");
        System.out.println("2. Menambah Nama Pegawai");
        System.out.println("3. Menambah Data Produk");
        System.out.println("4. Menambah Data Transaksi");
        System.out.println("\n0. Back");

        System.out.print("Pilih nomor yang diinginkan : ");
        int pilihan = input.nextInt();

        if(pilihan == 1){
            // nama pembeli
            System.out.println("\n\n");
            createPembeli pembeli = new createPembeli();
            pembeli.pembeliCreate();
            pemilihanPembeli baru = new pemilihanPembeli();
            baru.pembeliMilih();
        }
        else if (pilihan == 2){
            // nama pegawai
            System.out.println("\n\n");
            createPegawai pegawai = new createPegawai();
            pegawai.pegawaiCreate();
            pemiliihanPegawai baru = new pemiliihanPegawai();
            baru.pegawaiMemilih();
        }
        else if (pilihan == 3){
            //melihat produk
            System.out.println("\n\n");
            createProduk produk = new createProduk();
            produk.produkCreate();
            pemilihanProduk baru = new pemilihanProduk();
            baru.produkMilih();
        }
        else if (pilihan == 4){
//            create transaksi
            System.out.println("\n\n");
            createTransaksi transaksi = new createTransaksi();
            transaksi.craeteTransaksi();

            addTransaksi trans = new addTransaksi();
            trans.tambahTransaksi();
        }
        else if (pilihan == 0){
            pemilihan menu = new pemilihan();
            menu.pemilihanMenu();

        }
        else{
            System.out.println("\nSystem eror. Pilhan yang dipilih tidak tersedia. Silahkan memasukkan pilihan yang sesuai.");
            dataCreate();
        }
    }
}
