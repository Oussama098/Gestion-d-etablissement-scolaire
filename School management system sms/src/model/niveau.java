/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author oussa
 */
public class niveau {
    private int id_niveau;
    private String nom , code;

    public niveau(int id_niveau, String nom, String code) {
        this.id_niveau = id_niveau;
        this.nom = nom;
        this.code = code;
    }

    public int getId_niveau() {
        return id_niveau;
    }

    public void setId_niveau(int id_niveau) {
        this.id_niveau = id_niveau;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "niveau{" + "id_niveau=" + id_niveau + ", nom=" + nom + ", code=" + code + '}';
    }
    
    
}
