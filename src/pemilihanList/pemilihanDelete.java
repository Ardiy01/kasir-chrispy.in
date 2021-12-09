package pemilihanList;

import exceptions.namaKosong;
import menu.delete.deletePegawai;
import menu.delete.deletePembeli;
import menu.delete.deleteProduk;

import java.sql.SQLException;
import java.util.Scanner;

public class pemilihanDelete {
    public void deleteMilih() throws SQLException, namaKosong {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.println("\nList Delete Data");
        System.out.println("1. Delete Pembeli");
        System.out.println("2. Delete Pegawai");
        System.out.println("3. Delete Produk");
        System.out.println("\n0. Back");

        System.out.print("Pilih nomor yang diinginkan : ");
        int pilihan = input.nextInt();

        if(pilihan == 1){
            // delete pembeli
            deletePembeli delet = new deletePembeli();
            delet.pembeliDelete();

            pemilihanDeletepembeli baru = new pemilihanDeletepembeli();
            baru.deletePembelimilih();
        }
        else if (pilihan == 2){
            // delete pegawai
            deletePegawai delet = new deletePegawai();
            delet.pegawaiDelete();

            pemilihanDeletepegawai baru = new pemilihanDeletepegawai();
            baru.deletePegawaimilih();
        }
        else if (pilihan == 3){
            //delete produk
            deleteProduk delet = new deleteProduk();
            delet.produkDelete();

            pemilihanDeleteproduk baru = new pemilihanDeleteproduk();
            baru.deleteProdukmilih();
        }
        else if (pilihan == 0){
            pemilihan menu = new pemilihan();
            menu.pemilihanMenu();
        }
        else{
            System.out.println("\nSystem eror. Pilhan yang dipilih tidak tersedia. Silahkan memasukkan pilihan yang sesuai.");
            deleteMilih();
        }
    }
}
