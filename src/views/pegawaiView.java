package views;

public class pegawaiView {
    private String namaPeg;
    private String id;

    public void tambahPegawai(String newNamapeg){
        namaPeg = newNamapeg;
    }
    public String getNamaPeg(){
        return namaPeg;
    }
}
