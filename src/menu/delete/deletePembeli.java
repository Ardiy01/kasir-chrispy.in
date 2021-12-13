package menu.delete;

import models.pembeliModel;
import menu.melihat.melihatNamapem;
import java.sql.SQLException;
import java.util.Scanner;

public class deletePembeli extends pembeliModel {
    pembeliModel deletePembeli = new pembeliModel();
    public void pembeliDelete() throws SQLException {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        melihatNamapem lihatPembeli = new melihatNamapem();
        lihatPembeli.melihatPembeli();
        System.out.print("Masukkan ID Pembeli yang ingin dihapus: ");
        int idPembeli = input.nextInt();

        if (idPembeli <= 0){
            System.out.println("ID Pembeli Salah");
        } else {
            System.out.print("\nNama Pembeli");
            deletePembeli.getDataPembeli(idPembeli);
            System.out.print(" Berhasil Dihapus\n");
            deletePembeli.deletePembeli(idPembeli);
        }
    }
}
