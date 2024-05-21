/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import com.mysql.cj.protocol.Resultset;
import model.seance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author oussa
 */
public class SeanceController {
    public ArrayList<seance> getSessionDataByStudent(int id){
        ArrayList<seance> List= new ArrayList<seance>();
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT \n" +
            "    s.id_seance AS seance_id_seance,\n" +
            "    s.id_seancegenerique AS seance_id_seancegenerique,\n" +
            "    s.date AS seance_date,\n" +
            "    s.etat AS seance_etat,\n" +
            "    s.observation AS seance_observation,\n" +
            "    \n" +
            "    sg.id_seancegenerique AS seancegenerique_id_seancegenerique,\n" +
            "    sg.id_module AS seancegenerique_id_module,\n" +
            "    sg.id_matiere AS seancegenerique_id_matiere,\n" +
            "    sg.id_enseignant AS seancegenerique_id_enseignant,\n" +
            "    sg.id_classe AS seancegenerique_id_classe,\n" +
            "    sg.jour AS seancegenerique_jour,\n" +
            "    sg.heuredeb AS seancegenerique_heuredeb,\n" +
            "    sg.heurefin AS seancegenerique_heurefin,\n" +
            "    sg.observation AS seancegenerique_observation,\n" +
            "    \n" +
            "    c.id_classe AS classe_id_classe,\n" +
            "    c.id_classegenerique AS classe_id_classegenerique,\n" +
            "    c.annee_scolaire AS classe_annee_scolaire,\n" +
            "    \n" +
            "    cg.id_classegenerique AS classegenerique_id_classegenerique,\n" +
            "    cg.id_niveau AS classegenerique_id_niveau,\n" +
            "    cg.id_filiere AS classegenerique_id_filiere,\n" +
            "    cg.id_cycle AS classegenerique_id_cycle,\n" +
            "    cg.discription AS classegenerique_discription,\n" +
            "    \n" +
            "    n.id_niveau AS niveau_id_niveau,\n" +
            "    n.code AS niveau_code,\n" +
            "    n.nom AS niveau_nom,\n" +
            "    \n" +
            "    cy.id_cycle AS cycle_id_cycle,\n" +
            "    cy.code AS cycle_code,\n" +
            "    cy.nom AS cycle_nom,\n" +
            "    \n" +
            "    f.id_filiere AS filiere_id_filiere,\n" +
            "    f.code AS filiere_code,\n" +
            "    f.nom AS filiere_nom,\n" +
            "\n" +
            "    e.id_etudiant AS etudiant_id_etudiant,\n" +
            "    e.id_user AS etudiant_id_user,\n" +
            "    e.id_classe AS etudiant_id_classe,\n" +
            "    e.id_filiere AS etudiant_id_filiere,\n" +
            "\n" +
            "    u.id_user AS user_id_user,\n" +
            "    u.nom AS user_nom,\n" +
            "    u.prenom AS user_prenom,\n" +
            "    u.email AS user_email,\n" +
            "    u.role AS user_role,\n" +
            "    u.datenais AS user_datenais,\n" +
            "    u.lieunais AS user_lieunais,\n" +
            "    u.Telephone AS user_telephone,\n" +
            "    u.sexe AS user_sexe,\n" +
            "    u.photo AS user_photo,\n" +
            "\n" +
            "    m.id_matiere AS matiere_id_matiere,\n" +
            "    m.id_module AS matiere_id_module,\n" +
            "    m.Nom AS matiere_nom,\n" +
            "\n" +
            "    mo.id_module AS module_id_module,\n" +
            "    mo.Nom AS module_nom\n" +
            "FROM \n" +
            "    seance s\n" +
            "JOIN \n" +
            "    seancegenerique sg ON s.id_seancegenerique = sg.id_seancegenerique\n" +
            "JOIN \n" +
            "    classe c ON sg.id_classe = c.id_classe\n" +
            "JOIN \n" +
            "    classegenerique cg ON c.id_classegenerique = cg.id_classegenerique\n" +
            "JOIN \n" +
            "    niveau n ON cg.id_niveau = n.id_niveau\n" +
            "JOIN \n" +
            "    cycle cy ON cg.id_cycle = cy.id_cycle\n" +
            "JOIN \n" +
            "    filiere f ON cg.id_filiere = f.id_filiere\n" +
            "JOIN \n" +
            "    etudiant e ON c.id_classe = e.id_classe\n" +
            "JOIN \n" +
            "    user u ON e.id_user = u.id_user\n" +
            "JOIN \n" +
            "    matiere m ON sg.id_matiere = m.id_matiere\n" +
            "JOIN \n" +
            "    module mo ON m.id_module = mo.id_module\n" +
            "Where e.id_etudiant=?");
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                seance seance = new seance(
                    rs.getInt("seance_id_seance"),
                    new seancegenerique(
                        rs.getInt("seancegenerique_id_seancegenerique"),
                        new module(
                            rs.getInt("seancegenerique_id_module"),
                            rs.getString("module_nom")
                        ),
                        new matiere(
                            rs.getInt("seancegenerique_id_matiere"),
                            new module(
                                rs.getInt("seancegenerique_id_module"),
                                rs.getString("module_nom")
                            ),
                            rs.getString("matiere_nom")
                        ),
                        new enseignant(
                            rs.getInt("seancegenerique_id_enseignant"),
                            null,
                            null, null // Replace with appropriate objects if needed
                        ),
                        new classe(
                            rs.getInt("classe_id_classe"),
                            new classegenerique(
                                rs.getInt("classegenerique_id_classegenerique"),
                                new niveau(
                                    rs.getInt("niveau_id_niveau"),
                                    rs.getString("niveau_code"),
                                    rs.getString("niveau_nom")
                                ),
                                new filiere(
                                    rs.getInt("filiere_id_filiere"),
                                    rs.getString("filiere_code"),
                                    rs.getString("filiere_nom")
                                ),
                                new cycle(
                                    rs.getInt("cycle_id_cycle"),
                                    rs.getString("cycle_code"),
                                    rs.getString("cycle_nom")
                                ),
                                rs.getString("classegenerique_discription")
                            ),
                            rs.getString("classe_annee_scolaire")
                        ),
                        rs.getString("seancegenerique_jour"),
                        rs.getString("seancegenerique_heuredeb"),
                        rs.getString("seancegenerique_heurefin"),
                        rs.getString("seancegenerique_observation")
                    ),
                    rs.getDate("seance_date"),
                    rs.getString("seance_etat"),
                    rs.getString("seance_observation")
                );
                
