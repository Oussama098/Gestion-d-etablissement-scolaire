/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.absenceetudiant;
import model.*;

/**
 *
 * @author oussa
 */
public class AbsenceEtudiantController {
    
    public int insert(absenceetudiant abstudiant)throws SQLException{
        PreparedStatement ps = cnxDB.getCon().prepareStatement("INSERT INTO `absenceetudiant`(`id_etudiant`, `id_seance`, `Justification`, `Motif`) VALUES (?,?,?,?)");
        ps.setInt(1, abstudiant.getEtudiant().getId_etudiant());
        ps.setInt(2, abstudiant.getSeance().getId_seance());
        ps.setBoolean(3, abstudiant.isJustification());
        ps.setString(4, abstudiant.getMotif());
        return ps.executeUpdate();
    }
    
    public int update(absenceetudiant abstudiant) throws SQLException{
        PreparedStatement ps = cnxDB.getCon().prepareStatement("UPDATE `absenceetudiant` SET `Justification`=? ,`DocJustifAbsEtudiantID`=? WHERE absenceetudiant.ID=?");
        int justif = abstudiant.isJustification() ? 1 : 0;
        ps.setInt(1, justif);
        ps.setInt(2, abstudiant.getDocJustifAbsEtudiant().getId());
        ps.setInt(3, abstudiant.getId());
        return ps.executeUpdate();
    }
    
