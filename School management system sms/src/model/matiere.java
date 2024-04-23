/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author oussa
 */
public class matiere {
    private int id_matiere;
    private module id_module;
    private String Nom;

    public matiere(int id_matiere, module id_module, String Nom) {
        this.id_matiere = id_matiere;
        this.id_module = id_module;
        this.Nom = Nom;
    }

    public int getId_matiere() {
        return id_matiere;
    }

    public module getId_module() {
        return id_module;
    }

    public String getNom() {
        return Nom;
    }

    public void setId_matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

    public void setId_module(module id_module) {
        this.id_module = id_module;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    @Override
    public String toString() {
        return "matiere{" + "id_matiere=" + id_matiere + ", id_module=" + id_module + ", Nom=" + Nom + '}';
    }
    
    
}
