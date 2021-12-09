package cotrollers;

import java.sql.SQLException;

public interface pembeliController {
    public void tambahPembeli(String namaPembeli) throws SQLException;
    public void melihatPembeli() throws SQLException;
    public void deletePembeli(int idPembeli) throws SQLException;
    public  void getDataPembeli(int idPembeli) throws SQLException;
}
