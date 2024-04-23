/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author oussa
 */
public class user {
    private int id_user;
    private String nom , prenom , email ,dateNais , lieuNais ,Tele, sexe,photo,  role;

    public user(int id_user, String nom, String prenom, String email, String dateNais, String lieuNais, String Tele, String sexe, String photo, String role) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateNais = dateNais;
        this.lieuNais = lieuNais;
        this.Tele = Tele;
        this.sexe = sexe;
        this.photo = photo;
        this.role = role;
    }

    public user( String nom, String prenom, String email, String dateNais, String lieuNais, String Tele, String sexe, String photo) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateNais = dateNais;
        this.lieuNais = lieuNais;
        this.Tele = Tele;
        this.sexe = sexe;
        this.photo = photo;
        
    }
    
    public user( String nom, String prenom, String email, String dateNais, String lieuNais, String Tele, String sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateNais = dateNais;
        this.lieuNais = lieuNais;
        this.Tele = Tele;
        this.sexe = sexe;
        
    }
    
    
    

    public user(int id_user, String nom, String prenom, String dateNais, String sexe) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNais = dateNais;
        this.sexe = sexe;
    }

    public user(int id_user) {
        this.id_user = id_user;
    }
    


    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateNais() {
        return dateNais;
    }

    public void setDateNais(String dateNais) {
        this.dateNais = dateNais;
    }

    public String getLieuNais() {
        return lieuNais;
    }

    public void setLieuNais(String lieuNais) {
        this.lieuNais = lieuNais;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTele() {
        return Tele;
    }

    public void setTele(String Tele) {
        this.Tele = Tele;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "user{" + "id_user=" + id_user + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", dateNais=" + dateNais + ", lieuNais=" + lieuNais + ", Tele=" + Tele + ", sexe=" + sexe + ", photo=" + photo + ", role=" + role + '}';
    }

    

    
    

    
    

    

    
    
}
