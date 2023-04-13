/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author attia
 */
public class Reclamation {
    private int id;
    private String nom;
    
    private String prenom;
    private String email;
     private int status=0;
    private String description;

    public Reclamation() {
    }

    public Reclamation(int id, String nom, String prenom, String email, int status, String description) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.status = status;
        this.description = description;
    }

    public Reclamation(String nom, String prenom, String email, String description) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        
        this.description = description;
    }

    public Reclamation(int id, String nom, String prenom, String email, String description) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.description = description;
    }
    

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", status=" + status + ", description=" + description + '}';
    }
    
    
}
