package menu.delete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class deletePegawai {
    public void pegawaiDelete(){
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        try {
            Connection connection = koneksi.Koneksi.getConn();

            System.out.print("Masukkan ID Pegawai yang ingin dihapus: ");
            int idPegawai = input.nextInt();
            String query = "DELETE FROM pegawai WHERE id_pegawai =" + idPegawai+";";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();

            System.out.println("Delete Berhasil");
        } catch ( Exception e ) {

            System.err.println( e.getClass().getName()+": "+ e.getMessage() );

            System.exit(0);
        }
    }
}
