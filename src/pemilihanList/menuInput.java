package pemilihanList;

import exceptions.namaKosong;
import models.logout;

import java.sql.SQLException;
import java.util.Scanner;

public class menuInput {
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    public void inputMenu() throws SQLException, namaKosong, InterruptedException {
        System.out.print("\n Apakah anda ingin memilih menu lagi? (y/n) ");
        String menu = input.next();
        if(menu.equals("y") || menu.equals("Y")){
            pemilihan pilih = new pemilihan();
            pilih.pemilihanMenu();
        }
        else if (menu.equals("n") || menu.equals("N")){
            logout pergi = new logout();
            pergi.keluar();
        }
        else{
            System.out.println("\nSystem eror. Pilhan yang dipilih tidak tersedia. Silahkan memasukkan pilihan yang sesuai.");
            inputMenu();
        }
    }
}
