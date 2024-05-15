package db;

import javafx.collections.ObservableList;
import java.sql.*;
import javafx.collections.FXCollections;
import model.*;


/**
 *
 * @author oussa
 */
public class NotesController {
    
    public ObservableList<note> getStudentsMarksByTeacherAndClass(int id_classe){
        ObservableList<note> items = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT\n" +
            "    `notes`.`id_note` AS `NoteID`,\n" +
            "    `notes`.`id_etudiant` AS `NoteEtudiantID`,\n" +
            "    `notes`.`id_controle` AS `NoteControleID`,\n" +
            "    `notes`.`Note CC` AS `NoteCC`,\n" +
            "    `notes`.`Note TP` AS `NoteTP`,\n" +
            "    `notes`.`Note Examen` AS `NoteExamen`,\n" +
            "    `notes`.`date` AS `NoteDate`,\n" +
            "    `notes`.`etat` AS `NoteEtat`,\n" +
            "    `notes`.`obesrvation` AS `NoteObservation`,\n" +
            "    `etudiant`.`id_etudiant` AS `EtudiantID`,\n" +
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
            "    `cycle`.`nom` AS `cycle_nom` , \n" +
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
            "    `notes`\n" +
            "RIGHT JOIN `etudiant` ON `notes`.`id_etudiant` = `etudiant`.`id_etudiant`\n" +
            "    LEFT JOIN `user` ON `etudiant`.`id_user` = `user`.`id_user`\n" +
            "    LEFT JOIN `filiere` ON `etudiant`.`id_filiere` = `filiere`.`id_filiere`\n" +
            "    LEFT JOIN `classe` ON `etudiant`.`id_classe`=`classe`.`id_classe`\n" +
            "    LEFT JOIN `classegenerique` ON `classe`.`id_classegenerique` = `classegenerique`.`id_classegenerique`\n" +
            "    LEFT JOIN `cycle` ON `classegenerique`.`id_cycle` = `cycle`.`id_cycle`\n" +
            "    LEFT JOIN `niveau` ON `classegenerique`.`id_niveau` = `niveau`.`id_niveau`\n"+
            "LEFT JOIN `controle` ON `notes`.`id_controle` = `controle`.`ID_controle`\n" +
            "LEFT JOIN `module` ON `controle`.`id_module` = `module`.`id_module`\n" +
            "LEFT JOIN `matiere` ON `controle`.`id_matiere` = `matiere`.`id_matiere`\n"+
            "Where etudiant.id_classe=? ");
            ps.setInt(1, id_classe);
            ResultSet rs= ps.executeQuery();
            while (rs.next()) {                
                items.add(new note(rs.getInt("NoteID"), new etudiant(rs.getInt("EtudiantID"), new user(rs.getInt("EtudiantID"), rs.getString("userNom"), rs.getString("userPrenom"),
             rs.getString("userEmail"), rs.getString("userDatenais"), rs.getString("userLieunais"),
             rs.getString("userTele"), rs.getString("userSexe"), rs.getString("userPhoto"),
             rs.getString("userRole")), new filiere(rs.getInt("filiereID"), rs.getString("filiereCode"), rs.getString("filiereNom")),     new classe(rs.getInt("classe_id"),
               new classegenerique(rs.getInt("classegenerique_id"),
                                   new niveau(rs.getInt("classegenerique_id_niveau"), rs.getString("niveau_nom"),
                                              rs.getString("niveau_code")),
                                   new filiere(rs.getInt("classegenerique_id_filiere"),
                                               rs.getString("filiereCode"), rs.getString("filiereNom")),
                                   new cycle(rs.getInt("classegenerique_id_cycle"), rs.getString("cycle_code"),
                                             rs.getString("cycle_nom")), rs.getString("classegenerique_discription")),
               rs.getString("classeAnneescolaire"))), new controle(rs.getInt("ControleId"), rs.getString("ControleNom"), new module(rs.getInt("ControleIdModule"), rs.getString("ModuleName")), new matiere(rs.getInt("ControleIdMatiere"),new module(rs.getInt("ControleIdModule"), rs.getString("ModuleName")) , rs.getString("MatiereNom")), rs.getInt("ControleDuree"), null, null, rs.getString("ControleEtat"), rs.getString("ControleObservation")), rs.getFloat("NoteCC"), rs.getFloat("NoteTP"), rs.getFloat("NoteExamen"), rs.getDate("NoteDate"),rs.getString("NoteEtat"), rs.getString("NoteObservation")));
            }
            return items;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int insert(note note) throws SQLException{
        PreparedStatement ps = cnxDB.getCon().prepareStatement("INSERT INTO `notes`(`id_etudiant`, `id_controle`, `Note CC`, `Note TP`, `Note Examen`) VALUES (?,?,?,?,?);");
        ps.setInt(1,note.getEtudiant().getId_etudiant());
        ps.setInt(2, note.getControle().getId_controle());
        ps.setFloat(3, note.getNoteCC());
        ps.setFloat(4, note.getNoteTP());
        ps.setFloat(5, note.getNoteExamen());
        return ps.executeUpdate();   
    }
    
