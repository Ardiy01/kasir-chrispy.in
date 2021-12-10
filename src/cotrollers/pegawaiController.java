package cotrollers;

import java.sql.SQLException;

public interface pegawaiController {
    public void tambahPegawai(String namaPegawai) throws SQLException;
    public void melihatPegawai() throws SQLException;
    public void hapusPegawai(int idPegawai) throws  SQLException;
    public void getDataPegawai(int idPegawai) throws SQLException;
    public void updatePegawai(int idPegawai, String namaPegawai) throws SQLException;
}
