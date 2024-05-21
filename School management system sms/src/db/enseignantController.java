/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

/**
 *
 * @author oussa
 */
public class enseignantController {
    public ArrayList<enseignant> getAllTeachers(){
        ArrayList<enseignant> List = new ArrayList<enseignant>();
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
                    "	LEFT JOIN `specialite` ON `enseignant`.`id_specialite` = `specialite`.`id_specialite`;");
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                List.add(new enseignant(rs.getInt("enseignantID"), new user(rs.getInt("userID"),rs.getString("userNom"), rs.getString("userPrenom"), rs.getString("userEmail"), rs.getString("userDateNais"),rs.getString("userLieuNais"),rs.getString("userTele"),rs.getString("userSexe"),rs.getString("userPhoto"),rs.getString("useRole")), new cycle(rs.getInt("cycleID"), rs.getString("cycleCode"), rs.getString("cycleNom")),new specialite(rs.getInt("specialiteID"), rs.getString("specialiteNom"))));
            }
            return List;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public enseignant getTeacherById(int id){
        enseignant Teacher =null;
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT `enseignant`.`id_enseignant` AS `enseignantID`, \n" +
                "    `enseignant`.`id_user` AS `enseignantUserID`,\n" +
                "    `enseignant`.`id_cycle` AS `enseignantCycleID`,\n" +
                "    `enseignant`.`id_specialite` AS `enseignantSpecialiteID`,\n" +
                "    `user`.`id_user` AS `userID`,\n" +
                "    `user`.`nom` AS `userNom`,\n" +
                "    `user`.`prenom` AS `userPrenom`,\n" +
                "    `user`.`email` AS `userEmail`,\n" +
                "    `user`.`role` AS `useRole`,\n" +
                "    `user`.`datenais` AS `userDateNais`,\n" +
                "    `user`.`lieunais` AS `userLieuNais`,\n" +
                "    `user`.`Telephone` AS `userTele`,\n" +
                "    `user`.`sexe` AS `userSexe`,\n" +
                "    `user`.`photo` AS `userPhoto`,\n" +
                "    `cycle`.`id_cycle` AS `cycleID`,\n" +
                "    `cycle`.`code` AS `cycleCode`,\n" +
                "    `cycle`.`nom` AS `cycleNom`,\n" +
                "    `specialite`.`id_specialite` AS `specialiteID`,\n" +
                "    `specialite`.`nom` AS `specialiteNom`\n" +
                "FROM `enseignant`\n" +
                "LEFT JOIN `user` ON `enseignant`.`id_user` = `user`.`id_user`\n" +
                "LEFT JOIN `cycle` ON `enseignant`.`id_cycle` = `cycle`.`id_cycle`\n" +
                "LEFT JOIN `specialite` ON `enseignant`.`id_specialite` = `specialite`.`id_specialite`\n" +
                "WHERE user.id_user = ? ");
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                Teacher = new enseignant(rs.getInt("enseignantID"), new user(rs.getInt("userID"),rs.getString("userNom"), rs.getString("userPrenom"), rs.getString("userEmail"), rs.getString("userDateNais"),rs.getString("userLieuNais"),rs.getString("userTele"),rs.getString("userSexe"),rs.getString("userPhoto"),rs.getString("useRole")), new cycle(rs.getInt("cycleID"), rs.getString("cycleCode"), rs.getString("cycleNom")),new specialite(rs.getInt("specialiteID"), rs.getString("specialiteNom")));
            }
            return Teacher;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int countAllTeachers(){
        int nbT = 0;
        try{
            PreparedStatement ps = cnxDB.getCon().prepareCall("select count(*) from enseignant");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                nbT = rs.getInt(1);
            }
            return nbT;
        }catch(SQLException e){
            e.printStackTrace();
            return 0 ;
        }
    }
    
    public boolean ExistTeacher(String nom , String prenom , String email){
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT\n" +
            "    *\n" +
            "FROM\n" +
            "    `enseignant`\n" +
            "    LEFT JOIN user on enseignant.id_user = user.id_user\n" +
            "    WHERE user.nom= ? and user.prenom =? and user.email=? ");
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setString(3, email);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
    
