/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import com.mysql.cj.protocol.Resultset;
import model.seance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author oussa
 */
public class SeanceController {
    public ArrayList<seance> getSessionDataByStudent(int id){
        ArrayList<seance> seance= new ArrayList<seance>();
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT\n" +
                "    seance.id_seance AS 'SeanceID',\n" +
                "    seance.date AS 'SeanceDate',\n" +
                "    seancegenerique.id_module AS 'ModuleID',\n" +
                "    seancegenerique.id_matiere AS 'MatiereID',\n" +
                "    seancegenerique.id_enseignant AS 'EnseignantID',\n" +
                "    seancegenerique.id_classe AS 'ClasseID',\n" +
                "    seancegenerique.jour AS 'Jour',\n" +
                "    seancegenerique.heuredeb AS 'HeureDebut',\n" +
                "    seancegenerique.heurefin AS 'HeureFin',\n" +
                "    matiere.Nom AS 'MatiereNom',\n" +
                "    module.Nom AS 'ModuleNom',\n" +
                "    USER.nom AS 'EnseignantNom',\n" +
                "    USER.prenom AS 'EnseignantPrenom',\n" +
                "    classegenerique.id_filiere AS 'FiliereID',\n" +
                "    filiere.code AS 'FiliereCode',\n" +
                "    filiere.nom AS 'FiliereNom',\n" +
                "    etudiant.id_user AS 'EtudiantUserID'\n" +
                "FROM\n" +
                "    seance,\n" +
                "    seancegenerique,\n" +
                "    matiere,\n" +
                "    module,\n" +
                "    enseignant,\n" +
                "    classegenerique,\n" +
                "    classe,\n" +
                "    filiere,\n" +
                "    etudiant,\n" +
                "    USER\n" +
                "WHERE\n" +
                "    seance.id_seancegenerique = seancegenerique.id_seancegenerique \n" +
                "    AND seancegenerique.id_classe = classe.id_classe \n" +
                "    AND seancegenerique.id_module = module.id_module \n" +
                "    AND seancegenerique.id_matiere = matiere.id_matiere \n" +
                "    AND classe.id_classegenerique = classegenerique.id_classegenerique \n" +
                "    AND matiere.id_module = module.id_module \n" +
                "    AND classegenerique.id_filiere = filiere.id_filiere \n" +
                "    AND filiere.id_filiere = etudiant.id_filiere \n" +
                "    AND enseignant.id_user = USER.id_user \n" +
                "    AND etudiant.id_etudiant = ?;");
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                seance.add(new seance(rs.getInt("SeanceID") , new seancegenerique( 0 , new module(rs.getInt("ModuleID"), rs.getString("ModuleNom")), new matiere(rs.getInt("MatiereID"), new module(rs.getInt("ModuleID"), rs.getString("ModuleNom")), rs.getString("MatiereNom")),new enseignant(0, new user(0, rs.getString("EnseignantNom"), rs.getString("EnseignantPrenom"), "", "", "", "", "", "", ""), null, null),new classe(0, new classegenerique(0, null, new filiere(0, rs.getString("FiliereCode"), rs.getString("FiliereNom")), null, null), ""),rs.getString("Jour"), rs.getString("HeureDebut"), rs.getString("HeureFin"), ""), null , "", ""));
            }
            return seance;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<seance> getSessionByTeacher(int id){
        ArrayList<seance> seance = new ArrayList<seance>();
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT\n" +
                "  `seance`.`id_seance` AS `seanceID`,\n" +
                "  `seance`.`id_seancegenerique` AS `seanceSeancegeneriqueID`,\n" +
                "  `seance`.`date` AS `seanceDate`,\n" +
                "  `seance`.`etat` AS `seanceEtat`,\n" +
                "  `seance`.`observation` AS `seanceObservation`,\n" +
                "  `seancegenerique`.`id_seancegenerique` AS `seancegeneriqueID`,\n" +
                "  `seancegenerique`.`id_module` AS `seancegeneriqueModuleID`,\n" +
                "  `seancegenerique`.`id_matiere` AS `seancegeneriqueMatiereID`,\n" +
                "  `seancegenerique`.`id_enseignant` AS `seancegeneriqueEnseignantID`,\n" +
                "  `seancegenerique`.`id_classe` AS `seancegeneriqueClasseID`,\n" +
                "  `seancegenerique`.`jour` AS `seancegeneriqueJour`,\n" +
                "  `seancegenerique`.`heuredeb` AS `seancegeneriqueHeureDebut`,\n" +
                "  `seancegenerique`.`heurefin` AS `seancegeneriqueHeureFin`,\n" +
                "  `seancegenerique`.`observation` AS `seancegeneriqueObservation`,\n" +
                "  `matiere`.`id_matiere`,\n" +
                "  `matiere`.`id_module` AS `matiereModuleID`,\n" +
                "  `matiere`.`Nom` AS `matiereNom`,\n" +
                "  `module`.`id_module`,\n" +
                "  `module`.`Nom` AS `moduleNom`,\n" +
                "  `enseignant`.`id_enseignant`,\n" +
                "  `enseignant`.`id_user`,\n" +
                "  `enseignant`.`id_cycle` AS `enseignantCycleID`,\n" +
                "  `enseignant`.`id_specialite` AS `enseignantSpecialiteID`,\n" +
                "  `cycle`.`id_cycle`,\n" +
                "  `cycle`.`code` AS `cycleCode`,\n" +
                "  `cycle`.`nom` AS `cycleNom`,\n" +
                "  `specialite`.`id_specialite`,\n" +
                "  `specialite`.`nom` AS `specialiteNom`,\n" +
                "  `classe`.`id_classe`,\n" +
                "  `classe`.`id_classegenerique` AS `classeClassegeneriqueID`,\n" +
                "  `classe`.`annee_scolaire` AS `classeAnneeScolaire`,\n" +
                "  `classegenerique`.`id_classegenerique`,\n" +
                "  `classegenerique`.`id_niveau` AS `classegeneriqueNiveauID`,\n" +
                "  `classegenerique`.`id_filiere` AS `classegeneriqueFiliereID`,\n" +
                "  `classegenerique`.`id_cycle` AS `classegeneriqueCycleID`,\n" +
                "  `classegenerique`.`discription` AS `classegeneriqueDescription`,\n" +
                "  `niveau`.`id_niveau`,\n" +
                "  `niveau`.`code` AS `niveauCode`,\n" +
                "  `niveau`.`nom` AS `niveauNom`,\n" +
                "  `filiere`.`id_filiere`,\n" +
                "  `filiere`.`code` AS `filiereCode`,\n" +
                "  `filiere`.`nom` AS `filiereNom`\n" +
                "FROM `seance` \n" +
                "  LEFT JOIN `seancegenerique` ON `seance`.`id_seancegenerique` = `seancegenerique`.`id_seancegenerique` \n" +
                "  LEFT JOIN `matiere` ON `seancegenerique`.`id_matiere` = `matiere`.`id_matiere` \n" +
                "  LEFT JOIN `module` ON `matiere`.`id_module` = `module`.`id_module` \n" +
                "  LEFT JOIN `enseignant` ON `seancegenerique`.`id_enseignant` = `enseignant`.`id_enseignant` \n" +
                "  LEFT JOIN `cycle` ON `enseignant`.`id_cycle` = `cycle`.`id_cycle` \n" +
                "  LEFT JOIN `specialite` ON `enseignant`.`id_specialite` = `specialite`.`id_specialite` \n" +
                "  LEFT JOIN `classe` ON `seancegenerique`.`id_classe` = `classe`.`id_classe` \n" +
                "  LEFT JOIN `classegenerique` ON `classe`.`id_classegenerique` = `classegenerique`.`id_classegenerique` \n" +
                "  LEFT JOIN `niveau` ON `classegenerique`.`id_niveau` = `niveau`.`id_niveau` \n" +
                "  LEFT JOIN `filiere` ON `classegenerique`.`id_filiere` = `filiere`.`id_filiere`\n" +
                "  WHERE enseignant.id_user=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                seance.add(new seance(rs.getInt("seanceID"),new seancegenerique(rs.getInt("seanceSeancegeneriqueID"), new module(rs.getInt("id_module"),rs.getString("moduleNom")), new matiere(rs.getInt("id_matiere"),new module(rs.getInt("id_module"),rs.getString("moduleNom")) , rs.getString("matiereNom")), new enseignant(rs.getInt("seancegeneriqueEnseignantID"), null, new cycle(rs.getInt("id_cycle"), rs.getString("cycleCode"), rs.getString("cycleNom")), new specialite(rs.getInt("id_specialite"), rs.getString("specialiteNom"))), new classe(rs.getInt("seancegeneriqueClasseID"), new classegenerique(rs.getInt("classeClassegeneriqueID"), new niveau(rs.getInt("classegeneriqueNiveauID"), rs.getString("niveauNom"), rs.getString("niveauCode")), new filiere(rs.getInt("classegeneriqueFiliereID"), rs.getString("filiereCode"), rs.getString("filiereNom")), new cycle(rs.getInt("id_cycle"), rs.getString("cycleCode"), rs.getString("cycleNom")), rs.getString("classegeneriqueDescription")), rs.getString("classeAnneeScolaire")), rs.getString("seancegeneriqueJour"), rs.getString("seancegeneriqueHeureDebut"), rs.getString("seancegeneriqueHeureFin"), rs.getString("seancegeneriqueObservation")),rs.getDate("seanceDate"), rs.getString("seanceEtat"),rs.getString("seanceObservation")));
            }
            return seance;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<seance> getSessionByClass(int id_Classe){
        ArrayList<seance> seance = new ArrayList<>();
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT\n" +
            "  `seance`.`id_seance` AS `seanceID`,\n" +
            "  `seance`.`id_seancegenerique` AS `seanceSeancegeneriqueID`,\n" +
            "  `seance`.`date` AS `seanceDate`,\n" +
            "  `seance`.`etat` AS `seanceEtat`,\n" +
            "  `seance`.`observation` AS `seanceObservation`,\n" +
            "  `seancegenerique`.`id_seancegenerique` AS `seancegeneriqueID`,\n" +
            "  `seancegenerique`.`id_module` AS `seancegeneriqueModuleID`,\n" +
            "  `seancegenerique`.`id_matiere` AS `seancegeneriqueMatiereID`,\n" +
            "  `seancegenerique`.`id_enseignant` AS `seancegeneriqueEnseignantID`,\n" +
            "  `seancegenerique`.`id_classe` AS `seancegeneriqueClasseID`,\n" +
            "  `seancegenerique`.`jour` AS `seancegeneriqueJour`,\n" +
            "  `seancegenerique`.`heuredeb` AS `seancegeneriqueHeureDebut`,\n" +
            "  `seancegenerique`.`heurefin` AS `seancegeneriqueHeureFin`,\n" +
            "  `seancegenerique`.`observation` AS `seancegeneriqueObservation`,\n" +
            "  `matiere`.`id_matiere`,\n" +
            "  `matiere`.`id_module` AS `matiereModuleID`,\n" +
            "  `matiere`.`Nom` AS `matiereNom`,\n" +
            "  `module`.`id_module`,\n" +
            "  `module`.`Nom` AS `moduleNom`,\n" +
            "  `enseignant`.`id_enseignant`,\n" +
            "  `enseignant`.`id_user`,\n" +
            "  `enseignant`.`id_cycle` AS `enseignantCycleID`,\n" +
            "  `enseignant`.`id_specialite` AS `enseignantSpecialiteID`,\n" +
            "  `cycle`.`id_cycle`,\n" +
            "  `cycle`.`code` AS `cycleCode`,\n" +
            "  `cycle`.`nom` AS `cycleNom`,\n" +
            "  `specialite`.`id_specialite`,\n" +
            "  `specialite`.`nom` AS `specialiteNom`,\n" +
            "  `classe`.`id_classe`,\n" +
            "  `classe`.`id_classegenerique` AS `classeClassegeneriqueID`,\n" +
            "  `classe`.`annee_scolaire` AS `classeAnneeScolaire`,\n" +
            "  `classegenerique`.`id_classegenerique`,\n" +
            "  `classegenerique`.`id_niveau` AS `classegeneriqueNiveauID`,\n" +
            "  `classegenerique`.`id_filiere` AS `classegeneriqueFiliereID`,\n" +
            "  `classegenerique`.`id_cycle` AS `classegeneriqueCycleID`,\n" +
            "  `classegenerique`.`discription` AS `classegeneriqueDescription`,\n" +
            "  `niveau`.`id_niveau`,\n" +
            "  `niveau`.`code` AS `niveauCode`,\n" +
            "  `niveau`.`nom` AS `niveauNom`,\n" +
            "  `filiere`.`id_filiere`,\n" +
            "  `filiere`.`code` AS `filiereCode`,\n" +
            "  `filiere`.`nom` AS `filiereNom`\n" +
            "FROM `seance`\n" +
            "  LEFT JOIN `seancegenerique` ON `seance`.`id_seancegenerique` = `seancegenerique`.`id_seancegenerique`\n" +
            "  LEFT JOIN `matiere` ON `seancegenerique`.`id_matiere` = `matiere`.`id_matiere`\n" +
            "  LEFT JOIN `module` ON `matiere`.`id_module` = `module`.`id_module`\n" +
            "  LEFT JOIN `enseignant` ON `seancegenerique`.`id_enseignant` = `enseignant`.`id_enseignant`\n" +
            "  LEFT JOIN `cycle` ON `enseignant`.`id_cycle` = `cycle`.`id_cycle`\n" +
            "  LEFT JOIN `specialite` ON `enseignant`.`id_specialite` = `specialite`.`id_specialite`\n" +
            "  LEFT JOIN `classe` ON `seancegenerique`.`id_classe` = `classe`.`id_classe`\n" +
            "  LEFT JOIN `classegenerique` ON `classe`.`id_classegenerique` = `classegenerique`.`id_classegenerique`\n" +
            "  LEFT JOIN `niveau` ON `classegenerique`.`id_niveau` = `niveau`.`id_niveau`\n" +
            "  LEFT JOIN `filiere` ON `classegenerique`.`id_filiere` = `filiere`.`id_filiere`\n" +
            "WHERE classe.id_classe = ?");
            ps.setInt(1, id_Classe);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                seance.add(new seance(rs.getInt("seanceID"),new seancegenerique(rs.getInt("seanceSeancegeneriqueID"), new module(rs.getInt("id_module"),rs.getString("moduleNom")), new matiere(rs.getInt("id_matiere"),new module(rs.getInt("id_module"),rs.getString("moduleNom")) , rs.getString("matiereNom")), new enseignant(rs.getInt("seancegeneriqueEnseignantID"), null, new cycle(rs.getInt("id_cycle"), rs.getString("cycleCode"), rs.getString("cycleNom")), new specialite(rs.getInt("id_specialite"), rs.getString("specialiteNom"))), new classe(rs.getInt("seancegeneriqueClasseID"), new classegenerique(rs.getInt("classeClassegeneriqueID"), new niveau(rs.getInt("classegeneriqueNiveauID"), rs.getString("niveauNom"), rs.getString("niveauCode")), new filiere(rs.getInt("classegeneriqueFiliereID"), rs.getString("filiereCode"), rs.getString("filiereNom")), new cycle(rs.getInt("id_cycle"), rs.getString("cycleCode"), rs.getString("cycleNom")), rs.getString("classegeneriqueDescription")), rs.getString("classeAnneeScolaire")), rs.getString("seancegeneriqueJour"), rs.getString("seancegeneriqueHeureDebut"), rs.getString("seancegeneriqueHeureFin"), rs.getString("seancegeneriqueObservation")),rs.getDate("seanceDate"), rs.getString("seanceEtat"),rs.getString("seanceObservation")));
            }
            return seance;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main (String []args){
        SeanceController st = new SeanceController();
        System.out.println(st.getSessionByClass(1));
        
    }
}
