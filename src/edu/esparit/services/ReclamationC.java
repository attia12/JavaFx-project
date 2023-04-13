/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esparit.services;

import edu.esprit.entities.Reclamation;
import edu.esprit.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author attia
 */
public class ReclamationC implements IService<Reclamation> {
    
    public Connection cnx=MyConnection.getInstance().getCnx() ;
    

    

    @Override
    public void ajouter(Reclamation r) {
         try {
          String req = "INSERT INTO `reclamation` (`nom` ,`prenom`,`email`,`description`) VALUES (?,?,?,?)";
          PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1,r.getNom());
            ps.setString(2, r.getPrenom());
            ps.setString(3, r.getEmail());
            ps.setString(4, r.getDescription());
          
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `reclamation` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Reclamation deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Reclamation r) {
       try {
           String req = "UPDATE `reclamation` SET `nom` = '" + r.getNom() + "', `prenom` = '" + r.getPrenom() + "',`email`='"+ r.getEmail() + "',`description`='"+ r.getDescription()+"' WHERE `reclamation`.`id` = " + r.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Reclamation updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Reclamation > getAll() {
        List<Reclamation> list = new ArrayList<>();
        try {
            String req = "Select * from reclamation";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Reclamation p = new Reclamation(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),rs.getString("email"),rs.getInt(5),rs.getString(6));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public Reclamation getTbyId(int id) {
         try {
            String req = "Select * from reclamation where id = "+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Reclamation reclamation = new Reclamation();
               reclamation.setId(rs.getInt("id"));
                reclamation.setNom(rs.getString("nom"));
                 reclamation.setPrenom(rs.getString("prenom"));
                  reclamation.setEmail(rs.getString("email"));
                   reclamation.setStatus(rs.getInt("status"));
                    reclamation.setDescription(rs.getString("description"));
                     return reclamation;
                     
                
                
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
         return null;
        
        //To change body of generated methods, choose Tools | Templates.
    }
    
    

  
    
    
    
    
    
    
    
}
