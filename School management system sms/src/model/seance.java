package model;

import java.sql.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author oussa
 */
public class seance {
    private int id_seance;
    private seancegenerique seancegenerique;
    private Date date;
    private String etat;
    private String observation;

    public seance(int id_seance, seancegenerique seancegenerique, Date date, String etat, String observation) {
        this.id_seance = id_seance;
        this.seancegenerique = seancegenerique;
        this.date = date;
        this.etat = etat;
        this.observation = observation;
    }

    public seance(int id_seance) {
        this.id_seance = id_seance;
    }
    
    public seance(seancegenerique seancegenerique) {
        this.seancegenerique = seancegenerique;
    }
    
    
    
    

    public int getId_seance() {
        return id_seance;
    }

    public void setId_seance(int id_seance) {
        this.id_seance = id_seance;
    }
    
    public String getNomMatiere(){
        return seancegenerique.getMatiere().getNom();
    }
    
    public String getNomModule(){
        return seancegenerique.getModule().getNom();
    }
    
    public String getJour(){
        return seancegenerique.getJour();
    }
    
    public String getHeureDeb(){
        return seancegenerique.getDatedeb();
    }
    
    public String getHeureFin(){
        return seancegenerique.getDatefin();
    }

    public seancegenerique getSeancegenerique() {
        return seancegenerique;
    }

    public void setSeancegenerique(seancegenerique seancegenerique) {
        this.seancegenerique = seancegenerique;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        return "seance{" + "id_seance=" + id_seance + ", seancegenerique=" + seancegenerique + ", date=" + date + ", etat=" + etat + ", observation=" + observation + '}';
    }
    
    
}
