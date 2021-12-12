package menu.create;

import exceptions.namaKosong;
import models.transaksiModel;
import pemilihanList.pemilihan;

import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

public class createTransaksi extends transaksiModel{
    transaksiModel createTransaksi = new transaksiModel();
    private int idPegawai, idPembeli, idProduk,  jmlProduk;
    private String keterangan;
    private float diskon;

    public void setTransaksi(int newIdPegawai, int newIdPembeli, String newKeterangan){
        this.idPegawai = newIdPegawai;
        this.idPembeli = newIdPembeli;
        this.keterangan = newKeterangan;
    }
    

    public void setDetailTransaksi(int newIdProduk, int newJmlProduk, float newDiskon){
        this.idProduk = newIdProduk;
        this.jmlProduk = newJmlProduk;
        this.diskon = newDiskon;
    }

    public int getIdPegawai() {
        return idPegawai;
    }

    public int getIdPembeli() {
        return idPembeli;
    }

    public int getIdProduk() {
        return idProduk;
    }

    public float getDiskon() {
        return diskon;
    }

    public int getJmlProduk() {
        return jmlProduk;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setTransaksi() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan ID Pegawai: ");
        int idPegawai = input.nextInt();
        System.out.print("Masukan ID Pembeli: ");
        int idPembeli = input.nextInt();
        System.out.print("Keterangan: ");
        String keterangan = input.nextLine();
        input.nextLine();
        setTransaksi(idPegawai, idPembeli, keterangan);
    }

    public void setDetailTransaksi() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan ID Produk: ");
        int idProduk = input.nextInt();
        System.out.print("Masukan Jumlah Produk: ");
        int jmlProduk = input.nextInt();
        System.out.print("Masukan Diskon: ");
        float diskon = input.nextFloat();
        setDetailTransaksi(idProduk, jmlProduk, diskon);
    }

    public void struk() throws SQLException, namaKosong, InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\n");
        System.out.println("============== STRUK PEMBELIAN ==============");
        transaksiModel struk = new transaksiModel();
        struk.detailPembeli();
        System.out.println();
        struk.detailPesanana();
        System.out.println("\n============================================");
        struk.subTotal();
        System.out.print("Bayar\t\t: Rp. ");
        int bayar = input.nextInt();
        struk.kembalian(bayar);
    }


    public void craeteTransaksi() throws SQLException, namaKosong, InterruptedException {
        System.out.println("Tambah Pesanan\n");
        boolean tambahPesanan = true;
        String pesanan;
        Scanner input = new Scanner(System.in);
        setTransaksi();
        System.out.println();
        setDetailTransaksi();
        createTransaksi.tambahTransaksi(getIdPegawai(), getIdPembeli(), getKeterangan());
        createTransaksi.tambahDetailTransaksi(getIdProduk(), getJmlProduk(), getDiskon());

        while (tambahPesanan){
            System.out.print("Tambah Pesanan (Y/N): ");
            pesanan = input.nextLine();
            if (pesanan.equalsIgnoreCase("n")){
                break;
            }
            System.out.println();
            setDetailTransaksi();
            createTransaksi.tambahDetailTransaksi(getIdProduk(), getJmlProduk(), getDiskon());
        }
        struk();

    }
}
