package pemilihanList;

import exceptions.namaKosong;
import menu.delete.deletePembeli;
import menu.delete.deleteProduk;
import models.logout;

import java.sql.SQLException;
import java.util.Scanner;

public class pemilihanDeletepembeli extends pemilihanDelete {
    public void deletePembelimilih() throws SQLException, namaKosong, InterruptedException {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.print("\nApakah anda ingin menghapus pembeli lagi? (delete/menu/logout) ");
        String menu = input.next();

        if(menu.equals("delete") || menu.equals("Delete")){
            deletePembeli baru = new deletePembeli();
            baru.pembeliDelete();

            deletePembelimilih();
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
            deletePembelimilih();
        }
    }
}
