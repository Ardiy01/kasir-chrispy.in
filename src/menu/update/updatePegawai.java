package menu.update;

import menu.melihat.melihatNamapegawai;
import models.pegawaiModel;

import java.sql.SQLException;
import java.util.Scanner;

public class updatePegawai extends pegawaiModel {
    pegawaiModel updatePegawai = new pegawaiModel();
    public void updateNamaPegawai() throws SQLException {
        Scanner input = new Scanner(System.in);
        melihatNamapegawai namaPegawai = new melihatNamapegawai();
        namaPegawai.pegawaiNama();
        System.out.print("\nMasukan ID Pegawai yang Ingin Dirubah: ");
        int idPegawai = input.nextInt();
        input.nextLine();
        System.out.print("\nNama Pegawai Baru: ");
        String newNamaPegawai = input.nextLine();

        if (newNamaPegawai.isEmpty()){
            System.out.println("Nama Pegawai Tidak Boleh Kosong");
        } else {
            updatePegawai.updatePegawai(idPegawai, newNamaPegawai);
        }
    }
}
