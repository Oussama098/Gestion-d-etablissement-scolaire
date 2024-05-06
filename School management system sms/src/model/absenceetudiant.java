/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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

    public absenceetudiant(int id, etudiant etudiant, seance seance, boolean justification, String motif, docjustifabsetudiant docJustifAbsEtudiantID) {
        this.id = id;
        this.etudiant = etudiant;
        this.seance = seance;
        this.justification = justification;
        this.motif = motif;
        this.docJustifAbsEtudiant = docJustifAbsEtudiantID;
    }
    
    public absenceetudiant( etudiant etudiant, seance seance, boolean justification, String motif) {
        this.etudiant = etudiant;
        this.seance = seance;
        this.justification = justification;
        this.motif = motif;
    }

    // Getters and setters
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
        return "Absence{" +
                "id=" + id +
                ", etudiant=" + etudiant +
                ", seance=" + seance +
                ", justification=" + justification +
                ", motif='" + motif + '\'' +
                ", docJustifAbsEtudiantID=" + docJustifAbsEtudiant +
                '}';
    }
}


