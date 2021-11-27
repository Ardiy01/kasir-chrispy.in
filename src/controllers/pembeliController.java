package controllers;

import views.pembeliView;

import java.sql.SQLException;

public interface pembeliController{
    public void tambahPembeli(String namaPembeli) throws SQLException;
    public void lihatPembeli() throws SQLException;
}
