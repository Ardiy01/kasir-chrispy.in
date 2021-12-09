package menu.delete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class deletePembeli {
    public void pembeliDelete(){
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        try {
            Connection connection = koneksi.Koneksi.getConn();

            System.out.print("Masukkan ID Pembeli yang ingin dihapus: ");
            int idPembeli = input.nextInt();
            String query = "DELETE FROM pembeli WHERE id_pembeli =" + idPembeli+";";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();

            System.out.println("Delete Berhasil");
        } catch ( Exception e ) {

            System.err.println( e.getClass().getName()+": "+ e.getMessage() );

            System.exit(0);
        }
    }
}
