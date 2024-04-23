/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author oussa
 */
public class filiere {
    private int id_filiere;
    private String code ;
    private String Nom;

    public filiere(int id_filiere) {
        this.id_filiere = id_filiere;
    }
    
    public filiere(int id_filiere, String code, String Nom) {
        this.id_filiere = id_filiere;
        this.code = code;
        this.Nom = Nom;
    }

    public filiere(String code) {
        this.code = code;
    }

    
    public int getId_filiere() {
        return id_filiere;
    }

    public void setId_filiere(int id_filiere) {
        this.id_filiere = id_filiere;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    @Override
    public String toString() {
        return "filiere{" + "id_filiere=" + id_filiere + ", code=" + code + ", Nom=" + Nom + '}';
    }
    
}
