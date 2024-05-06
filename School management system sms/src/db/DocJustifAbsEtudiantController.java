/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.*;
import java.time.LocalDate;
import model.*;


/**
 *
 * @author oussa
 */
public class DocJustifAbsEtudiantController {
    public int insert(docjustifabsetudiant doc) throws SQLException{
        PreparedStatement ps = cnxDB.getCon().prepareStatement("INSERT INTO `docjustifabsetudiant`(`Nom`, `DateDepot`, `DateDebut`, `DateFin`, `Emplacement`, `Type`, `DateUpload`, `Observation`) VALUES (?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, doc.getNom());
        ps.setDate(2, doc.getDateDepot());
        ps.setDate(3, doc.getDateDebut());
        ps.setDate(4, doc.getDateFin());
        ps.setString(5, doc.getEmplacement());
        ps.setString(6, doc.getType());
        Date date = java.sql.Date.valueOf(LocalDate.now());
        ps.setDate(7, date);
        ps.setString(8, doc.getObservation());
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
}
