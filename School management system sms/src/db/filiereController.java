/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import javafx.collections.ObservableList;
import java.sql.*;
import javafx.collections.FXCollections;
import model.filiere;
import model.niveau;

/**
 *
 * @author oussa
 */
public class filiereController {
    public ObservableList<filiere> getAllFiliere(){
        ObservableList <filiere> List = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("select * from filiere");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                List.add(new filiere(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            return List;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public filiere getFiliereByCode(String Code){

        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("select * from filiere where code=?");
            ps.setString(1, Code);
            ResultSet rs= ps.executeQuery();
            filiere filiere = null;
            if(rs.next()){
                filiere= new filiere(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            return filiere;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
