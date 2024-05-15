/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import javafx.collections.ObservableList;
import java.sql.*;
import javafx.collections.FXCollections;
import model.controle;
import model.matiere;
import model.module;

/**
 *
 * @author oussa
 */
public class ControleController {
    public ObservableList<controle> getAllExamsByTeacher(int id_enseignant){
        ObservableList<controle> items = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT DISTINCT\n" +
            "    `controle`.`ID_controle` AS `ControleId`,\n" +
            "    `controle`.`Nom` AS `ControleNom`,\n" +
            "    `controle`.`id_module` AS `ControleIdModule`,\n" +
            "    `controle`.`id_matiere` AS `ControleIdMatiere`,\n" +
            "    `controle`.`Duree` AS `ControleDuree`,\n" +
            "    `controle`.`id_classe` AS `ControleIdClasse`,\n" +
            "    `controle`.`id_enseignant` AS `ControleIdEnseignant`,\n" +
            "    `controle`.`etat` AS `ControleEtat`,\n" +
            "    `controle`.`observation` AS `ControleObservation`,\n" +
            "    `module`.`id_module` AS `ModuleID`,\n" +
            "    `module`.`Nom` AS `ModuleName`,\n" +
            "    `matiere`.`id_matiere` AS `MatiereID`,\n" +
            "    `matiere`.`id_module` AS `MatiereIdModule`,\n" +
            "    `matiere`.`Nom` AS `MatiereNom`\n" +
            "FROM\n" +
            "    controle\n" +
            "LEFT JOIN `notes` ON `notes`.`id_controle` = `controle`.`ID_controle`\n" +
            "LEFT JOIN `module` ON `controle`.`id_module` = `module`.`id_module`\n" +
            "LEFT JOIN `matiere` ON `controle`.`id_matiere` = `matiere`.`id_matiere`\n"+
            "WHERE `controle`.`id_enseignant`=?");
            ps.setInt(1, id_enseignant);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                items.add(new controle(rs.getInt("ControleId"), rs.getString("ControleNom"), new module(rs.getInt("ControleIdModule"), rs.getString("ModuleName")), new matiere(rs.getInt("ControleIdMatiere"),new module(rs.getInt("ControleIdModule"), rs.getString("ModuleName")) , rs.getString("MatiereNom")), rs.getInt("ControleDuree"), null, null, rs.getString("ControleEtat"), rs.getString("ControleObservation")));
            }
            return items;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
 
    public static void main(String [] args){
        ControleController ct = new ControleController();
        System.out.println(ct.getAllExamsByTeacher(1));
    }
}
