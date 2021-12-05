package cotrollers;

import java.sql.SQLException;

public interface produkController {
    public void tambahProduk(String namaProduk, int harga, String keterangan) throws SQLException;
}
