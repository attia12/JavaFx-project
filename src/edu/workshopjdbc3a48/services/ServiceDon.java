/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.workshopjdbc3a48.services;


import edu.workshopjdbc3a48.entities.Don;
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
public class ServiceDon implements IService<Don> {
     Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Don D) {
        try {
            String req = "INSERT INTO don (id_ben, titre, qte, type, date, id_local, id_cat_id, imge) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
PreparedStatement ps = cnx.prepareStatement(req);
ps.setString(1,Integer.toString(D.getId_ben()));
ps.setString(2, D.getTitre());
ps.setInt(3, D.getQte());
ps.setString(4, D.getType());
ps.setString(5,D.getDate());
ps.setInt(6, D.getId_local());
ps.setInt(7, D.getId_cat_id());
ps.setString(8, D.getImge());
ps.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ADD Don");
 
alert.setHeaderText("ADD Don");
alert.setContentText("ADD!");
 
alert.showAndWait();
                  
        }
        
    
         catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
   

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `don` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("update Don");
 
alert.setHeaderText("Delete Don");
alert.setContentText("Delete!");
 
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
    public void modifier(Don D,int id) {
           try {      
               id=D.getId();
               String req = "UPDATE `don` SET `id_ben` = '" + D.getId_ben() + "', `titre` = '" + D.getTitre() + "', `qte` = '" + D.getQte()+ "', `type` = '" + D.getType()+ "', `date` = '" + D.getDate()+ "', `id_local` = '" + D.getId_local()+ "', `id_cat_id` = '" + D.getId_cat_id()+ "', `imge` = '" + D.getImge()+ "' WHERE `id` = " + id;
               Statement st = cnx.createStatement();
               st.executeUpdate(req);
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("update Don");
 
alert.setHeaderText("update Don");
alert.setContentText("Update!");
 
alert.showAndWait();
           } catch (SQLException ex) {
               Logger.getLogger(ServiceDon.class.getName()).log(Level.SEVERE, null, ex);
           }
           
        
    }

    @Override
    public List<Don> getAll() {
        List<Don> list = new ArrayList<>();
        try {
            String req = "Select * from don";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                 Don D = new Don(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7),rs.getInt(8),rs.getString(9));
            list.add(D);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    public List<Don> searchByTitre(String titre) {
    List<Don> list = new ArrayList<>();
    try {
        String query = "SELECT * FROM Don WHERE Titre LIKE ?";
        PreparedStatement stmt = cnx.prepareStatement(query);
        stmt.setString(1, "%" + titre + "%");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Don don = new Don(
                    rs.getInt("id"),
                    rs.getInt("id_ben"),
                    rs.getString("titre"),
                    rs.getInt("qte"),
                    rs.getString("type"),
                    rs.getString("date"),
                    rs.getInt("id_local"),
                    rs.getInt("id_cat_id"),
                    rs.getString("imge")
            );
            list.add(don);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return list;
}

    
    
}
