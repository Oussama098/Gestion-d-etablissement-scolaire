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
public class docjustifabsetudiant {
    private int id;
    private String nom;
    private Date dateDepot;
    private Date dateDebut;
    private Date dateFin;
    private String emplacement;
    private String type;
    private Date dateUpload;
    private String observation;

    public docjustifabsetudiant(int id, String nom, Date dateDepot, Date dateDebut, Date dateFin, String emplacement,
                    String type, Date dateUpload, String observation) {
        this.id = id;
        this.nom = nom;
        this.dateDepot = dateDepot;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.emplacement = emplacement;
        this.type = type;
        this.dateUpload = dateUpload;
        this.observation = observation;
    }

    public docjustifabsetudiant(int id) {
        this.id = id;
    }

    
    public docjustifabsetudiant(String nom, Date dateDepot, Date dateDebut, Date dateFin, String emplacement, String type, Date dateUpload, String observation) {
        this.nom = nom;
        this.dateDepot = dateDepot;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.emplacement = emplacement;
        this.type = type;
        this.dateUpload = dateUpload;
        this.observation = observation;
    }
    
    

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(Date dateDepot) {
        this.dateDepot = dateDepot;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateUpload() {
        return dateUpload;
    }

    public void setDateUpload(Date dateUpload) {
        this.dateUpload = dateUpload;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", dateDepot=" + dateDepot +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", emplacement='" + emplacement + '\'' +
                ", type='" + type + '\'' +
                ", dateUpload=" + dateUpload +
                ", observation='" + observation + '\'' +
                '}';
    }


}
