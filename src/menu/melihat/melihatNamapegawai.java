package menu.melihat;

import models.pegawaiModel;

import java.sql.SQLException;

public class melihatNamapegawai extends pegawaiModel{
    pegawaiModel lihatPegawai = new pegawaiModel();
    public void pegawaiNama() throws SQLException {
        System.out.print("ID Pegawai \t\t Nama Pegawai" );
        System.out.println();
        lihatPegawai.melihatPegawai();
    }
}
