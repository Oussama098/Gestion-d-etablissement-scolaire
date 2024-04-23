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
public class notes {
    private int id_note;
    private etudiant etudiant;
    private float note;
    private Date date;
    private String controle;

    public notes(int id_note, etudiant etudiant, float note, Date date, String controle) {
        this.id_note = id_note;
        this.etudiant = etudiant;
        this.note = note;
        this.date = date;
        this.controle = controle;
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

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getControle() {
        return controle;
    }

    public void setControle(String controle) {
        this.controle = controle;
    }

    @Override
    public String toString() {
        return "notes{" + "id_note=" + id_note + ", etudiant=" + etudiant + ", note=" + note + ", date=" + date + ", controle=" + controle + '}';
    }
    
    
    
}
