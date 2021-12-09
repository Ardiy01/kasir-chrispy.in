package menu.create;

import exceptions.namaKosong;
import models.pegawaiModel;

import java.sql.SQLException;
import java.util.Scanner;

public class createPegawai {
    pegawaiModel addPegawai = new pegawaiModel();
    private String namaPegawai;

    public void setNamaPegawai(String namaPembeli) {
        this.namaPegawai = namaPembeli;
    }

    public String getNamaPegawai() {
        return namaPegawai;
    }

    public void pegawaiCreate() throws SQLException, namaKosong {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Nama Pegawai: ");
        String namaPegawai = input.next();

        if(namaPegawai.isEmpty()){
            throw new namaKosong();
        }
        else{
            setNamaPegawai(namaPegawai);

            addPegawai.tambahPegawai(getNamaPegawai());
        }
    }
}
