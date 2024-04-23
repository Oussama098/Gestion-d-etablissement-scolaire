/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.classe;
import model.classegenerique;
import model.cycle;
import model.filiere;
import model.niveau;

/**
 *
 * @author oussa
 */
public class ClasseController {
    public int CountClasses(){
        int nbClasses =0;
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("select count(*) from classe");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                nbClasses = rs.getInt(1);
            }
            return nbClasses;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public ObservableList<classe> getAllClasses(){
        ObservableList<classe> Classes = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT\n" +
            "    `classe`.`id_classe` AS `classe_id`,\n" +
            "    `classe`.`id_classegenerique` AS `classe_id_classegenerique`,\n" +
            "    `classe`.`annee_scolaire` AS `classe_annee_scolaire`,\n" +
            "    `classegenerique`.`id_classegenerique` AS `classegenerique_id`,\n" +
            "    `classegenerique`.`id_niveau` AS `classegenerique_id_niveau`,\n" +
            "    `classegenerique`.`id_filiere` AS `classegenerique_id_filiere`,\n" +
            "    `classegenerique`.`id_cycle` AS `classegenerique_id_cycle`,\n" +
            "    `classegenerique`.`discription` AS `classegenerique_discription`,\n" +
            "    `niveau`.`id_niveau` AS `niveau_id`,\n" +
            "    `niveau`.`code` AS `niveau_code`,\n" +
            "    `niveau`.`nom` AS `niveau_nom`,\n" +
            "    `cycle`.`id_cycle` AS `cycle_id`,\n"+
            "    `cycle`.`code` AS `cycle_code`,\n" +
            "    `cycle`.`nom` AS `cycle_nom`,\n" +
            "    `filiere`.`id_filiere` AS `filiere_id`,\n" +
            "    `filiere`.`code` AS `filiere_code`,\n" +
            "    `filiere`.`nom` AS `filiere_nom`\n" +
            "FROM\n" +
            "    `classe`\n" +
            "LEFT JOIN `classegenerique` ON `classe`.`id_classegenerique` = `classegenerique`.`id_classegenerique`\n" +
            "LEFT JOIN `niveau` ON `classegenerique`.`id_niveau` = `niveau`.`id_niveau`\n" +
            "LEFT JOIN `cycle` ON `classegenerique`.`id_cycle` = `cycle`.`id_cycle`\n" +
            "LEFT JOIN `filiere` ON `classegenerique`.`id_filiere` = `filiere`.`id_filiere`;");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Classes.add(new classe(rs.getInt("classe_id"), new classegenerique(rs.getInt("classegenerique_id"), new niveau(rs.getInt("niveau_id"), rs.getString("niveau_nom"), rs.getString("niveau_code")), new filiere(rs.getInt("filiere_id"), rs.getString("filiere_code"), rs.getString("filiere_nom")), new cycle(rs.getInt("cycle_id"), rs.getString("cycle_code"), rs.getString("cycle_nom")), rs.getString("classegenerique_discription")), rs.getString("classe_annee_scolaire")));
            }
            return Classes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public classe getClassByCycleNiveauFiliere(int id_cycle , int id_niveau , int id_filiere){
        classe classe = new classe();
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT \n" +
"    `classe`.`id_classe` AS `classe_id`, \n" +
"    `classe`.`id_classegenerique` AS `classe_id_classegenerique`, \n" +
"    `classe`.`annee_scolaire` AS `classe_annee_scolaire`, \n" +
"    `classegenerique`.`id_classegenerique` AS `classegenerique_id`, \n" +
"    `classegenerique`.`id_niveau` AS `classegenerique_id_niveau`, \n" +
"    `classegenerique`.`id_filiere` AS `classegenerique_id_filiere`, \n" +
"    `filiere`.`id_filiere` AS `filiere_id`, \n" +
"    `filiere`.`code` AS `filiere_code`, \n" +
"    `filiere`.`nom` AS `filiere_nom`, \n" +
"    `niveau`.`id_niveau` AS `niveau_id`, \n" +
"    `niveau`.`code` AS `niveau_code`, \n" +
"    `niveau`.`nom` AS `niveau_nom`, \n" +
"    `cycle`.`id_cycle` AS `cycle_id`, \n" +
"    `cycle`.`code` AS `cycle_code`, \n" +
"    `cycle`.`nom` AS `cycle_nom`, \n" +
"    `classegenerique`.`id_cycle` AS `classegenerique_id_cycle`, \n" +
"    `classegenerique`.`discription` AS `classegenerique_discription`\n" +
"FROM \n" +
"    `classe` \n" +
"    LEFT JOIN `classegenerique` ON `classe`.`id_classegenerique` = `classegenerique`.`id_classegenerique`\n" +
"    LEFT JOIN `niveau` ON `niveau`.`id_niveau` = `classegenerique`.`id_niveau`\n" +
"    LEFT JOIN `filiere` ON `filiere`.`id_filiere` = `classegenerique`.`id_filiere`\n" +
"    LEFT JOIN `cycle` ON `cycle`.`id_cycle` = `classegenerique`.`id_cycle`\n" +
"WHERE \n" +
"    `niveau`.`id_niveau` = ? AND `filiere`.`id_filiere` = ? AND `cycle`.`id_cycle` = ?");
            ps.setInt(1, id_niveau);
            ps.setInt(2, id_filiere);
            ps.setInt(3, id_cycle);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                classe = new classe(rs.getInt("classe_id"),
               new classegenerique(rs.getInt("classegenerique_id"),
                                   new niveau(rs.getInt("classegenerique_id_niveau"), rs.getString("niveau_nom"),
                                              rs.getString("niveau_code")),
                                   new filiere(rs.getInt("classegenerique_id_filiere"),
                                               rs.getString("filiere_code"), rs.getString("filiere_nom")),
                                   new cycle(rs.getInt("classegenerique_id_cycle"), rs.getString("cycle_code"),
                                             rs.getString("cycle_nom")), rs.getString("classegenerique_discription")),
               rs.getString("classe_annee_scolaire"));
            }
            return classe;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String []args){
        ClasseController cl = new ClasseController();
        niveauController niveau = new niveauController();
        filiereController filiere = new filiereController();
        CycleController cycle= new CycleController();
        String classe= "3ème STE COL";
        System.out.println(cl.getClassByCycleNiveauFiliere(2, 3, 3));
            
        
    }
}