    public ObservableList<note> getMarksForEachStudent(int id_user) {
    ObservableList<note> items = FXCollections.observableArrayList();
    try {
        PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT\n" +
        "    notes.id_note AS `noteId`,\n" +
        "    notes.id_etudiant AS `etudiantId`,\n" +
        "    notes.id_controle AS `controleId`,\n" +
        "    notes.`Note CC` AS `noteCC`,\n" +
        "    notes.`Note TP` AS `noteTP`,\n" +
        "    notes.`Note Examen` AS `noteExamen`,\n" +
        "    notes.date AS `noteDate`,\n" +
        "    notes.etat AS `noteEtat`,\n" +
        "    notes.obesrvation AS `noteObservation`,\n" +
        "    controle.ID_controle AS `controleId`,\n" +
        "    controle.Nom AS `controleNom`,\n" +
        "    controle.id_module AS `moduleID`,\n" +
        "    controle.id_matiere AS `matiereID`,\n" +
        "    controle.Duree AS `controleDuree`,\n" +
        "    controle.id_classe AS `classeID`,\n" +
        "    controle.id_enseignant AS `enseignantID`,\n" +
        "    controle.etat AS `controleEtat`,\n" +
        "    controle.observation AS `controleObservation`,\n" +
        "    module.id_module AS `moduleID`,\n" +
        "    module.Nom AS `moduleName`,\n" +
        "    matiere.id_matiere AS `matiereID`,\n" +
        "    matiere.id_module AS `moduleID`,\n" +
        "    matiere.Nom AS `matiereNom`\n" +
        "FROM\n" +
        "    notes\n" +
        "LEFT JOIN controle ON notes.id_controle = controle.ID_controle\n" +
        "LEFT JOIN module ON controle.id_module = module.id_module\n" +
        "LEFT JOIN matiere ON controle.id_matiere = matiere.id_matiere\n" +
        "LEFT JOIN etudiant ON notes.id_etudiant = etudiant.id_etudiant\n" +
        "WHERE\n" +
        "    etudiant.id_user = ?;");
        ps.setInt(1, id_user);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            module m = new module(rs.getInt("moduleID"), rs.getString("moduleName"));
            controle c = new controle(rs.getInt("controleId"), rs.getString("controleNom"), m, new matiere(rs.getInt("matiereID"), m, rs.getString("matiereNom")), rs.getInt("controleDuree"), null, null, rs.getString("controleEtat"), rs.getString("controleObservation"));
            items.add(new note(rs.getInt("noteId"), null, c, rs.getFloat("noteCC"), rs.getFloat("noteTP"), rs.getFloat("noteExamen"), rs.getDate("noteDate"), rs.getString("noteEtat"), rs.getString("noteObservation")));
        }
        return items;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }

    
}

    public ResultSet getMarksStudents(){
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT\n" +
            "    SUM(CASE WHEN ((0.5 * `Note Examen`) + (0.25 * `Note CC`) + (0.25 * `Note TP`)) > 10 THEN 1 ELSE 0 END) AS count_gt_10,\n" +
            "    SUM(CASE WHEN ((0.5 * `Note Examen`) + (0.25 * `Note CC`) + (0.25 * `Note TP`)) < 10 THEN 1 ELSE 0 END) AS count_lt_10,\n" +
            "    SUM(CASE WHEN ((0.5 * `Note Examen`) + (0.25 * `Note CC`) + (0.25 * `Note TP`)) = 0 THEN 1 ELSE 0 END) AS count_eq_0\n" +
            "FROM notes\n" +
            "LEFT JOIN etudiant ON notes.id_etudiant= etudiant.id_etudiant ;");
            return ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet getMarksStudentsByClasse(int id_classe){
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT\n" +
            "    SUM(CASE WHEN ((0.5 * `Note Examen`) + (0.25 * `Note CC`) + (0.25 * `Note TP`)) > 10 THEN 1 ELSE 0 END) AS count_gt_10,\n" +
            "    SUM(CASE WHEN ((0.5 * `Note Examen`) + (0.25 * `Note CC`) + (0.25 * `Note TP`)) < 10 THEN 1 ELSE 0 END) AS count_lt_10,\n" +
            "    SUM(CASE WHEN ((0.5 * `Note Examen`) + (0.25 * `Note CC`) + (0.25 * `Note TP`)) = 0 THEN 1 ELSE 0 END) AS count_eq_0\n" +
            "FROM notes\n" +
            "LEFT JOIN etudiant ON notes.id_etudiant= etudiant.id_etudiant\n" +
            "WHERE etudiant.id_classe =?;");
            ps.setInt(1, id_classe);
            return ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int update(note note) throws SQLException{
        PreparedStatement ps = cnxDB.getCon().prepareStatement("UPDATE `notes` SET `Note CC`=?,`Note TP`=?,`Note Examen`=?  WHERE notes.id_etudiant=?");
        ps.setFloat(1, note.getNoteCC());
        ps.setFloat(2, note.getNoteTP());
        ps.setFloat(3, note.getNoteExamen());
        ps.setInt(4, note.getId_etudiant());
        return ps.executeUpdate();
    }
    
    public boolean ExistMarksEtudiant(int id_etudiant){
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT * FROM `notes` WHERE id_etudiant=?");
            ps.setInt(1, id_etudiant);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
    
    public static void main(String []args){
        NotesController no = new NotesController();
        System.out.println(no.getMarksForEachStudent(1));
    }
}
