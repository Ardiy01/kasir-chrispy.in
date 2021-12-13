package pemilihanList;

import exceptions.namaKosong;
import menu.create.createProduk;
import menu.update.updatePegawai;
import menu.update.updateProduk;
import models.logout;

import java.sql.SQLException;
import java.util.Scanner;

public class pemilihanProduk extends createData {
    public void produkMilih() throws SQLException, namaKosong, InterruptedException {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.print("\nApakah anda ingin menambahkan produk lagi? (tambah/menu/update/logout) ");
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
        else if (menu.equals("update") || menu.equals("Update")){
            updateProduk produk = new updateProduk();
            produk.upProduk();
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
