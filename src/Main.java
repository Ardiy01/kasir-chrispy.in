import exceptions.namaKosong;
import home.tampilanAwal;

import java.sql.*;

public class Main {
    public  static void main(String[] args) throws SQLException, namaKosong {
       tampilanAwal home = new tampilanAwal();
       home.halamanAwal();
    }
}