                List.add(seance);
            }
            return List;
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
    
    
    public ArrayList<seancegenerique> getNotSessionByTeacher(int id){
        ArrayList<seancegenerique> seance = new ArrayList<seancegenerique>();
        try {
            PreparedStatement ps = cnxDB.getCon().prepareStatement("SELECT DISTINCT\n" +
                "  `seancegenerique`.`id_seancegenerique` AS `seancegeneriqueID`,\n" +
                "  `seancegenerique`.`id_module` AS `seancegeneriqueModuleID`,\n" +
                "  `seancegenerique`.`id_matiere` AS `seancegeneriqueMatiereID`,\n" +
                "  `seancegenerique`.`id_enseignant` AS `seancegeneriqueEnseignantID`,\n" +
                "  `seancegenerique`.`id_classe` AS `seancegeneriqueClasseID`,\n" +
                "  `seancegenerique`.`jour` AS `seancegeneriqueJour`,\n" +
                "  `seancegenerique`.`heuredeb` AS `seancegeneriqueHeureDebut`,\n" +
                "  `seancegenerique`.`heurefin` AS `seancegeneriqueHeureFin`,\n" +
                "  `seancegenerique`.`observation` AS `seancegeneriqueObservation`,\n" +
                "  `classe`.`id_classe`,\n" +
                "  `classe`.`id_classegenerique` AS `classeClassegeneriqueID`,\n" +
                "  `classe`.`annee_scolaire` AS `classeAnneeScolaire`,\n" +
                "  `classegenerique`.`id_classegenerique`,\n" +
                "  `classegenerique`.`id_niveau` AS `classegeneriqueNiveauID`,\n" +
                "  `classegenerique`.`id_filiere` AS `classegeneriqueFiliereID`,\n" +
                "  `classegenerique`.`id_cycle` AS `classegeneriqueCycleID`,\n" +
                "  `classegenerique`.`discription` AS `classegeneriqueDescription`,\n" +
                "  `niveau`.`id_niveau`,\n" +
                "  `cycle`.`id_cycle`,\n" +
                "  `cycle`.`code` AS `cycleCode`,\n" +
                "  `cycle`.`nom` AS `cycleNom`,\n" +
                "  `niveau`.`code` AS `niveauCode`,\n" +
                "  `niveau`.`nom` AS `niveauNom`,\n" +
                "  `filiere`.`id_filiere`,\n" +
                "  `filiere`.`code` AS `filiereCode`,\n" +
                "  `filiere`.`nom` AS `filiereNom`\n" +
            "FROM\n" +
            "    seancegenerique\n" +
            "\n" +
            "RIGHT JOIN classe on classe.id_classe = seancegenerique.id_classe\n" +
            "left join classegenerique on classe.id_classegenerique = classegenerique.id_classegenerique\n" +
            "LEFT JOIN enseignant on seancegenerique.id_enseignant = enseignant.id_enseignant\n" +
            "LEFT JOIN `cycle` ON `classegenerique`.`id_cycle` = `cycle`.`id_cycle` \n" +
            "LEFT JOIN `niveau` ON `classegenerique`.`id_niveau` = `niveau`.`id_niveau` \n" +
            "LEFT JOIN `filiere` ON `classegenerique`.`id_filiere` = `filiere`.`id_filiere`\n" +
            "WHERE enseignant.id_user IS NULL OR enseignant.id_user != ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                seance.add(new seancegenerique(rs.getInt("seancegeneriqueID"), null, null ,null , new classe(rs.getInt("id_classe"), new classegenerique(rs.getInt("classeClassegeneriqueID"), new niveau(rs.getInt("classegeneriqueNiveauID"), rs.getString("niveauNom"), rs.getString("niveauCode")), new filiere(rs.getInt("classegeneriqueFiliereID"), rs.getString("filiereCode"), rs.getString("filiereNom")), new cycle(rs.getInt("id_cycle"), rs.getString("cycleCode"), rs.getString("cycleNom")), rs.getString("classegeneriqueDescription")), rs.getString("classeAnneeScolaire")), rs.getString("seancegeneriqueJour"), rs.getString("seancegeneriqueHeureDebut"), rs.getString("seancegeneriqueHeureFin"), rs.getString("seancegeneriqueObservation")));
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
    
    public void insert(seance sc) throws SQLException{
        PreparedStatement ps = cnxDB.getCon().prepareStatement("INSERT INTO `seance`(`id_seancegenerique`) VALUES (?)");
        ps.setInt(1, sc.getSeancegenerique().getId_seancegenerique());
        ps.executeUpdate();
    }
        
    public static void main (String []args){
        SeanceController st = new SeanceController();
        System.out.println(st.getNotSessionByTeacher(3));
        
    }
}
