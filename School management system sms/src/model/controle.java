/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author oussa
 */
public class controle {
    private int id_controle;
    private String nom;
    private module module;
    private matiere matiere;
    private int duree;
    private classe classe;
    private enseignant enseignant;
    private String etat;
    private String observation;

    public controle(int id_controle, String nom, module module, matiere matiere, int duree, classe classe, enseignant enseignant, String etat, String observation) {
        this.id_controle = id_controle;
        this.nom = nom;
        this.module = module;
        this.matiere = matiere;
        this.duree = duree;
        this.classe = classe;
        this.enseignant = enseignant;
        this.etat = etat;
        this.observation = observation;
    }

    public controle(int id_controle) {
        this.id_controle = id_controle;
    }
    
    

    public int getId_controle() {
        return id_controle;
    }

    public void setId_controle(int id_controle) {
        this.id_controle = id_controle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public module getModule() {
        return module;
    }

    public void setModule(module module) {
        this.module = module;
    }

    public matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(matiere matiere) {
        this.matiere = matiere;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public classe getClasse() {
        return classe;
    }

    public void setClasse(classe classe) {
        this.classe = classe;
    }

    public enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    @Override
    public String toString() {
        return "controle{" + "id_controle=" + id_controle + ", nom=" + nom + ", module=" + module + ", matiere=" + matiere + ", duree=" + duree + ", classe=" + classe + ", enseignant=" + enseignant + ", etat=" + etat + ", observation=" + observation + '}';
    }
    
    
}
