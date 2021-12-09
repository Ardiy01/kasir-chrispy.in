package menu.melihat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class melihatNamapegawai {
    public void pegawaiNama(){
        Connection c = null;

        Statement stmt = null;

        try {
             Class.forName("org.postgresql.Driver");

             c = DriverManager.getConnection("jdbc:postgresql://localhost/chrispyin","postgres", "ayani123");

             stmt = c.createStatement();

             ResultSet rs = stmt.executeQuery( "select * from pegawai" );
             System.out.print("\nID Pegawai \t");
             System.out.println("Nama Pegawai");
             while ( rs.next() ) {
                 int idPegawai = rs.getInt("id_pegawai");
                 String  namaPegawai = rs.getString("nama_pegawai");

                 System.out.printf("\t %s \t",idPegawai);
                 System.out.printf( "\t %s",namaPegawai );

                 System.out.println();

                }

             rs.close();

             stmt.close();

             c.close();

        } catch ( Exception e ) {

            System.err.println( e.getClass().getName()+": "+ e.getMessage() );

            System.exit(0);
        }
    }
}