    public ObservableList<seance> getAllAbsenceNoJustifiedByStudent(int id_user){
        ObservableList<seance> seance= FXCollections.observableArrayList();
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT\n" +
            "    `seance`.`id_seance` AS `seance_id`,\n" +
            "    `seance`.`id_seancegenerique` AS `seance_id_seancegenerique`,\n" +
            "    `seance`.`date` AS `seance_date`,\n" +
            "    `seance`.`etat` AS `seance_etat`,\n" +
            "    `seance`.`observation` AS `seance_observation`,\n" +
            "    `seancegenerique`.`id_seancegenerique` AS `seancegenerique_id`,\n" +
            "    `seancegenerique`.`id_module` AS `seancegenerique_id_module`,\n" +
            "    `seancegenerique`.`id_matiere` AS `seancegenerique_id_matiere`,\n" +
            "    `seancegenerique`.`id_enseignant` AS `seancegenerique_id_enseignant`,\n" +
            "    `seancegenerique`.`id_classe` AS `seancegenerique_id_classe`,\n" +
            "    `seancegenerique`.`jour` AS `seancegenerique_jour`,\n" +
            "    `seancegenerique`.`heuredeb` AS `seancegenerique_heuredeb`,\n" +
            "    `seancegenerique`.`heurefin` AS `seancegenerique_heurefin`,\n" +
            "    `seancegenerique`.`observation` AS `seancegenerique_observation`,\n" +
            "    `matiere`.`id_matiere` AS `matiere_id`,\n" +
            "    `matiere`.`id_module` AS `matiere_id_module`,\n" +
            "    `matiere`.`Nom` AS `matiere_nom`,\n" +
            "    `module`.`id_module` AS `module_id`,\n" +
            "    `module`.`Nom` AS `module_nom`\n" +
            "FROM `seance`\n" +
            "LEFT JOIN `seancegenerique` ON `seance`.`id_seancegenerique` = `seancegenerique`.`id_seancegenerique`\n" +
            "LEFT JOIN `matiere` ON `seancegenerique`.`id_matiere` = `matiere`.`id_matiere`\n" +
            "LEFT JOIN `module` ON `seancegenerique`.`id_module` = `module`.`id_module`\n" +
            "LEFT JOIN absenceetudiant ON absenceetudiant.id_seance= seance.id_seance\n" +
            "LEFT JOIN etudiant on absenceetudiant.id_etudiant= etudiant.id_etudiant\n" +
            "WHERE etudiant.id_user=? and absenceetudiant.Justification=0");
            ps.setInt(1, id_user);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                seance.add(new seance(rs.getInt("seance_id"), new seancegenerique(rs.getInt("seancegenerique_id"), new module(rs.getInt("seancegenerique_id_module"), rs.getString("module_nom")), new matiere(rs.getInt("seancegenerique_id_matiere"), new module(rs.getInt("seancegenerique_id_module"), rs.getString("module_nom")), rs.getString("matiere_nom")), null, null, rs.getString("seancegenerique_jour"), rs.getString("seancegenerique_heuredeb"), rs.getString("seancegenerique_heurefin"), rs.getString("seancegenerique_observation")), rs.getDate("seance_date"), rs.getString("seance_etat"), rs.getString("seance_observation")));
            }
            return seance;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public absenceetudiant getabsenceetudiantIdByseanceIdAndStudent(int id_seance , int id_etudiant){
        absenceetudiant abs = null;
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT\n" +
            "    `ID`,\n" +
            "    absenceetudiant.`id_etudiant`,\n" +
            "    seance.`id_seance`,\n" +
            "    `Justification`,\n" +
            "    `Motif`,\n" +
            "    `DocJustifAbsEtudiantID`\n" +
            "FROM\n" +
            "    `absenceetudiant`\n" +
            "LEFT JOIN etudiant ON absenceetudiant.id_etudiant= etudiant.id_etudiant\n" +
            "LEFT JOIN seance on absenceetudiant.id_seance = seance.id_seance\n" +
            "WHERE\n" +
            "    etudiant.id_user = ? AND seance.id_seance = ?");
            ps.setInt(1, id_etudiant);
            ps.setInt(2, id_seance);
            ResultSet rs = ps.executeQuery();
            boolean justif;
            if (rs.next()) {  
                justif = rs.getInt(4)==1 ? true : false;
                abs= new absenceetudiant(rs.getInt(1), null, null, justif, rs.getString(5), null);
            }
            return abs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
    
    public ResultSet getAbsenceByMonth(){
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT MONTH(seance.date) AS month, COUNT(*) AS absence_count \n" +
            "FROM absenceetudiant\n" +
            "LEFT JOIN seance ON absenceetudiant.id_seance=seance.id_seance\n" +
            "GROUP BY MONTH(date)\n" +
            "ORDER BY MONTH(date);");
            ResultSet rs= ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet getAbsenceByMonth(int id_classe){
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT MONTH(seance.date) AS month, COUNT(*) AS absence_count \n" +
            "FROM absenceetudiant\n" +
            "LEFT JOIN seance ON absenceetudiant.id_seance=seance.id_seance\n" +
            "LEFT JOIN seancegenerique on seance.id_seancegenerique = seancegenerique.id_seancegenerique \n"+
            "WHERE seancegenerique.id_classe=? \n"+
            "GROUP BY MONTH(date)\n" +
            "ORDER BY MONTH(date);");
            ps.setInt(1, id_classe);
            ResultSet rs= ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ObservableList<absenceetudiant> CountAbsenceOfEachStudent(int id_classe) {
        ObservableList <absenceetudiant> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT\n" +
            "    etudiant.id_etudiant AS `etudiantId`,\n" +
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
            "    `cycle`.`nom` AS `cycle_nom`,\n" +
            "    COUNT(absenceetudiant.ID) AS absence_count\n" +
            "FROM\n" +
            "    etudiant\n" +
            "LEFT JOIN absenceetudiant ON etudiant.id_etudiant = absenceetudiant.id_etudiant\n" +
            "LEFT JOIN user ON etudiant.id_user = user.id_user\n" +
            "LEFT JOIN `filiere` ON `etudiant`.`id_filiere` = `filiere`.`id_filiere`\n" +
            "LEFT JOIN `classe` ON `etudiant`.`id_classe`=`classe`.`id_classe`\n" +
            "LEFT JOIN `classegenerique` ON `classe`.`id_classegenerique` = `classegenerique`.`id_classegenerique`\n" +
            "LEFT JOIN `cycle` ON `classegenerique`.`id_cycle` = `cycle`.`id_cycle`\n" +
            "LEFT JOIN `niveau` ON `classegenerique`.`id_niveau` = `niveau`.`id_niveau`\n" +
            "WHERE etudiant.id_classe=?   \n" +
            "GROUP BY\n" +
            "    etudiant.id_etudiant\n" +
//            "HAVING COUNT(absenceetudiant.ID) > 1\n"+        
            "ORDER BY\n" +
            "    COUNT(absenceetudiant.ID) DESC;");
            ps.setInt(1, id_classe);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new absenceetudiant(0, new etudiant(rs.getInt("etudiantId"),
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
               rs.getString("classeAnneescolaire"))), null, false, "", null, rs.getInt("absence_count")));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String [] args){
        AbsenceEtudiantController ab = new AbsenceEtudiantController();
        System.out.println(ab.CountAbsenceOfEachStudent(1));
//        ResultSet rs =ab.getAbsenceByMonth(1);
//        try {
//           while (rs.next()) {            
//               System.out.println(rs.getInt(1)+":" + rs.getInt(2));
//           } 
//        } catch (Exception e) {
//        }

    }
    
}
