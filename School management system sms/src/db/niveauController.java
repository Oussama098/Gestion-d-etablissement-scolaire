/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.niveau;
import java.sql.*;

/**
 *
 * @author oussa
 */
public class niveauController {
    public ObservableList<niveau> getAllLevel(){
        ObservableList<niveau> List= FXCollections.observableArrayList();
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("select * from niveau");
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                List.add(new niveau(rs.getInt(1),rs.getString(3) , rs.getString(2)));
            }
            return List;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public niveau getNiveauByCode(String Code){

        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("select * from niveau where code=?");
            ps.setString(1, Code);
            ResultSet rs= ps.executeQuery();
            niveau niveau = null;
            if(rs.next()){
                niveau= new niveau(rs.getInt(1), rs.getString(3), rs.getString(2));
            }
            return niveau;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
