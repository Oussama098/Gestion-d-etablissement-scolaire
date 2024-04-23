/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import javafx.collections.ObservableList;
import java.sql.*;
import javafx.collections.FXCollections;
import model.cycle;

/**
 *
 * @author oussa
 */
public class CycleController {
    public ObservableList<cycle> getAllCycles(){
        ObservableList <cycle> List = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("select * from cycle");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                List.add(new cycle(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            return List;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public cycle getcycleByCode(String Code){

        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("select * from cycle where code=?");
            ps.setString(1, Code);
            ResultSet rs= ps.executeQuery();
            cycle cycle = null;
            if(rs.next()){
                cycle= new cycle(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            return cycle;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public cycle getcycleByName(String name){

        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("select * from cycle where nom=?");
            ps.setString(1, name);
            ResultSet rs= ps.executeQuery();
            cycle cycle = null;
            if(rs.next()){
                cycle= new cycle(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            return cycle;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String []args){
        CycleController cycle = new CycleController();
        System.out.println(cycle.getAllCycles());
    }
}
