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
public class etudiant {
    private int id_etudiant;
    private user User;
    private filiere filiere;
    private classe classe;
    private CheckBox select;

    public CheckBox getSelect() {
        return select;
    }

    public void setSelect(CheckBox select) {
        this.select = select;
    }
   

    public etudiant(){
        
    }
    public etudiant(int id_etudiant, user User, filiere filiere , classe classe) {
        this.id_etudiant = id_etudiant;
        this.User = User;
        this.filiere = filiere;
        this.classe= classe;
        this.select= new CheckBox();
    }

    public etudiant(user User, filiere filiere, classe classe) {
        this.User = User;
        this.filiere = filiere;
        this.classe = classe;
        this.select= new CheckBox();
    }

    public etudiant(int id_etudiant) {
        this.id_etudiant = id_etudiant;
        this.select= new CheckBox();
    }
    
    
    
    
    
//    public etudiant (int id_etudiant , String nom , String prenom , String dateNais , String sexe  , String filiere  ){
//        this.id_etudiant=id_etudiant;
//        this.User= new user(nom, prenom,  dateNais, sexe);
//        this.filiere = new filiere(filiere);
//    }

    public int getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(int id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public user getUser() {
        return User;
    }

    public void setUser(user User) {
        this.User = User;
    }

    public filiere getFiliere() {
        return filiere;
    }

    
    public void setFiliere(filiere filiere) {
        this.filiere = filiere;
    }
    
    public classe getClasse(){
        return classe;
    }
    
    public String getNomClasse(){
        return classe.getClassegenerique().getNiveau().getCode() +" "+classe.getClassegenerique().getFiliere().getCode()+" "+classe.getClassegenerique().getCycle().getCode();
    }
    public String getPrenom(){
        return User.getPrenom();
    }
    
    public String getNom(){
        return User.getNom();
    }
    
    public String getNomComplet(){
        return User.getNom()+" "+User.getPrenom();
    }
    public String getDateNais(){
        return User.getDateNais();
    }
    
    public String getLieuNais(){
        return User.getLieuNais();
    }
    
    public String getTele(){
        return User.getTele();
    }
    
    public String getEmail(){
        return User.getEmail();
    }

    public void setClasse(classe classe) {
        this.classe = classe;
    }
    
    public String getSexe(){
        return User.getSexe();
    }
    
    public String getCode(){
        return filiere.getCode();
    }

    @Override
    public String toString() {
        return "etudiant{" + "id_etudiant=" + id_etudiant + ", User=" + User + ", filiere=" + filiere + ", classe=" + classe + '}';
    }

    
    
    

    

    

    
    
}
