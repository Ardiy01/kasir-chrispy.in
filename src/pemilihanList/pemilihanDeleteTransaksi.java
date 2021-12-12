package pemilihanList;

import exceptions.namaKosong;
import menu.delete.deletePembeli;
import menu.delete.deleteTransaksi;
import models.logout;

import java.sql.SQLException;
import java.util.Scanner;

public class pemilihanDeleteTransaksi {
    public void deleteTransaksi() throws SQLException, namaKosong, InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.print("\nApakah anda ingin menghapus transaksi lagi? (delete/menu/logout) ");
        String menu = input.next();

        if(menu.equals("delete") || menu.equals("Delete")){
            deleteTransaksi delete = new deleteTransaksi();
            delete.deleteTransaksi();

            deleteTransaksi();
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
            deleteTransaksi();
        }
    }
}
