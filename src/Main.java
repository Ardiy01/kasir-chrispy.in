import models.pembeliModel;
import views.pembeliView;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
	// write your code here
//        Tambah Pembeli
        pembeliView pembeli = new pembeliView();
        Scanner input = new Scanner(System.in);
        System.out.print("Nama Pembeli: ");
        String namaPembeli = input.nextLine();
        pembeli.tambahPembeli(namaPembeli);
        pembeliModel pembeliModel = new pembeliModel();
        pembeliModel.tambahPembeli(pembeli.getNama());
//        end tambah pmbeli
    }
}
