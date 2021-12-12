package pemilihanList;

import exceptions.namaKosong;
import menu.create.createTransaksi;

import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

public class addTransaksi {
    public void tambahTransaksi() throws SQLException, namaKosong, InterruptedException {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.print("\nAda Transaksi Lagi ? (Y/N): ");
        String trans = input.next().toLowerCase(Locale.ROOT);
        if (trans.equals("y")) {
            System.out.println("\n\n");
            createTransaksi transaksi = new createTransaksi();
            transaksi.craeteTransaksi();
        } else if (trans.equals("n")) {
            input.nextLine();
            System.out.print("\nTekan Enter Untuk Kembali Ke Menu....");
            String enter = input.nextLine();
            if (enter.isEmpty()) {
                System.out.println("\n\n\n\n");
                pemilihan menu = new pemilihan();
                menu.pemilihanMenu();
            } else {
                System.out.println("\nSystem eror. Pilhan yang dipilih tidak tersedia. Silahkan memasukkan pilihan yang sesuai.");
                tambahTransaksi();
            }
        }
    }
}
