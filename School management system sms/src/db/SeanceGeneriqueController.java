/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;
import model.*;
import java.sql.*;
/**
 *
 * @author oussa
 */
public class SeanceGeneriqueController {
    public int insert(seancegenerique sg) throws SQLException{
            PreparedStatement ps = cnxDB.getCon().prepareStatement("INSERT INTO `seancegenerique`( `id_enseignant`, `id_classe`) VALUES (?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, sg.getEnseignant().getId_enseignant());
            ps.setInt(2, sg.getClasse().getId_classe());
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
    
    public int delete(seancegenerique seancegenerique) throws SQLException{
        PreparedStatement ps = cnxDB.getCon().prepareStatement("DELETE FROM `seancegenerique` WHERE id_classe =? and id_enseignant=?");
        ps.setInt(1, seancegenerique.getClasse().getId_classe());
        ps.setInt(2, seancegenerique.getEnseignant().getId_enseignant());
        return ps.executeUpdate();
    }
        
}
