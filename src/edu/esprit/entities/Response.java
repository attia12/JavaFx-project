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
public class Response {
     private int id;
   
    private String description;
    private Reclamation reclamationid;

    public Response() {
    }

    public Response(String description, Reclamation reclamationid) {
        this.description = description;
        this.reclamationid = reclamationid;
    }

    public Response(String description) {
        this.description = description;
    }

    public Response(int id, String description, Reclamation reclamationid) {
        this.id = id;
        this.description = description;
        this.reclamationid = reclamationid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Reclamation getReclamationid() {
        return reclamationid;
    }

    public void setReclamationid(Reclamation reclamationid) {
        this.reclamationid = reclamationid;
    }
   

    @Override
    public String toString() {
        return "Response{" + "id=" + id + ", description=" + description + ", reclamationid=" + reclamationid + '}';
    }
    

    
    
}
