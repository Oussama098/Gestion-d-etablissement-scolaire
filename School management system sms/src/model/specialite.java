/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author oussa
 */
public class specialite {
    private int id_specialite;
    private String nom;

    public specialite(int id_specialite, String nom) {
        this.id_specialite = id_specialite;
        this.nom = nom;
    }

    public specialite(int id_specialite) {
        this.id_specialite = id_specialite;
    }
    
    

    public int getId_specialite() {
        return id_specialite;
    }

    public void setId_specialite(int id_specialite) {
        this.id_specialite = id_specialite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "specialite{" + "id_specialite=" + id_specialite + ", nom=" + nom + '}';
    }
    
}
