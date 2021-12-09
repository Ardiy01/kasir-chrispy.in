package home;

import exceptions.namaKosong;
import pemilihanList.pemilihan;

import java.sql.SQLException;
import java.util.Scanner;

public class tampilanAwal {
    public void halamanAwal() throws SQLException, namaKosong, InterruptedException {
        Scanner input = new Scanner(System.in).useDelimiter("\n");

        System.out.println("============ Chrispy.in ============");
        System.out.println("\t\t\tSystem Kasir");
        System.out.println("\t\t\tDibuat Oleh:");
        System.out.println("\n\t\tAyani\t202410101026");
        System.out.println("\tArdi Yuliantoro 202410101051");
        System.out.println("Azka Azka Muaffan Sutomo putra 202410101123");
        System.out.print("\nKlik ENTER 2x untuk melanjutkan... ");

        String pilih = input.next();

        if (pilih.isEmpty()){
            pemilihan menu = new pemilihan();
            menu.pemilihanMenu();
        }
        else{
            System.out.println("Eror");
            halamanAwal();
        }
    }
}
