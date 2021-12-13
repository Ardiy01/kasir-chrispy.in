import exceptions.namaKosong;
import home.tampilanAwal;

import java.sql.*;

public class Main extends tampilanAwal {
    public  static void main(String[] args) throws SQLException, namaKosong, InterruptedException {
       tampilanAwal home = new tampilanAwal();
       home.halamanAwal();
    }
}
