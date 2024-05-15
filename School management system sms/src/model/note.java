/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author oussa
 */
public class note {
    private int id_note;
    private etudiant etudiant;
    private controle controle;
    private float noteCC;
    private float noteTP;
    private float noteExamen;
    private Date date;
    private String etat;
    private String observation;

    public note(int id_note, etudiant etudiant, controle controle, float noteCC, float noteTP, float noteExamen, Date date, String etat ,String observation) {
        this.id_note = id_note;
        this.etudiant = etudiant;
        this.controle = controle;
        this.noteCC = noteCC;
        this.noteTP = noteTP;
        this.noteExamen = noteExamen;
        this.date = date;
        this.etat= etat;
        this.observation = observation;
    }

    public int getId_note() {
        return id_note;
    }

    public void setId_note(int id_note) {
        this.id_note = id_note;
    }

    public etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public controle getControle() {
        return controle;
    }

    public void setControle(controle controle) {
        this.controle = controle;
    }

    public float getNoteCC() {
        return noteCC;
    }

    public void setNoteCC(float noteCC) {
        this.noteCC = noteCC;
    }

    public float getNoteTP() {
        return noteTP;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setNoteTP(float noteTP) {
        this.noteTP = noteTP;
    }

    public float getNoteExamen() {
        return noteExamen;
    }

    public void setNoteExamen(float noteExamen) {
        this.noteExamen = noteExamen;
    }
    
    public String getMatiere(){
        return controle.getModule().getNom()+" : "+controle.getMatiere().getNom();
    }
    
    public String getModule(){
        return controle.getModule().getNom();
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
    
    public int getId_etudiant(){
        return etudiant.getId_etudiant();
    }
    
    public String getNomComplet(){
        return etudiant.getUser().getNom()+" "+etudiant.getUser().getPrenom();
    }
    
    public String getNomClasse(){
        return etudiant.getNomClasse();
    }

    @Override
    public String toString() {
        return "note{" + "id_note=" + id_note + ", etudiant=" + etudiant + ", controle=" + controle + ", noteCC=" + noteCC + ", noteTP=" + noteTP + ", noteExamen=" + noteExamen + ", date=" + date + ", etat=" + etat + ", observation=" + observation + '}';
    }
    
    

    
    
    
    
}
