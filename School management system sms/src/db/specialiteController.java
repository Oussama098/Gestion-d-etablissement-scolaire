/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.specialite;

/**
 *
 * @author oussa
 */
public class specialiteController {
    public ObservableList<specialite> getAllSpecialite(){
        ObservableList speciality = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT * FROM `specialite`");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                speciality.add(new specialite(rs.getInt(1), rs.getString(2)));
            }
            return speciality;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public specialite getSpecialiteByName(String name){
        specialite speciality = null;
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT * FROM `specialite` where nom=?");
            ps.setString(1, name);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                speciality=new specialite(rs.getInt(1), rs.getString(2));
            }
            return speciality;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String [] args){
        specialiteController sp = new specialiteController();
        System.out.println(sp.getAllSpecialite());
    }
}
