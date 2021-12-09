package pemilihanList;

import exceptions.namaKosong;
import menu.delete.deletePegawai;
import menu.delete.deleteProduk;
import models.logout;

import java.sql.SQLException;
import java.util.Scanner;

public class pemilihanDeletepegawai {
    public void deletePegawaimilih() throws SQLException, namaKosong {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.print("\nApakah anda ingin menghapus pegawai lagi? (delete/menu/logout) ");
        String menu = input.next();

        if(menu.equals("delete") || menu.equals("Delete")){
            deletePegawai baru = new deletePegawai();
            baru.pegawaiDelete();

            deletePegawaimilih();
        }
        else if (menu.equals("menu") || menu.equals("Menu")){
            pemilihan pilihBaru = new pemilihan();
            pilihBaru.pemilihanMenu();
        }
        else if (menu.equals("logout") || menu.equals("Logout")){
            logout pergi = new logout();
            pergi.keluar();
        }
        else{
            System.out.println("\nSystem eror. Pilhan yang dipilih tidak tersedia. Silahkan memasukkan pilihan yang sesuai.");
            deletePegawaimilih();
        }
    }
}
