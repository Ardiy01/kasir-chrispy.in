package models;

import exceptions.namaKosong;
import pemilihanList.menuInput;

import java.sql.SQLException;
import java.util.Scanner;

public class logout {
    public void keluar() throws SQLException, namaKosong {
        Scanner input = new Scanner(System.in);
        System.out.print("\nApakah anda yakin ingin menutup system? (y/n): ");
        String out = input.next();
        if (out.equals("y") || out.equals("Y")){
            System.out.println("\nSystem Telah Berhenti, Buka system untuk memulai dari awal.\n");
            System.exit(0);
        }
        else if (out.equals("n") || out.equals("N")){
            menuInput memilih = new menuInput();
            memilih.inputMenu();
        }
        else {
            System.out.println("System eror. Pilhan yang dipilih tidak tersedia. Silahkan memasukkan pilihan yang sesuai.");
            keluar();
        }
    }
}
