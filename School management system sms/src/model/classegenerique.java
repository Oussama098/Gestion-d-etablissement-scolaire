/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author oussa
 */
public class classegenerique {
    private int id_classegenerique;
    private niveau niveau;
    private filiere filiere;
    private cycle cycle;
    private String discription;

    public classegenerique(int id_classegenerique, niveau niveau, filiere filiere, cycle cycle, String discription) {
        this.id_classegenerique = id_classegenerique;
        this.niveau = niveau;
        this.filiere = filiere;
        this.cycle = cycle;
        this.discription = discription;
    }

    public int getId_classegenerique() {
        return id_classegenerique;
    }

    public void setId_classegenerique(int id_classegenerique) {
        this.id_classegenerique = id_classegenerique;
    }

    public niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(niveau niveau) {
        this.niveau = niveau;
    }

    public filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(filiere filiere) {
        this.filiere = filiere;
    }

    public cycle getCycle() {
        return cycle;
    }

    public void setCycle(cycle cycle) {
        this.cycle = cycle;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    @Override
    public String toString() {
        return "classegenerique{" + "id_classegenerique=" + id_classegenerique + ", niveau=" + niveau + ", filiere=" + filiere + ", cycle=" + cycle + ", discription=" + discription + '}';
    }
    
    
}
