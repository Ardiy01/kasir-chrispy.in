package menu.delete;

import java.sql.SQLException;
import java.util.Scanner;
import menu.melihat.melihatNamapegawai;
import models.pegawaiModel;

public class deletePegawai{
    pegawaiModel deletePegawai = new pegawaiModel();
    public void pegawaiDelete() throws SQLException {
        Scanner input = new Scanner(System.in);
        melihatNamapegawai dataPegawai = new melihatNamapegawai();
        dataPegawai.pegawaiNama();
        System.out.print("Masukan ID Pegawai yang ingin dihapus: ");
        int idPegawai = input.nextInt();

        if (idPegawai <= 0){
            System.out.println("ID Pegawai Salah");
        } else{
            System.out.print("\nNama Pegawai ");
            deletePegawai.getDataPegawai(idPegawai);
            System.out.print(" Berhasil Dihapus\n");
            deletePegawai.hapusPegawai(idPegawai);
        }
   }
}