//    public ObservableList getAllStudentsByTeacher(int id){
//        ObservableList<user> List = FXCollections.observableArrayList();
//        try {
//            PreparedStatement ps = cnxDB.getCon().prepareCall("SELECT \n" +
//                "    `seance`.`id_seance` AS `seance_id`,\n" +
//                "    `seance`.`id_seancegenerique` AS `seance_id_seancegenerique`,\n" +
//                "    `seance`.`date` AS `seance_date`,\n" +
//                "    `seance`.`etat` AS `seance_etat`,\n" +
//                "    `seance`.`observation` AS `seance_observation`,\n" +
//                "    `seancegenerique`.`id_seancegenerique` AS `seancegenerique_id`,\n" +
//                "    `seancegenerique`.`id_module` AS `seancegenerique_id_module`,\n" +
//                "    `seancegenerique`.`id_matiere` AS `seancegenerique_id_matiere`,\n" +
//                "    `seancegenerique`.`id_enseignant` AS `seancegenerique_id_enseignant`,\n" +
//                "    `seancegenerique`.`id_classe` AS `seancegenerique_id_classe`,\n" +
//                "    `seancegenerique`.`jour` AS `seancegenerique_jour`,\n" +
//                "    `seancegenerique`.`heuredeb` AS `seancegenerique_heuredeb`,\n" +
//                "    `seancegenerique`.`heurefin` AS `seancegenerique_heurefin`,\n" +
//                "    `seancegenerique`.`observation` AS `seancegenerique_observation`,\n" +
//                "    `matiere`.`id_matiere` AS `matiere_id`,\n" +
//                "    `matiere`.`id_module` AS `matiere_id_module`,\n" +
//                "    `matiere`.`Nom` AS `matiere_nom`,\n" +
//                "    `module`.`id_module` AS `module_id`,\n" +
//                "    `module`.`Nom` AS `module_nom`,\n" +
//                "    `enseignant`.`id_enseignant` AS `enseignant_id`,\n" +
//                "    `cycle`.`id_cycle` AS `cycle_id`,\n" +
//                "    `cycle`.`code` AS `cycle_code`,\n" +
//                "    `cycle`.`nom` AS `cycle_nom`,\n" +
//                "    `classe`.`id_classe` AS `classe_id`,\n" +
//                "    `classe`.`id_classegenerique` AS `classe_id_classegenerique`,\n" +
//                "    `classe`.`annee_scolaire` AS `classe_annee_scolaire`,\n" +
//                "    `classegenerique`.`id_classegenerique` AS `classegenerique_id`,\n" +
//                "    `classegenerique`.`id_niveau` AS `classegenerique_id_niveau`,\n" +
//                "    `classegenerique`.`id_filiere` AS `classegenerique_id_filiere`,\n" +
//                "    `classegenerique`.`id_cycle` AS `classegenerique_id_cycle`,\n" +
//                "    `classegenerique`.`discription` AS `classegenerique_discription`,\n" +
//                "    `filiere`.`id_filiere` AS `filiere_id`,\n" +
//                "    `filiere`.`code` AS `filiere_code`,\n" +
//                "    `filiere`.`nom` AS `filiere_nom`,\n" +
//                "    `etudiant`.`id_etudiant` AS `etudiant_id`,\n" +
//                "    `etudiant`.`id_user` AS `etudiant_id_user`,\n" +
//                "    `etudiant`.`id_filiere` AS `etudiant_id_filiere`,\n" +
//                "    `user`.`id_user` AS `user_id`,\n" +
//                "    `user`.`nom` AS `user_nom`,\n" +
//                "    `user`.`prenom` AS `user_prenom`,\n" +
//                "    `user`.`email` AS `user_email`,\n" +
//                "    `user`.`role` AS `user_role`,\n" +
//                "    `user`.`datenais` AS `user_datenais`,\n" +
//                "    `user`.`lieunais` AS `user_lieunais`,\n" +
//                "    `user`.`Telephone` AS `user_Telephone`,\n" +
//                "    `user`.`sexe` AS `user_sexe`,\n" +
//                "    `user`.`photo` AS `user_photo`,\n" +
//                "    `niveau`.`id_niveau` AS `niveau_id`,\n" +
//                "    `niveau`.`code` AS `niveau_code`,\n" +
//                "    `niveau`.`nom` AS `niveau_nom`\n" +
//                "FROM `seance` \n" +
//                "	LEFT JOIN `seancegenerique` ON `seance`.`id_seancegenerique` = `seancegenerique`.`id_seancegenerique` \n" +
//                "	LEFT JOIN `matiere` ON `seancegenerique`.`id_matiere` = `matiere`.`id_matiere` \n" +
//                "	LEFT JOIN `module` ON `matiere`.`id_module` = `module`.`id_module` \n" +
//                "	LEFT JOIN `enseignant` ON `seancegenerique`.`id_enseignant` = `enseignant`.`id_enseignant` \n" +
//                "	LEFT JOIN `cycle` ON `enseignant`.`id_cycle` = `cycle`.`id_cycle` \n" +
//                "	LEFT JOIN `classe` ON `seancegenerique`.`id_classe` = `classe`.`id_classe` \n" +
//                "	LEFT JOIN `classegenerique` ON `classe`.`id_classegenerique` = `classegenerique`.`id_classegenerique` \n" +
//                "	LEFT JOIN `filiere` ON `classegenerique`.`id_filiere` = `filiere`.`id_filiere` \n" +
//                "	LEFT JOIN `etudiant` ON `etudiant`.`id_filiere` = `filiere`.`id_filiere` \n" +
//                "	LEFT JOIN `user` ON `etudiant`.`id_user` = `user`.`id_user` \n" +
//                "	LEFT JOIN `niveau` ON `classegenerique`.`id_niveau` = `niveau`.`id_niveau`\n" +
//                "WHERE `enseignant`.`id_user` = ?;");
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                List.add(new user(rs.getInt("user_id"), rs.getString("user_nom") , rs.getString("user_prenom"), rs.getString("user_datenais"), rs.getString("user_sexe")));
//
//            }
//            return List;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
    public ObservableList getAllStudentsByTeacher(int id){
        ObservableList<etudiant> List = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT \n" +
            "    etudiant.id_etudiant AS etudiantID,\n" +
            "    user.id_user AS userUserID,\n" +
            "    user.nom AS userNom,\n" +
            "    user.prenom AS userPrenom,\n" +
            "    user.email AS userEmail,\n" +
            "    user.role AS userRole,\n" +
            "    user.datenais AS userDatenais,\n" +
            "    user.lieunais AS userLieunais,\n" +
            "    user.Telephone AS userTele,\n" +
            "    user.sexe AS userSexe,\n" +
            "    user.photo AS userPhoto,\n" +
            "    filiere.id_filiere AS filiereID,\n" +
            "    filiere.code AS filiereCode,\n" +
            "    filiere.nom AS filiereNom,\n" +
            "    classe.id_classe AS classe_id,\n" +
            "    classe.id_classegenerique as classeIdClassegenerique,\n" +
            "    classe.annee_scolaire as classeAnneescolaire,\n" +
            "    classegenerique.id_classegenerique AS classegenerique_id,\n" +
            "    classegenerique.id_niveau AS classegenerique_id_niveau,\n" +
            "    classegenerique.id_filiere AS classegenerique_id_filiere,\n" +
            "    classegenerique.id_cycle AS classegenerique_id_cycle,\n" +
            "    classegenerique.discription AS classegenerique_discription,\n" +
            "    niveau.id_niveau AS niveau_id,\n" +
            "    niveau.code AS niveau_code,\n" +
            "    niveau.nom AS niveau_nom,\n" +
            "    cycle.id_cycle AS cycle_id,\n" +
            "    cycle.code AS cycle_code,\n" +
            "    cycle.nom AS cycle_nom\n" +
            "FROM etudiant\n" +
            "LEFT JOIN user ON etudiant.id_user = user.id_user\n" +
            "LEFT JOIN filiere ON etudiant.id_filiere = filiere.id_filiere\n" +
            "LEFT JOIN classe ON etudiant.id_classe=classe.id_classe\n" +
            "LEFT JOIN classegenerique ON classe.id_classegenerique = classegenerique.id_classegenerique\n" +
            "LEFT JOIN cycle ON classegenerique.id_cycle = cycle.id_cycle\n" +
            "LEFT JOIN seancegenerique ON seancegenerique.id_classe= classe.id_classe\n" +
            "LEFT JOIN enseignant ON seancegenerique.id_enseignant = enseignant.id_enseignant\n" +
            "LEFT JOIN niveau ON classegenerique.id_niveau = niveau.id_niveau\n" +
            "WHERE enseignant.id_user=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                List.add(new etudiant(rs.getInt("etudiantID"), new user(rs.getInt("userUserID"), rs.getString("userNom"), rs.getString("userPrenom"),
                        rs.getString("userEmail"), rs.getString("userDatenais"), rs.getString("userLieunais"),
                        rs.getString("userTele"), rs.getString("userSexe"), rs.getString("userPhoto"),
                        rs.getString("userRole")),
                        new filiere(rs.getInt("filiereID"), rs.getString("filiereCode"), rs.getString("filiereNom")) 
                        , new classe(rs.getInt("classe_id"), new classegenerique(rs.getInt("classegenerique_id"),
                                new niveau(rs.getInt("niveau_id"), rs.getString("niveau_nom"), rs.getString("niveau_code")),
                                new filiere(rs.getInt("filiereID"), rs.getString("filiereCode"), rs.getString("filiereNom")),
                                new cycle(rs.getInt("cycle_id"), rs.getString("cycle_code"), rs.getString("cycle_nom")), rs.getString("classegenerique_discription")), rs.getString("classeAnneescolaire"))));
            }
            return List;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    
        
        
    public ObservableList getAllStudentsByTeacherAndClasse(int id_Teacher , int id_Classe){
        ObservableList<etudiant> List = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT \n" +
            "    etudiant.id_etudiant AS etudiantID,\n" +
            "    user.id_user AS userUserID,\n" +
            "    user.nom AS userNom,\n" +
            "    user.prenom AS userPrenom,\n" +
            "    user.email AS userEmail,\n" +
            "    user.role AS userRole,\n" +
            "    user.datenais AS userDatenais,\n" +
            "    user.lieunais AS userLieunais,\n" +
            "    user.Telephone AS userTele,\n" +
            "    user.sexe AS userSexe,\n" +
            "    user.photo AS userPhoto,\n" +
            "    filiere.id_filiere AS filiereID,\n" +
            "    filiere.code AS filiereCode,\n" +
            "    filiere.nom AS filiereNom,\n" +
            "    classe.id_classe AS classe_id,\n" +
            "    classe.id_classegenerique as classeIdClassegenerique,\n" +
            "    classe.annee_scolaire as classeAnneescolaire,\n" +
            "    classegenerique.id_classegenerique AS classegenerique_id,\n" +
            "    classegenerique.id_niveau AS classegenerique_id_niveau,\n" +
            "    classegenerique.id_filiere AS classegenerique_id_filiere,\n" +
            "    classegenerique.id_cycle AS classegenerique_id_cycle,\n" +
            "    classegenerique.discription AS classegenerique_discription,\n" +
            "    niveau.id_niveau AS niveau_id,\n" +
            "    niveau.code AS niveau_code,\n" +
            "    niveau.nom AS niveau_nom,\n" +
            "    cycle.id_cycle AS cycle_id,\n" +
            "    cycle.code AS cycle_code,\n" +
            "    cycle.nom AS cycle_nom\n" +
            "FROM etudiant\n" +
            "LEFT JOIN user ON etudiant.id_user = user.id_user\n" +
            "LEFT JOIN filiere ON etudiant.id_filiere = filiere.id_filiere\n" +
            "LEFT JOIN classe ON etudiant.id_classe=classe.id_classe\n" +
            "LEFT JOIN classegenerique ON classe.id_classegenerique = classegenerique.id_classegenerique\n" +
            "LEFT JOIN cycle ON classegenerique.id_cycle = cycle.id_cycle\n" +
            "LEFT JOIN seancegenerique ON seancegenerique.id_classe= classe.id_classe\n" +
            "LEFT JOIN enseignant ON seancegenerique.id_enseignant = enseignant.id_enseignant\n" +
            "LEFT JOIN niveau ON classegenerique.id_niveau = niveau.id_niveau\n" +
            "WHERE enseignant.id_user=? and classe.id_classe =?");
            ps.setInt(1, id_Teacher);
            ps.setInt(2, id_Classe);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                List.add(new etudiant(rs.getInt("etudiantID"), new user(rs.getInt("userUserID"), rs.getString("userNom"), rs.getString("userPrenom"),
                        rs.getString("userEmail"), rs.getString("userDatenais"), rs.getString("userLieunais"),
                        rs.getString("userTele"), rs.getString("userSexe"), rs.getString("userPhoto"),
                        rs.getString("userRole")),
                        new filiere(rs.getInt("filiereID"), rs.getString("filiereCode"), rs.getString("filiereNom")) 
                        , new classe(rs.getInt("classe_id"), new classegenerique(rs.getInt("classegenerique_id"),
                                new niveau(rs.getInt("niveau_id"), rs.getString("niveau_nom"), rs.getString("niveau_code")),
                                new filiere(rs.getInt("filiereID"), rs.getString("filiereCode"), rs.getString("filiereNom")),
                                new cycle(rs.getInt("cycle_id"), rs.getString("cycle_code"), rs.getString("cycle_nom")), rs.getString("classegenerique_discription")), rs.getString("classeAnneescolaire"))));
            }
            return List;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    
    public user getUserByIdTeacher(int id_teacher){
        user user = null;
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT user.* FROM `user`, enseignant WHERE enseignant.id_user= user.id_user and enseignant.id_enseignant=?");
            ps.setInt(1, id_teacher);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user = new user(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(5));
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
            
    }
    
    public int insert(user User) throws SQLException{
            PreparedStatement ps = cnxDB.getCon().prepareStatement("INSERT INTO `user`(`nom`, `prenom`, `email`, `role`, `datenais`, `lieunais`, `Telephone`, `sexe`, `photo`) VALUES (?,?,?,?,?,?,?,?,?) " , Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, User.getNom());
            ps.setString(2, User.getPrenom());
            ps.setString(3, User.getEmail());
            ps.setString(4, "teacher");
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
    
    public int insert (enseignant ens) throws SQLException{
        //int userId = insert(etd.getUser()); 
        PreparedStatement ps = cnxDB.getCon().prepareStatement("INSERT INTO `enseignant`( `id_user`, `id_cycle`, `id_specialite`) VALUES (?,?,?)");
        ps.setInt(1 , ens.getUser().getId_user());
        ps.setInt(2, ens.getCycle().getId_cycle());
        ps.setInt(3, ens.getSpecialite().getId_specialite());
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
    
    public void update(user User){
        try{ 
            PreparedStatement ps = cnxDB.getCon().prepareStatement("UPDATE `user` SET `nom`=? ,`prenom`=?,`email`=?,`datenais`=?,`lieunais`=?,`Telephone`=?,`sexe`=? WHERE id_user=?");
            ps.setString(1, User.getNom());
            ps.setString(2, User.getPrenom());
            ps.setString(3, User.getEmail());
            ps.setString(4, User.getDateNais());
            ps.setString(5, User.getLieuNais());
            ps.setString(6, User.getTele());
            ps.setString(7, User.getSexe());
            ps.setInt(8, User.getId_user());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        
    }
    
    public void update(enseignant tsh){
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("UPDATE `enseignant` SET `id_cycle`=?,`id_specialite`=? WHERE `id_user`=?");
            ps.setInt(1, tsh.getCycle().getId_cycle());
            ps.setInt(2, tsh.getSpecialite().getId_specialite());
            ps.setInt(3, tsh.getUser().getId_user());
             ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        

    }
    
    public static void main (String []args){
        enseignantController tsh = new enseignantController();
//        int id_user =3;
//            String fname="hassan";
//            String lname="driouch";
//            String dateNais= "11/11/2002";
//            String LieuNais= "sale";
//            String Email = "hassandriouch@gmail.com";
//            String Tele="0710000000";
//            String gender="M";
//        tsh.update(new user(id_user, lname, fname, Email, dateNais, LieuNais, Tele, gender, ""));
//        tsh.update(new enseignant(new user(id_user), new cycle(3), new specialite(1)));
//        System.out.println(tsh.getAllStudentsByTeacherAndClasse(3, 2));
//        System.out.println(tsh.ExistTeacher("el baouri", "khalid", "khalid@gmail.com"));
           System.out.println(tsh.getTeacherById(1));

    }
}
