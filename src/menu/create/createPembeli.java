package menu.create;

import exceptions.namaKosong;
import models.pembeliModel;

import java.sql.*;
import java.util.Scanner;

public class createPembeli extends pembeliModel{
    private String namaPembeli;

    public void setNamaPembeli(String namaPembeli) {
        this.namaPembeli = namaPembeli;
    }

    public String getNamaPembeli() {
        return namaPembeli;
    }

    public void pembeliCreate() throws namaKosong, SQLException {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Nama Pembeli: ");
        String namaPembeli = input.next();

        if(namaPembeli.isEmpty()){
            throw new namaKosong();
        } else{
            setNamaPembeli(namaPembeli);
            tambahPembeli(getNamaPembeli());
        }
    }
}
