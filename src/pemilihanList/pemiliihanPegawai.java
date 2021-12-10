package pemilihanList;

import exceptions.namaKosong;
import menu.create.createPegawai;
import menu.update.updatePegawai;
import models.logout;

import java.sql.SQLException;
import java.util.Scanner;

public class pemiliihanPegawai {
    public void pegawaiMemilih() throws SQLException, namaKosong, InterruptedException {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.print("\nApakah anda ingin menambahkan nama pembeli lagi? (tambah/menu/update/logout) ");
        String menu = input.next();

        if(menu.equals("tambah") || menu.equals("Tambah")){
            createPegawai baru = new createPegawai();
            baru.pegawaiCreate();

            pegawaiMemilih();
        }
        else if (menu.equals("menu") || menu.equals("Menu")){
            pemilihan pilihBaru = new pemilihan();
            pilihBaru.pemilihanMenu();
        }
        else if (menu.equals("update") || menu.equals("Menu")){
            updatePegawai pegawai = new updatePegawai();
            pegawai.updateNamaPegawai();
        }
        else if (menu.equals("logout") || menu.equals("Logout")){
            logout pergi = new logout();
            pergi.keluar();
        }
        else{
            System.out.println("\nSystem eror. Pilhan yang dipilih tidak tersedia. Silahkan memasukkan pilihan yang sesuai.");
            pegawaiMemilih();
        }
    }
}
