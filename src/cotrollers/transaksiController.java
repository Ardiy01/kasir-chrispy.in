package cotrollers;

import java.sql.SQLException;

public interface transaksiController {
    public void lihatTransaksi() throws SQLException;
    public void detailTransaksi(int idTransaksi) throws SQLException;
    public void hapusTransaksi(int idTransaksi) throws SQLException;
    public void tambahTransaksi(int idPegawai, int idPembeli, String keterangan) throws SQLException;
    public void getIdTransaksi() throws SQLException, InterruptedException;
    public void tambahDetailTransaksi(int idTransaksi, int idProduk, int jmlProduk, float diskon) throws SQLException;
}
