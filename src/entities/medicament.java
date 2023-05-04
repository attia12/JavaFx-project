/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author asus
 */
public class medicament {

   
        private int id_ab;
        private int disponible;
    private String nom_medicament,type_medicament,image_medicament,description_medicament;
    private Date date;

    public medicament() {
    }

    public medicament(int id_ab,int disponible, String nom_medicament, String type_medicament, String image_medicament, String description_medicament, Date date) {
        this.id_ab = id_ab;
        this.disponible=disponible;
        this.nom_medicament = nom_medicament;
        this.type_medicament = type_medicament;
        this.image_medicament = image_medicament;
        this.description_medicament = description_medicament;
        this.date = date;
    }
    public medicament(int disponible, String nom_medicament, String type_medicament, String image_medicament, String description_medicament, Date date) {
        this.disponible=disponible;
        this.nom_medicament = nom_medicament;
        this.type_medicament = type_medicament;
        this.image_medicament = image_medicament;
        this.description_medicament = description_medicament;
        this.date = date;
    }
    
    
     public medicament(int id_ab,int disponible, String nom_medicament, String type_medicament, String image_medicament, String description_medicament) {
        this.id_ab = id_ab;
        this.disponible=disponible;
        this.nom_medicament = nom_medicament;
        this.type_medicament = type_medicament;
        this.image_medicament = image_medicament;
        this.description_medicament = description_medicament;
        
    }
    
    
     //****************** getters ****************

    public int getId_ab() {
        return id_ab;
    }

    public String getNom_medicament() {
        return nom_medicament;
    }

    public String getType_medicament() {
        return type_medicament;
    }

    public String getImage_medicament() {
        return image_medicament;
    }

    public String getDescription_medicament() {
        return description_medicament;
    }

    public Date getDate() {
        return date;
    }
    
    
    //****************** setters ****************

    public void setId_ab(int id_ab) {
        this.id_ab = id_ab;
    }

    public void setNom_medicament(String nom_medicament) {
        this.nom_medicament = nom_medicament;
    }

    public void setType_medicament(String type_medicament) {
        this.type_medicament = type_medicament;
    }

    public void setImage_medicament(String image_medicament) {
        this.image_medicament = image_medicament;
    }

    public void setDescription_medicament(String description_medicament) {
        this.description_medicament = description_medicament;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }
    
    

    @Override
    public String toString() {
        return "medicament{" + "id_ab=" + id_ab+ ", disponible=" + disponible  + ", nom_medicament=" + nom_medicament + ", type_medicament=" + type_medicament + ", image_medicament=" + image_medicament + ", description_medicament=" + description_medicament + ", date=" + date + '}';
    }
    
    
    
    
    
    
}
