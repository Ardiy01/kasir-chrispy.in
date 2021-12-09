package menu.create;

import exceptions.namaKosong;
import models.pegawaiModel;
import views.pegawaiView;

import java.sql.SQLException;
import java.util.Scanner;

public class createPegawai {
    public void pegawaiCreate() throws SQLException, namaKosong {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        pegawaiView pegawai = new pegawaiView();
        System.out.print("Nama Pegawai: ");
        String namaPegawai = input.next();

        if(namaPegawai.isEmpty()){
            throw new namaKosong();
        }
        else{
            pegawai.tambahPegawai(namaPegawai);
            pegawaiModel pegawaimodel = new pegawaiModel();
            pegawaimodel.tambahPegawai(pegawai.getNamaPeg());
        }
    }
}
