/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.*;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import model.*;
import model.etudiant;

/**
 *
 * @author oussa
 */
public class EtudiantController {
    public ObservableList<etudiant> getAllStudents(){
        ObservableList<etudiant> List = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT `etudiant`.`id_etudiant` AS `etudiantID`,\n" +
            "    `etudiant`.`id_user` AS `etudiantUserId`,\n" +
            "    `etudiant`.`id_filiere` AS `etudiantFiliereID`,\n" +
            "    `user`.`id_user` AS `userUserID`,\n" +
            "    `user`.`nom` AS `userNom`,\n" +
            "    `user`.`prenom` AS `userPrenom`,\n" +
            "    `user`.`email` AS `userEmail`,\n" +
            "    `user`.`role` AS `userRole`,\n" +
            "    `user`.`datenais` AS `userDatenais`,\n" +
            "    `user`.`lieunais` AS `userLieunais`,\n" +
            "    `user`.`Telephone` AS `userTele`,\n" +
            "    `user`.`sexe` AS `userSexe`,\n" +
            "    `user`.`photo` AS `userPhoto`,\n" +
            "    `filiere`.`id_filiere` AS `filiereID`,\n" +
            "    `filiere`.`code` AS `filiereCode`,\n" +
            "    `filiere`.`nom` AS `filiereNom`,\n" +
            "    `classe`.`id_classe` AS `classe_id`,\n" +
            "    `classe`.`id_classegenerique` as `classeIdClassegenerique`,\n" +
            "    `classe`.`annee_scolaire` as `classeAnneescolaire`,\n" +
            "    `classegenerique`.`id_classegenerique` AS `classegenerique_id`,\n" +
            "    `classegenerique`.`id_niveau` AS `classegenerique_id_niveau`,\n" +
            "    `classegenerique`.`id_filiere` AS `classegenerique_id_filiere`,\n" +
            "    `classegenerique`.`id_cycle` AS `classegenerique_id_cycle`,\n" +
            "    `classegenerique`.`discription` AS `classegenerique_discription`,\n" +
            "    `niveau`.`id_niveau` AS `niveau_id`,\n" +
            "    `niveau`.`code` AS `niveau_code`,\n" +
            "    `niveau`.`nom` AS `niveau_nom`,\n" +
            "    `cycle`.`id_cycle` AS `cycle_id`,\n" +
            "    `cycle`.`code` AS `cycle_code`,\n" +
            "    `cycle`.`nom` AS `cycle_nom`\n" +
            "FROM `etudiant`\n" +
            "    LEFT JOIN `user` ON `etudiant`.`id_user` = `user`.`id_user`\n" +
            "    LEFT JOIN `filiere` ON `etudiant`.`id_filiere` = `filiere`.`id_filiere`\n" +
            "    LEFT JOIN `classe` ON `etudiant`.`id_classe`=`classe`.`id_classe`\n" +
            "    LEFT JOIN `classegenerique` ON `classe`.`id_classegenerique` = `classegenerique`.`id_classegenerique`\n" +
            "    LEFT JOIN `cycle` ON `classegenerique`.`id_cycle` = `cycle`.`id_cycle`\n" +
            "    LEFT JOIN `niveau` ON `classegenerique`.`id_niveau` = `niveau`.`id_niveau`");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                List.add(new etudiant(rs.getInt("etudiantID"),
    new user(rs.getInt("etudiantUserID"), rs.getString("userNom"), rs.getString("userPrenom"),
             rs.getString("userEmail"), rs.getString("userDatenais"), rs.getString("userLieunais"),
             rs.getString("userTele"), rs.getString("userSexe"), rs.getString("userPhoto"),
             rs.getString("userRole")),
    new filiere(rs.getInt("filiereID"), rs.getString("filiereCode"), rs.getString("filiereNom")),
    new classe(rs.getInt("classe_id"),
               new classegenerique(rs.getInt("classegenerique_id"),
                                   new niveau(rs.getInt("classegenerique_id_niveau"), rs.getString("niveau_nom"),
                                              rs.getString("niveau_code")),
                                   new filiere(rs.getInt("classegenerique_id_filiere"),
                                               rs.getString("filiereCode"), rs.getString("filiereNom")),
                                   new cycle(rs.getInt("classegenerique_id_cycle"), rs.getString("cycle_code"),
                                             rs.getString("cycle_nom")), rs.getString("classegenerique_discription")),
               rs.getString("classeAnneescolaire")))
);
            }
            return List;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ObservableList<etudiant> getAllStudentsByClasse(int id_Classe){
        ObservableList<etudiant> List = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT `etudiant`.`id_etudiant` AS `etudiantID`,\n" +
            "    `etudiant`.`id_user` AS `etudiantUserId`,\n" +
            "    `etudiant`.`id_filiere` AS `etudiantFiliereID`,\n" +
            "    `user`.`id_user` AS `userUserID`,\n" +
            "    `user`.`nom` AS `userNom`,\n" +
            "    `user`.`prenom` AS `userPrenom`,\n" +
            "    `user`.`email` AS `userEmail`,\n" +
            "    `user`.`role` AS `userRole`,\n" +
            "    `user`.`datenais` AS `userDatenais`,\n" +
            "    `user`.`lieunais` AS `userLieunais`,\n" +
            "    `user`.`Telephone` AS `userTele`,\n" +
            "    `user`.`sexe` AS `userSexe`,\n" +
            "    `user`.`photo` AS `userPhoto`,\n" +
            "    `filiere`.`id_filiere` AS `filiereID`,\n" +
            "    `filiere`.`code` AS `filiereCode`,\n" +
            "    `filiere`.`nom` AS `filiereNom`,\n" +
            "    `classe`.`id_classe` AS `classe_id`,\n" +
            "    `classe`.`id_classegenerique` as `classeIdClassegenerique`,\n" +
            "    `classe`.`annee_scolaire` as `classeAnneescolaire`,\n" +
            "    `classegenerique`.`id_classegenerique` AS `classegenerique_id`,\n" +
            "    `classegenerique`.`id_niveau` AS `classegenerique_id_niveau`,\n" +
            "    `classegenerique`.`id_filiere` AS `classegenerique_id_filiere`,\n" +
            "    `classegenerique`.`id_cycle` AS `classegenerique_id_cycle`,\n" +
            "    `classegenerique`.`discription` AS `classegenerique_discription`,\n" +
            "    `niveau`.`id_niveau` AS `niveau_id`,\n" +
            "    `niveau`.`code` AS `niveau_code`,\n" +
            "    `niveau`.`nom` AS `niveau_nom`,\n" +
            "    `cycle`.`id_cycle` AS `cycle_id`,\n" +
            "    `cycle`.`code` AS `cycle_code`,\n" +
            "    `cycle`.`nom` AS `cycle_nom`\n" +
            "FROM `etudiant`\n" +
            "    LEFT JOIN `user` ON `etudiant`.`id_user` = `user`.`id_user`\n" +
            "    LEFT JOIN `filiere` ON `etudiant`.`id_filiere` = `filiere`.`id_filiere`\n" +
            "    LEFT JOIN `classe` ON `etudiant`.`id_classe`=`classe`.`id_classe`\n" +
            "    LEFT JOIN `classegenerique` ON `classe`.`id_classegenerique` = `classegenerique`.`id_classegenerique`\n" +
            "    LEFT JOIN `cycle` ON `classegenerique`.`id_cycle` = `cycle`.`id_cycle`\n" +
            "    LEFT JOIN `niveau` ON `classegenerique`.`id_niveau` = `niveau`.`id_niveau`\n"+
            "    WHERE `classe`.`id_classe`= ?");
            ps.setInt(1, id_Classe);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                List.add(new etudiant(rs.getInt("etudiantID"),
    new user(rs.getInt("etudiantUserID"), rs.getString("userNom"), rs.getString("userPrenom"),
             rs.getString("userEmail"), rs.getString("userDatenais"), rs.getString("userLieunais"),
             rs.getString("userTele"), rs.getString("userSexe"), rs.getString("userPhoto"),
             rs.getString("userRole")),
    new filiere(rs.getInt("filiereID"), rs.getString("filiereCode"), rs.getString("filiereNom")),
    new classe(rs.getInt("classe_id"),
               new classegenerique(rs.getInt("classegenerique_id"),
                                   new niveau(rs.getInt("classegenerique_id_niveau"), rs.getString("niveau_nom"),
                                              rs.getString("niveau_code")),
                                   new filiere(rs.getInt("classegenerique_id_filiere"),
                                               rs.getString("filiereCode"), rs.getString("filiereNom")),
                                   new cycle(rs.getInt("classegenerique_id_cycle"), rs.getString("cycle_code"),
                                             rs.getString("cycle_nom")), rs.getString("classegenerique_discription")),
               rs.getString("classeAnneescolaire")))
);
            }
            return List;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public etudiant getEtudiantById(int etudiantID){
        etudiant etd =null;
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT `etudiant`.`id_etudiant` AS `etudiantID`,\n" +
                "    `etudiant`.`id_user` AS `etudiantUserId`,\n" +
                "    `etudiant`.`id_filiere` AS `etudiantFiliereID`,\n" +
                "    `user`.`id_user` AS `userUserID`,\n" +
                "    `user`.`nom` AS `userNom`,\n" +
                "    `user`.`prenom` AS `userPrenom`,\n" +
                "    `user`.`email` AS `userEmail`,\n" +
                "    `user`.`role` AS `userRole`,\n" +
                "    `user`.`datenais` AS `userDatenais`,\n" +
                "    `user`.`lieunais` AS `userLieunais`,\n" +
                "    `user`.`Telephone` AS `userTele`,\n" +
                "    `user`.`sexe` AS `userSexe`,\n" +
                "    `user`.`photo` AS `userPhoto`,\n" +
                "    `filiere`.`id_filiere` AS `filiereID`,\n" +
                "    `filiere`.`code` AS `filiereCode`,\n" +
                "    `filiere`.`nom` AS `filiereNom`,\n" +
                "   	`classe`.`id_classe` AS `classe_id`,\n" +
                "    `classe`.`id_classegenerique` as `classeIdClassegenerique`,\n" +
                "    `classe`.`annee_scolaire` as `classeAnneescolaire`,\n" +
                "    `classegenerique`.`id_classegenerique` AS `classegenerique_id`,\n" +
                "    `classegenerique`.`id_niveau` AS `classegenerique_id_niveau`,\n" +
                "    `classegenerique`.`id_filiere` AS `classegenerique_id_filiere`,\n" +
                "    `classegenerique`.`id_cycle` AS `classegenerique_id_cycle`,\n" +
                "    `classegenerique`.`discription` AS `classegenerique_discription`,\n" +
                "    `niveau`.`id_niveau` AS `niveau_id`,\n" +
                "    `niveau`.`code` AS `niveau_code`,\n" +
                "    `niveau`.`nom` AS `niveau_nom`,\n" +
                "    `cycle`.`id_cycle` AS `cycle_id`,\n" +
                "    `cycle`.`code` AS `cycle_code`,\n" +
                "    `cycle`.`nom` AS `cycle_nom`\n" +
                "FROM `etudiant`\n" +
                "    LEFT JOIN `user` ON `etudiant`.`id_user` = `user`.`id_user`\n" +
                "    LEFT JOIN `filiere` ON `etudiant`.`id_filiere` = `filiere`.`id_filiere`\n" +
                "    LEFT JOIN `classe` ON `etudiant`.`id_classe`=`classe`.`id_classe`\n" +
                "    LEFT JOIN `classegenerique` ON `classe`.`id_classegenerique` = `classegenerique`.`id_classegenerique`\n" +
                "    LEFT JOIN `cycle` ON `classegenerique`.`id_cycle` = `cycle`.`id_cycle`\n" +
                "    LEFT JOIN `niveau` ON `classegenerique`.`id_niveau` = `niveau`.`id_niveau`\n" +
                "WHERE `id_etudiant` = ?;");
            ps.setInt(1, etudiantID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
//                etd = new etudiant(rs.getInt("etudiantID"),new user(rs.getInt("etudiantUserID"),rs.getString("userNom"), rs.getString("userPrenom"), rs.getString("userEmail"), rs.getString("userDatenais"),rs.getString("userLieunais"),rs.getString("userTele"),rs.getString("userSexe"),rs.getString("userPhoto"),rs.getString("userRole")),new filiere(rs.getInt("filiereID"), rs.getString("filiereCode"), rs.getString("filiereNom")),new classe(rs.getInt("classe_id"), new classegenerique(rs.getInt("classegenerique_id"), new niveau(rs.getInt("classegenerique_id_niveau"), rs.getString("niveau_nom"), rs.getString("niveau_code")), new filiere(rs.getInt("classegenerique_id_filiere"), rs.getString("filiereCode"), rs.getString("filiereNom")), new cycle(rs.getInt("classegenerique_id_cycle"), rs.getString("cycle_code"), rs.getString("cycle_nom")), rs.getString("classegenerique_discription")), rs.getString("classeAnneescolaire")));
                    etd = new etudiant(rs.getInt("etudiantID"),
    new user(rs.getInt("etudiantUserID"), rs.getString("userNom"), rs.getString("userPrenom"),
             rs.getString("userEmail"), rs.getString("userDatenais"), rs.getString("userLieunais"),
             rs.getString("userTele"), rs.getString("userSexe"), rs.getString("userPhoto"),
             rs.getString("userRole")),
    new filiere(rs.getInt("filiereID"), rs.getString("filiereCode"), rs.getString("filiereNom")),
    new classe(rs.getInt("classe_id"),
               new classegenerique(rs.getInt("classegenerique_id"),
                                   new niveau(rs.getInt("classegenerique_id_niveau"), rs.getString("niveau_nom"),
                                              rs.getString("niveau_code")),
                                   new filiere(rs.getInt("classegenerique_id_filiere"),
                                               rs.getString("filiereCode"), rs.getString("filiereNom")),
                                   new cycle(rs.getInt("classegenerique_id_cycle"), rs.getString("cycle_code"),
                                             rs.getString("cycle_nom")), rs.getString("classegenerique_discription")),
               rs.getString("classeAnneescolaire")));

            }
            return etd;
        } catch (Exception e) {
            return null;
        }
    }
    
    
    
    //
    public int CountStudents(){
        int nbS=0;
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("select count(*) from etudiant");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                nbS=rs.getInt(1);
            }
            return nbS;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int insert(user User) throws SQLException{
        
            PreparedStatement ps = cnxDB.getCon().prepareStatement("INSERT INTO `user`(`nom`, `prenom`, `email`, `role`, `datenais`, `lieunais`, `Telephone`, `sexe`, `photo`) VALUES (?,?,?,?,?,?,?,?,?) " , Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, User.getNom());
            ps.setString(2, User.getPrenom());
            ps.setString(3, User.getEmail());
            ps.setString(4, "student");
            ps.setString(5, User.getDateNais());
            ps.setString(6, User.getLieuNais());
            ps.setString(7, User.getTele());
            ps.setString(8, User.getSexe());
            ps.setString(9, User.getPhoto());
            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Inserting user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Return the generated ID
                } else {
                    throw new SQLException("Inserting user failed, no ID obtained.");
                }
            }
        
    }
    
    public int insert (etudiant etd) throws SQLException{
        //int userId = insert(etd.getUser()); 
        PreparedStatement ps = cnxDB.getCon().prepareStatement("INSERT INTO `etudiant`(`id_user`, `id_classe`, `id_filiere`) VALUES (?,?,?)");
        ps.setInt(1 , etd.getUser().getId_user());
        ps.setInt(2, etd.getClasse().getId_classe());
        ps.setInt(3, etd.getFiliere().getId_filiere());
        return ps.executeUpdate();
    }
    
    public int delete (etudiant etd) throws SQLException{
        PreparedStatement ps = cnxDB.getCon().prepareStatement("DELETE FROM `etudiant` WHERE id_etudiant=?");
        ps.setInt(1, etd.getId_etudiant());
        
        return ps.executeUpdate();
    }
    
    public int delete (user User) throws SQLException{
        PreparedStatement ps = cnxDB.getCon().prepareStatement("DELETE FROM `user` WHERE `nom`=? and `prenom`=? and `email`=? and `datenais`= ? and `lieunais`=? and `Telephone`=? and `sexe`=? ");
        ps.setString(1, User.getNom());
        ps.setString(2, User.getPrenom());
        ps.setString(3, User.getEmail());
        ps.setString(4, User.getDateNais());
        ps.setString(5, User.getLieuNais());
        ps.setString(6, User.getTele());
        ps.setString(7, User.getSexe());
        
        return ps.executeUpdate();
    }
    
    public static void main(String args[]){
        EtudiantController etd = new EtudiantController();
        System.out.println(etd.getAllStudentsByClasse(1));
    }
}
