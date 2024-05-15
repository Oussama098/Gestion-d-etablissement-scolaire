/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javafx.scene.control.CheckBox;

/**
 *
 * @author oussa
 */
public class absenceetudiant {
    private int id;
    private etudiant etudiant;
    private seance seance;
    private boolean justification;
    private String motif;
    private docjustifabsetudiant docJustifAbsEtudiant;
    private int NbrAbs;
    private CheckBox select;

    public absenceetudiant(int id, etudiant etudiant, seance seance, boolean justification, String motif, docjustifabsetudiant docJustifAbsEtudiantID) {
        this.id = id;
        this.etudiant = etudiant;
        this.seance = seance;
        this.justification = justification;
        this.motif = motif;
        this.docJustifAbsEtudiant = docJustifAbsEtudiantID;
        this.select= new CheckBox();
    }
    
    public absenceetudiant(int id, etudiant etudiant, seance seance, boolean justification, String motif, docjustifabsetudiant docJustifAbsEtudiantID , int NbrAbs) {
        this.id = id;
        this.etudiant = etudiant;
        this.seance = seance;
        this.justification = justification;
        this.motif = motif;
        this.docJustifAbsEtudiant = docJustifAbsEtudiantID;
        this.NbrAbs=NbrAbs;
        this.select= new CheckBox();
    }

    public int getNbrAbs() {
        return NbrAbs;
    }

    public CheckBox getSelect() {
        return select;
    }

    public void setSelect(CheckBox select) {
        this.select = select;
    }
    
    public absenceetudiant( etudiant etudiant, seance seance, boolean justification, String motif) {
        this.etudiant = etudiant;
        this.seance = seance;
        this.justification = justification;
        this.motif = motif;
    }

    public int getId_etudiant() {
        return etudiant.getId_etudiant();
    }

    
    public String getNomClasse(){
        return etudiant.getClasse().getClassegenerique().getNiveau().getCode() +" "+etudiant.getClasse().getClassegenerique().getFiliere().getCode()+" "+etudiant.getClasse().getClassegenerique().getCycle().getCode();
    }
    public String getPrenom(){
        return etudiant.getUser().getPrenom();
    }
    
    public String getNom(){
        return etudiant.getUser().getNom();
    }
    
    public String getNomComplet(){
        return etudiant.getNomComplet();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public seance getSeance() {
        return seance;
    }

    public void setSeance(seance seance) {
        this.seance = seance;
    }

    

    public boolean isJustification() {
        return justification;
    }

    public void setJustification(boolean justification) {
        this.justification = justification;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public docjustifabsetudiant getDocJustifAbsEtudiant() {
        return docJustifAbsEtudiant;
    }

    public void setDocJustifAbsEtudiant(docjustifabsetudiant docJustifAbsEtudiant) {
        this.docJustifAbsEtudiant = docJustifAbsEtudiant;
    }

    @Override
    public String toString() {
        return "absenceetudiant{" + "id=" + id + ", etudiant=" + etudiant + ", seance=" + seance + ", justification=" + justification + ", motif=" + motif + ", docJustifAbsEtudiant=" + docJustifAbsEtudiant + ", NbrAbs=" + NbrAbs + '}';
    }

    
}


