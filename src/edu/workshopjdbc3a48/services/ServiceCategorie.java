/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.workshopjdbc3a48.services;

import edu.workshopjdbc3a48.entities.Categorie;

import edu.workshopjdbc3a48.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author msi
 */
public class ServiceCategorie implements IService<Categorie>{
       Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Categorie C) {
        try {
            String req ="INSERT INTO `categorie` (`nom`, `type_cat`,`des_cat`) VALUES ('" + C.getNom() + "', '" + C.getType_cat() + "', '" + C.getDes_cat()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ADD Categorie");
 
alert.setHeaderText("ADD Categorie");
alert.setContentText("ADD!");
 
alert.showAndWait();
                  
        
        
    
    
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
   

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `Categorie` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete Categorie");
 
alert.setHeaderText("delete Categorie");
alert.setContentText("DELETE!");
 
alert.showAndWait();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     *
     * @param 
     * @throws java.sql.SQLException
     */
   @Override
public void modifier(Categorie C,int id) {
   try {
       String req = "UPDATE categorie SET nom=?, type_cat=?, des_cat=? WHERE id=?";
       PreparedStatement ps = cnx.prepareStatement(req);
       ps.setString(1, C.getNom());
       ps.setString(2, C.getType_cat());
       ps.setString(3, C.getDes_cat());
       ps.setInt(4, id);
       int rows = ps.executeUpdate();
       if (rows > 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Uapdate Categorie");
 
alert.setHeaderText("upadte Categorie");
alert.setContentText("update!");
 
alert.showAndWait();
       }
   } catch (SQLException ex) {
       System.out.println("Error updating categorie: " + ex.getMessage());
   }


    
}
    

    @Override
    public List<Categorie> getAll() {
        List<Categorie> list = new ArrayList<>();
        try {
            String req = "Select * from categorie";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Categorie C = new Categorie (rs.getInt(1), rs.getString("nom"), rs.getString(3),rs.getString(4));
                list.add(C);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
  public Categorie getCat(String ch) {
        Categorie cat = new Categorie();
        try {
            String req = "Select * from categorie where nom='"+ch+"'";
            
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            System.out.print(st);
            while(rs.next()){
                Categorie C = new Categorie (rs.getInt(1), rs.getString("nom"), rs.getString(3),rs.getString(4));
                cat=C;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
System.out.print(cat);
        return cat;
    }
  
  
}
