package menu.melihat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class melihatNamapem {
    public void melihatPembeli(){
        Connection c = null;

        Statement stmt = null;

        try {

            Class.forName("org.postgresql.Driver");

            c = DriverManager.getConnection("jdbc:postgresql://localhost/chrispyin","postgres", "ayani123");

            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery( "select * from pembeli" );
            System.out.print("\nID Pembeli \t");
            System.out.println("Nama Pembeli");
            while ( rs.next() ) {
                int idPembeli = rs.getInt("id_pembeli");
                String  namaPembeli = rs.getString("nama_pembeli");

                System.out.printf("\t %s \t",idPembeli);
                System.out.printf( "\t %s",namaPembeli );

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
