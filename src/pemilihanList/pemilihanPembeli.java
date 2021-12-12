package pemilihanList;

import exceptions.namaKosong;
import menu.create.createPembeli;
import models.logout;

import java.sql.SQLException;
import java.util.Scanner;

public class pemilihanPembeli {
    public void pembeliMilih() throws SQLException, namaKosong, InterruptedException {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.print("\nApakah anda ingin menambahkan pembeli lagi? (tambah/menu/logout) ");
        String menu = input.next();

        if(menu.equals("tambah") || menu.equals("Tambah")){
            createPembeli baru = new createPembeli();
            baru.pembeliCreate();

            pembeliMilih();
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
            pembeliMilih();
        }
    }
}
