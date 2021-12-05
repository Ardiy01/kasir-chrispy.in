package cotrollers;

import java.sql.SQLException;

public interface pembeliController {
    public void tambahPembeli(String namaPembeli) throws SQLException;

    public void melihatPembeli(String lihatPembeli) throws SQLException;
}
