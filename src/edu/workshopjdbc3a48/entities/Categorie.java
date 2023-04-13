/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.workshopjdbc3a48.entities;

import java.util.Objects;

/**
 *
 * @author msi
 */
public class Categorie {
     private int id;
    private String nom,type_cat,des_cat ;

    public Categorie() {
    }

    public Categorie(int id, String nom, String type_cat, String des_cat) {
        this.id = id;
        this.nom = nom;
        this.type_cat = type_cat;
        this.des_cat = des_cat;
    }

    public Categorie(String nom, String type_cat, String des_cat) {
        this.nom = nom;
        this.type_cat = type_cat;
        this.des_cat = des_cat;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getType_cat() {
        return type_cat;
    }

    public String getDes_cat() {
        return des_cat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType_cat(String type_cat) {
        this.type_cat = type_cat;
    }

    public void setDes_cat(String des_cat) {
        this.des_cat = des_cat;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", nom=" + nom + ", type_cat=" + type_cat + ", des_cat=" + des_cat + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categorie other = (Categorie) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.type_cat, other.type_cat)) {
            return false;
        }
        return Objects.equals(this.des_cat, other.des_cat);
    }
    
    
    
}
