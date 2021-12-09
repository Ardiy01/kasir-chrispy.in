package menu.create;

import exceptions.namaKosong;
import models.pembeliModel;
import views.pembeliView;

import java.sql.*;
import java.util.Scanner;

public class createPembeli {
    public void pembeliCreate() throws namaKosong, SQLException {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
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
}
