import exceptions.namaKosong;
import models.pegawaiModel;
import models.pembeliModel;
import models.produkModel;
import views.pegawaiView;
import views.pembeliView;
import views.produkView;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public  static void main(String[] args) throws SQLException, namaKosong {
        System.out.println("=============List Menu=============");
        System.out.println("\t 1. Melihat Nama Pembeli");
        System.out.println("\t 2. Nambah Nama Pembeli");
        System.out.println("\t 3. Melihat Nama Pegawai");
        System.out.println("\t 4. Nambah Nama Pegawai");
        System.out.println("\t 5. Melihat Data Produk");
        System.out.println("\t 6. Nambah Data Produk");
        System.out.println("\t 7. Menghapus Data Produk");

        System.out.print("Pilih nomor yang diinginkan: ");
        Scanner input = new Scanner(System.in).useDelimiter("\n");

        int Pilihan = input.nextInt();

        // Melihat Nama pembeli
        if (Pilihan == 1){
            Connection c = null;

            Statement stmt = null;

            try {

                Class.forName("org.postgresql.Driver");

                c = DriverManager.getConnection("jdbc:postgresql://localhost/chrispyin","postgres", "ayani123");

                stmt = c.createStatement();

                ResultSet rs = stmt.executeQuery( "select * from pembeli" );
                System.out.print("ID Pembeli \t");
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

        //Menambah Nama pembeli
        else if (Pilihan==2){
            pembeliView pembeli = new pembeliView();
            System.out.print("Nama Pembeli: ");
            String namaPembeli = input.next();

            if(namaPembeli.isEmpty()){
                throw new namaKosong();
            }
            else{
                pembeli.tambahPembeli(namaPembeli);
                pembeliModel pembelimodel = new pembeliModel();
                pembelimodel.tambahPembeli(pembeli.getNama());
            }
        }

        //Melihat Nama Pegawai
        else if (Pilihan == 3){
            Connection c = null;

            Statement stmt = null;

            try {

                Class.forName("org.postgresql.Driver");

                c = DriverManager.getConnection("jdbc:postgresql://localhost/chrispyin","postgres", "ayani123");

                stmt = c.createStatement();

                ResultSet rs = stmt.executeQuery( "select * from pegawai" );
                System.out.print("ID Pegawai \t");
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

        //Menambah nama pegawai
        else if (Pilihan == 4){
            pegawaiView pegawai = new pegawaiView();
            System.out.print("Nama Pegawai: ");
            String namaPegawai = input.next();

            if(namaPegawai.isEmpty()){
                throw new namaKosong();
            }
            else{
                pegawai.tambahPegawai(namaPegawai);
                pegawaiModel pegawaimodel = new pegawaiModel();
                pegawaimodel.tambahPegawai(pegawai.getNamaPeg());
            }
        }

        //Melihat produk
        else if (Pilihan == 5){
            Connection c = null;

            Statement stmt = null;

            try {

                Class.forName("org.postgresql.Driver");

                c = DriverManager.getConnection("jdbc:postgresql://localhost/chrispyin","postgres", "ayani123");

                stmt = c.createStatement();

                ResultSet rs = stmt.executeQuery( "select * from produk" );
                System.out.print("ID Produk \t");
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

        //Menambah data produk
        else if (Pilihan == 6){
            produkView produk = new produkView();
            System.out.print("Nama Produk: ");
            String namaProduk = input.next();
            System.out.print("Harga Produk: ");
            int harga = input.nextInt();
            System.out.print("Keterangan Produk: ");
            String keterangan = input.next();


            produk.tambahProduk(namaProduk, harga, keterangan);

            produkModel produkmodel = new produkModel();
            produkmodel.tambahProduk(produk.getNamaProduk(), produk.getHarga(), produk.getKeterangan());
        }

        //Menghapus data produk menggunakan id produk
        else if (Pilihan == 7){
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
}
