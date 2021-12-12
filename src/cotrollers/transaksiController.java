package cotrollers;

import java.sql.SQLException;

public interface transaksiController {
    public void lihatTransaksi() throws SQLException;
    public void detailTransaksi(int idTransaksi) throws SQLException;
    public void hapusTransaksi(int idTransaksi) throws SQLException;
    public void tambahTransaksi(int idPegawai, int idPembeli, String keterangan) throws SQLException;
    public void tambahDetailTransaksi(int idProduk, int jmlProduk, float diskon) throws SQLException;
    public void detailPembeli() throws SQLException;
    public void detailPesanana() throws SQLException;
    public void subTotal() throws SQLException;
    public void kembalian(int bayar) throws SQLException;
}
