package views;

public class pembeliView {
    private String nama;
    private String id;

    public void tambahPembeli(String newNama){
        nama = newNama;
    }
    public String getNama(){
        return nama;
    }
}
