/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author oussa
 */
public class classe {
    private int id_classe;
    private classegenerique classegenerique;
    private String anneescolaire;

    public classe(){
        
    }

    public classe(int id_classe) {
        this.id_classe = id_classe;
    }
    
    
    public classe(int id_classe, classegenerique classegenerique, String anneescolaire) {
        this.id_classe = id_classe;
        this.classegenerique = classegenerique;
        this.anneescolaire = anneescolaire;
    }

    public int getId_classe() {
        return id_classe;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    public classegenerique getClassegenerique() {
        return classegenerique;
    }

    public void setClassegenerique(classegenerique classegenerique) {
        this.classegenerique = classegenerique;
    }

    public String getAnneescolaire() {
        return anneescolaire;
    }

    public void setAnneescolaire(String anneescolaire) {
        this.anneescolaire = anneescolaire;
    }

    @Override
    public String toString() {
        return "classe{" + "id_classe=" + id_classe + ", classegenerique=" + classegenerique + ", anneescolaire=" + anneescolaire + '}';
    }

    
    
    
}
