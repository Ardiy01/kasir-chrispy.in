package menu.melihat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class melihatProduk {
    public void produkLihat(){
        Connection c = null;

        Statement stmt = null;

        try {

            Class.forName("org.postgresql.Driver");

            c = DriverManager.getConnection("jdbc:postgresql://localhost/chrispyin","postgres", "ayani123");

            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery( "select * from produk" );
            System.out.print("\nID Produk \t");
            System.out.print("Nama Produk \t");
            System.out.print("Harga \t");
            System.out.println("\t Keterangan");

            while ( rs.next() ) {
                int idProduk = rs.getInt("id_produk");
                String  namaProduk = rs.getString("nama_produk");
                int harga = rs.getInt("harga");
                String keterangan = rs.getString("keterangan");

                System.out.printf("\t %s \t", idProduk);
                System.out.printf( "\t %s \t", namaProduk);
                System.out.printf("\t %s \t", harga);
                System.out.printf("\t %s", keterangan);

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
