/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import javafx.collections.ObservableList;
import java.sql.*;
import javafx.collections.FXCollections;
import model.cycle;
import model.enseignant;
import model.specialite;
import model.user;

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
    
    public ObservableList<enseignant> getAllTeachersByCycle(String nom){
        ObservableList items = FXCollections.observableArrayList();
        try {
        PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT `enseignant`.`id_enseignant` AS `enseignantID`,"
                + " `enseignant`.`id_user` AS `enseignantUserID`, `enseignant`.`id_cycle` AS `enseignantCycleID`"
                + ", `enseignant`.`id_specialite` AS `enseignantSpecialiteID`"
                + ", `user`.`id_user` AS `userID`, `user`.`nom` AS `userNom`"
                + ", `user`.`prenom` AS `userPrenom`, `user`.`email` AS `userEmail`"
                + ", `user`.`role` AS `useRole`, `user`.`datenais` AS `userDateNais`"
                + ", `user`.`lieunais` AS `userLieuNais`, `user`.`Telephone` AS `userTele`"
                + ", `user`.`sexe` AS `userSexe`, `user`.`photo` AS `userPhoto`, `cycle`.`id_cycle` AS `cycleID`"
                + ", `cycle`.`code` AS `cycleCode`, `cycle`.`nom` AS `cycleNom`"
                + ", `specialite`.`id_specialite` AS `specialiteID`, `specialite`.`nom` AS `specialiteNom`\n" +
                "FROM `enseignant` \n" +
                "	LEFT JOIN `user` ON `enseignant`.`id_user` = `user`.`id_user` \n" +
                "	LEFT JOIN `cycle` ON `enseignant`.`id_cycle` = `cycle`.`id_cycle` \n" +
                "	LEFT JOIN `specialite` ON `enseignant`.`id_specialite` = `specialite`.`id_specialite`"
                + "where `cycle`.`nom`= ?;");
        ps.setString(1, nom);
        ResultSet rs= ps.executeQuery();
        while(rs.next()){
            items.add(new enseignant(rs.getInt("enseignantID"), new user(rs.getInt("userID"),rs.getString("userNom"), rs.getString("userPrenom"), rs.getString("userEmail"), rs.getString("userDateNais"),rs.getString("userLieuNais"),rs.getString("userTele"),rs.getString("userSexe"),rs.getString("userPhoto"),rs.getString("useRole")), new cycle(rs.getInt("cycleID"), rs.getString("cycleCode"), rs.getString("cycleNom")),new specialite(rs.getInt("specialiteID"), rs.getString("specialiteNom"))));
        }
        return items;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
        
    }
    
    public static void main(String []args){
        CycleController cycle = new CycleController();
        System.out.println(cycle.getAllTeachersByCycle("Maternelle"));
    }
}
