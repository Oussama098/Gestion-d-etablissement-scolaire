/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.authentification;
import model.user;

/**
 *
 * @author oussa
 */
public class cnxDB {
    private static Connection con =null;
    private static cnxDB ct=null;

    public cnxDB() {
        try {
        con=DriverManager.getConnection("jdbc:mysql://localhost/pfe_2024","root","");        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public static Connection getCon(){
        if(ct==null)
            ct = new cnxDB();
        return con;
    }
    
    public authentification UserCnx(String login , String pwd){
        authentification auto= null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT `authentification`.`login`, `authentification`.`password`, `authentification`.`id_user`, `user`.`id_user` AS `userID`, `user`.`nom` AS `userNom`, `user`.`prenom` AS `userPrenom`,`user`.`email` AS `userEmail`, `user`.`role` AS `userRole`, `user`.`datenais` AS `userDatenais`, `user`.`lieunais` AS `userLieunais`, `user`.`Telephone` AS `userTele`, `user`.`sexe` AS `userSexe`, `user`.`photo` AS `userPhoto`\n" +
            "FROM `authentification` \n" +
            "	LEFT JOIN `user` ON `authentification`.`id_user` = `user`.`id_user` "
            + " where login= ? and password=?");
            ps.setString(1, login);
            ps.setString(2, pwd);
            ResultSet rs =ps.executeQuery();
            if(rs.next()){
               auto = new authentification(rs.getString("login"), rs.getString("password"), new user(rs.getInt("userID"),rs.getString("userNom"),rs.getString("userPrenom"), rs.getString("userEmail") , rs.getString("userDatenais"), rs.getString("userLieunais"), rs.getString("userTele"), rs.getString("userSexe"), rs.getString("userPhoto"), rs.getString("userRole")));
            }
            return auto;
        } catch (Exception e) {
           
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
    }
    
    public static void main(String[] args){
        System.out.println(cnxDB.getCon());
        cnxDB cn = new cnxDB();
        System.out.println(cn.UserCnx("@oussamaelbakri", "oussama").toString());

}
}
