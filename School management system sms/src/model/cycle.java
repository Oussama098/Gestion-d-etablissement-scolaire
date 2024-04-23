/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author oussa
 */
public class cycle {
    private int id_cycle;
    private String code;
    private String nom;

    public cycle(int id_cycle, String code, String nom) {
        this.id_cycle = id_cycle;
        this.code = code;
        this.nom = nom;
    }

    public cycle(int id_cycle) {
        this.id_cycle = id_cycle;
    }

    
    public int getId_cycle() {
        return id_cycle;
    }

    public void setId_cycle(int id_cycle) {
        this.id_cycle = id_cycle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "cycle{" + "id_cycle=" + id_cycle + ", code=" + code + ", nom=" + nom + '}';
    }
    
}
