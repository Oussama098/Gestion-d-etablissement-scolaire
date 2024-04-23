/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author oussa
 */
public class enseignant {
    private int id_enseignant;
    private user user;
    private cycle cycle;
    private specialite specialite;

    public enseignant(int id_enseignant, user user, cycle cycle, specialite specialite) {
        this.id_enseignant = id_enseignant;
        this.user = user;
        this.cycle = cycle;
        this.specialite = specialite;
    }

    public enseignant(user user, cycle cycle, specialite specialite) {
        this.user = user;
        this.cycle = cycle;
        this.specialite = specialite;
    }
    
    

    public int getId_enseignant() {
        return id_enseignant;
    }

    public void setId_enseignant(int id_enseignant) {
        this.id_enseignant = id_enseignant;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public cycle getCycle() {
        return cycle;
    }

    public void setCycle(cycle cycle) {
        this.cycle = cycle;
    }

    public specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(specialite specialite) {
        this.specialite = specialite;
    }

    public String getPrenom(){
        return user.getPrenom();
    }
    
    public String getNom(){
        return user.getNom();
    }
    
    public String getDateNais(){
        return user.getDateNais();
    }
    
    public String getLieuNais(){
        return user.getLieuNais();
    }
    
    public String getTele(){
        return user.getTele();
    }
    
    public String getEmail(){
        return user.getEmail();
    }
    
    public String getSexe(){
        return user.getSexe();
    }
    
    public String getNomSpecialite(){
        return specialite.getNom();
    }
    
    public String getNomCycle(){
        return cycle.getNom();
    }
    
    @Override
    public String toString() {
        return "enseignant{" + "id_enseignant=" + id_enseignant + ", user=" + user + ", cycle=" + cycle + ", specialite=" + specialite + '}';
    }

    

    
    
    
}
