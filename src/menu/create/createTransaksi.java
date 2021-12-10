package menu.create;

import models.transaksiModel;

import java.sql.SQLException;
import java.util.Scanner;

public class createTransaksi extends transaksiModel{
    transaksiModel createTransaksi = new transaksiModel();
    private int idTransaksiP, idPegawai, idPembeli, idProduk,  jmlProduk;
    private String keterangan;
    private float diskon;

    public void setIdTransaksiP(int idTransaksi) {
        this.idTransaksiP = idTransaksi;
    }

    public int getIdTransaksiP() {
        return this.idTransaksiP;
    }

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


    public void craeteTransaksi() throws SQLException, InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan ID Pegawai: ");
        int idPegawai = input.nextInt();
        System.out.print("Masukan ID Pembeli: ");
        int idPembeli = input.nextInt();
        System.out.print("Masukan ID Produk: ");
        int idProduk = input.nextInt();
        System.out.print("Masukan Jumlah Produk: ");
        int jmlProduk = input.nextInt();
        System.out.print("Masukan Diskon: ");
        float diskon = input.nextFloat();
        input.nextLine();
        System.out.print("Keterangan: ");
        String keterangan = input.nextLine();
        setTransaksi(idPegawai, idPembeli, keterangan);
        setDetailTransaksi(idProduk, getJmlProduk(), getDiskon());

        if (keterangan.isEmpty()){
            System.out.println("Data Tidak Boleh Kosong");
        } else {
            createTransaksi.tambahTransaksi(getIdPegawai(), getIdPembeli(), getKeterangan());
//            createTransaksi.tambahDetailTransaksi(getIdTransaksi(), idProduk, jmlProduk, diskon);
            createTransaksi.getIdTransaksi();
            System.out.println(getIdTransaksiP());

            System.out.println("Data Transaksi Berhasil Ditambahkan");
        }

    }
}
