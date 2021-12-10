package menu.melihat;

import java.sql.*;
import models.pembeliModel;

public class melihatNamapem{
    pembeliModel lihatPembeli = new pembeliModel();
    public void melihatPembeli() throws SQLException {
        System.out.print("ID Pembeli \t\t Nama Pembeli");
        System.out.println();
        lihatPembeli.melihatPembeli();
    }
}
