package pemilihanList;

import exceptions.namaKosong;

import java.sql.SQLException;
import java.util.Scanner;


public class pemilihan {
    public void pemilihanMenu() throws SQLException, namaKosong {
        System.out.println("\nList Menu");
        System.out.println("1. Melihat Data");
        System.out.println("2. Menambah Data");
        System.out.println("3. Menghapus Data");

        System.out.print("\nPilih nomor yang diinginkan: ");
        Scanner input = new Scanner(System.in).useDelimiter("\n");

        int Pilihan = input.nextInt();

        // Melihat Nama pembeli
        if (Pilihan == 1){
            melihatData nama = new melihatData();
            nama.dataMelihat();
        }

        else if (Pilihan == 2){
            createData baru = new createData();
            baru.dataCreate();
        }

        else if (Pilihan == 3){
            pemilihanDelete delete = new pemilihanDelete();
            delete.deleteMilih();
        }
    }
}