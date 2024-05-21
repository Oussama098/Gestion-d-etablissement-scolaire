/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author oussa
 */
public class seancegenerique {
    private int id_seancegenerique;
    private module module;
    private matiere matiere;
    private enseignant enseignant;
    private classe classe;
    private String jour , datedeb , datefin , observation;

    public seancegenerique(int id_seancegenerique, module module, matiere matiere, enseignant enseignant, classe classe, String jour, String datedeb, String datefin, String observation) {
        this.id_seancegenerique = id_seancegenerique;
        this.module = module;
        this.matiere = matiere;
        this.enseignant = enseignant;
        this.classe = classe;
        this.jour = jour;
        this.datedeb = datedeb;
        this.datefin = datefin;
        this.observation = observation;
    }
    
    public seancegenerique (enseignant enseignant , classe classe){
        this.enseignant = enseignant;
        this.classe = classe;
    }
    
    public seancegenerique(int id_seancegenerique){
        this.id_seancegenerique=id_seancegenerique;
    }

    public int getId_seancegenerique() {
        return id_seancegenerique;
    }

    public void setId_seancegenerique(int id_seancegenerique) {
        this.id_seancegenerique = id_seancegenerique;
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

    public enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public classe getClasse() {
        return classe;
    }

    public void setClasse(classe classe) {
        this.classe = classe;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getDatedeb() {
        return datedeb;
    }

    public void setDatedeb(String datedeb) {
        this.datedeb = datedeb;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    @Override
    public String toString() {
        return "seancegenerique{" + "id_seancegenerique=" + id_seancegenerique + ", module=" + module + ", matiere=" + matiere + ", enseignant=" + enseignant + ", classe=" + classe + ", jour=" + jour + ", datedeb=" + datedeb + ", datefin=" + datefin + ", observation=" + observation + '}';
    }
    
    
}
