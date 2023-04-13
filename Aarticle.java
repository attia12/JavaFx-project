package edu.esprit.entities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class Aarticle {
    
     private int id;
   
    private String title;
    private String description;
    private String published;
   
    private String image;
    
    
  public Aarticle() {
    }
  
  
  
    public Aarticle(int id, String title, String description, String published, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.published = published;
        this.image = image;
    }

    public Aarticle(String title, String description, String published, String image) {
        this.title = title;
        this.description = description;
        this.published = published;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Aarticle{" + "id=" + id + ", title=" + title + ", description=" + description + ", published=" + published + ", image=" + image + '}';
    }
    
}
