package pemilihanList;

import exceptions.namaKosong;
import models.logout;

import java.sql.SQLException;
import java.util.Scanner;


public class pemilihan {
    public void pemilihanMenu() throws SQLException, namaKosong, InterruptedException {
        System.out.println("\nList Menu");
        System.out.println("1. Melihat Data");
        System.out.println("2. Menambah Data");
        System.out.println("3. Menghapus Data");
        System.out.println("4. Mengupdate Data");
        System.out.println("0. Logout");

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

        else if (Pilihan == 4){
            updateData update = new updateData();
            update.dataUpdate();

        } else if (Pilihan == 0) {
            logout log = new logout();
            log.keluar();
        }
    }
}
