/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esparit.services;

import edu.esprit.entities.Reclamation;
import edu.esprit.entities.Response;
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
public class ResponseC implements IService <Response> {
     public Connection cnx=MyConnection.getInstance().getCnx() ;

    @Override
    public void ajouter(Response r) {
        try {
          String req = "INSERT INTO `response` ( `description`,`reclamation_id`) VALUES (?,?)";
          PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1,r.getDescription());
            ps.setInt(2,r.getReclamationid().getId());
            
          //  ps.setString(3, rep.getDatedebut());
           // ps.setString(4, rep.getDatefin());
            
          ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `response` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("reponse deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Response r) {
        try {
           String req = "UPDATE `response` SET `description`='"+ r.getDescription()+"' WHERE `response`.`id` = " + r.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Response updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Response> getAll() {
         ReclamationC reclamation=new ReclamationC();
        List<Response> list = new ArrayList<>();
        try {
            String req = "Select * from response";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Response rep=new Response();
                rep.setId(rs.getInt("id"));
               
                rep.setDescription(rs.getString("description"));
                
                
                Reclamation newreclamation=reclamation.getTbyId(rs.getInt("reclamation_id"));
               
                rep.setReclamationid(newreclamation);
                
                list.add(rep);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public Response getTbyId(int id) {
          try {
             String req = "Select id from response";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Response response = new Response();
               response.setId(rs.getInt("id"));
               
                    response.setDescription(rs.getString("description"));
                     return response;
                     
                
                
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
         return null;
    }
    
    
    
    
 
    }

    

