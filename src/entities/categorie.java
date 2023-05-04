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
public class categorie extends medicament{
        private int id_promo;        
private Date date_part;    
private int id_user;
public int id_medicament; 
public medicament medicament;

    public categorie() {
    }

    public categorie(int id_promo, Date date_categorie, int id_user, int id_medicament) {
        this.id_promo = id_promo;
        this.date_part = date_categorie;
        this.id_user = id_user;
        this.id_medicament = id_medicament;
    }
    public categorie(Date date_categorie, int id_user, int id_medicament) {
        this.date_part = date_categorie;
        this.id_user = id_user;
        this.id_medicament = id_medicament;
    }

    public categorie(int id_promo, Date date_categorie, int id_user, int id_medicament, medicament v) {
        this.id_promo = id_promo;
        this.date_part = date_categorie;
        this.id_user = id_user;
        this.id_medicament = id_medicament;
        this.medicament = medicament;
    }

    public int getId_promo() {
        return id_promo;
    }

    public Date getDate_part() {
        return date_part;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_medicament() {
        return id_medicament;
    }

    public medicament getmedicament() {
        return medicament;
    }

    public void setId_promo(int id_promo) {
        this.id_promo = id_promo;
    }

    public void setDate_part(Date date_categorie) {
        this.date_part = date_categorie;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_medicament(int id_medicament) {
        this.id_medicament = id_medicament;
    }

    public void setMedicament(medicament medicament) {
        this.medicament = medicament;
    }

    @Override
    public String toString() {
        return "categorie{" + "id_promo=" + id_promo + ", date_categorie=" + date_part + ", id_user=" + id_user + ", id_medicament=" + id_medicament +  '}';
    }
    
    
    




}
