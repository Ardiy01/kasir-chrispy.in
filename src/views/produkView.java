package views;

public class produkView {
    private String namaProduk;
    private int harga;
    private String keterangan;
    private String id;

    public void tambahProduk(String newNamaproduk, int newHarga, String newKeterangan){
        namaProduk = newNamaproduk;
        harga = newHarga;
        keterangan = newKeterangan;
    }
    public String getNamaProduk(){
        return namaProduk;
    }
    public int getHarga(){
        return harga;
    }
    public String getKeterangan(){
        return keterangan;
    }

}
