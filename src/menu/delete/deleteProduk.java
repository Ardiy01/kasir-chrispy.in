package menu.delete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class deleteProduk {
    public void produkDelete(){
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        try {
            Connection connection = koneksi.Koneksi.getConn();

            System.out.print("Masukkan ID Produk yang ingin dihapus: ");
            int idProduk = input.nextInt();
            String query = "DELETE FROM produk WHERE id_produk =" + idProduk+";";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();

            System.out.println("Delete Berhasil");
        } catch ( Exception e ) {

            System.err.println( e.getClass().getName()+": "+ e.getMessage() );

            System.exit(0);
        }
    }
}
