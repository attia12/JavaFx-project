/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.services;
import edu.esprit.entities.Aarticle;

import edu.esprit.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author user
 */

 






public class AarticleCrud {
    
    Connection cnx2;
    
    public AarticleCrud()  {
        cnx2 = MyConnection.getInstance().getCnx();
    }
    
    
      public void ajouterAarticle() {
        try {
            String req = "INSERT INTO aarticle (title, description, published, image)" + "VALUES ('howa','zaama','ey','http')";
            Statement st = cnx2.createStatement();
            st.executeUpdate(req);
            System.out.println("aarticle created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

            public void ajouterAarticle2(Aarticle p) {
        try {
           String requete2 = "INSERT INTO aarticle (title, description, published, image)" + "VALUES (?,?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.setString(1, p.getTitle());
            pst.setString(2, p.getDescription());
            pst.setString(3, p.getPublished());
            pst.setString(4, p.getImage());
            pst.executeUpdate();
                        System.out.println("aarticle created !");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
      
      
        public List<Aarticle> afficherAarticles()
        {
         List<Aarticle> myList = new ArrayList<>();
        try {
            String requete3 = "Select * from aarticle";
            Statement st = cnx2.createStatement();
       ResultSet rs =st.executeQuery(requete3);
          while(rs.next()){
                Aarticle p = new Aarticle();
                p.setId(rs.getInt(1));
                    p.setTitle(rs.getString("title")); 
                p.setDescription(rs.getString("description"));      
                p.setPublished(rs.getString("published")); 
              p.setImage(rs.getString("Image")); 

                

                myList.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return myList;
    }
      
        public void supprimerAarticleById(int id) {
    try {
        String requete = "DELETE FROM aarticle WHERE id = ?";
        PreparedStatement pst = cnx2.prepareStatement(requete);
        pst.setInt(1, id);
        int result = pst.executeUpdate();
        if (result > 0) {
            System.out.println("Article supprimé avec succès.");
        } else {
            System.out.println("Aucun article trouvé avec l'ID spécifié.");
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}
        
        public void modifierAarticleById(int id, Aarticle articleModifie) {
    try {
        String requete = "UPDATE aarticle SET title=?, description=?, published=?, image=? WHERE id=?";
        PreparedStatement pst = cnx2.prepareStatement(requete);
        pst.setString(1, articleModifie.getTitle());
        pst.setString(2, articleModifie.getDescription());
        pst.setString(3, articleModifie.getPublished());
        pst.setString(4, articleModifie.getImage());
        pst.setInt(5, id);
        int result = pst.executeUpdate();
        if (result > 0) {
            System.out.println("Article modifié avec succès.");
        } else {
            System.out.println("Aucun article trouvé avec l'ID spécifié.");
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}
        
        
}