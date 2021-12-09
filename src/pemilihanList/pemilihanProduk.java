package pemilihanList;

import exceptions.namaKosong;
import menu.create.createProduk;
import models.logout;

import java.sql.SQLException;
import java.util.Scanner;

public class pemilihanProduk {
    public void produkMilih() throws SQLException, namaKosong {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.print("\nApakah anda ingin menambahkan nama pembeli lagi? (tambah/menu/logout) ");
        String menu = input.next();

        if(menu.equals("tambah") || menu.equals("Tambah")){
            createProduk baru = new createProduk();
            baru.produkCreate();

            produkMilih();
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
            produkMilih();
        }
    }
}
