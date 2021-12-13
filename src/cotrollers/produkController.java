package cotrollers;

import java.sql.SQLException;

public interface produkController {
    public void tambahProduk(String namaProduk, int harga, String keterangan) throws SQLException;
    public void melihatProduk() throws SQLException;
    public void deleteProduk(int idProduk) throws SQLException;
    public void getProduk(int idProduk) throws SQLException;
    public void updateProduk(int idProduk, String namaProduk, int harga, String keterangan) throws SQLException;
    public void produkTransaksi() throws SQLException;
}
