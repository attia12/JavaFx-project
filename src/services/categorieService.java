/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.categorie;
import entities.medicament;
import entities.UserDetails;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyDB;

/**
 *
 * @author asus
 */
public class categorieService {

    Connection cnx;
    public Statement ste;
    public PreparedStatement pst;

    public categorieService() {

        cnx = MyDB.getInstance().getCnx();
    }

    public void ajoutercategorie(categorie p) {
        UserDetails U = new UserDetails();
        medicamentService es = new medicamentService();
        String requete = "INSERT INTO `categorie` (`date_part`,`id_medicament` ,`id_user`) VALUES(? ,?,?) ;";

        try {
            medicament tempmedic = es.FetchOnemedic(p.getId_medicament());
            System.out.println("before" + tempmedic);
            tempmedic.setDisponible(tempmedic.getDisponible() - 1);
            tempmedic.setDisponible(Math.max(tempmedic.getDisponible() - 1, 0));
            es.modifiermedicament(tempmedic);
            int new_id = tempmedic.getId_ab();
            p.setMedicament(tempmedic);
            System.out.println("after" + tempmedic);

            pst = (PreparedStatement) cnx.prepareStatement(requete);
            pst.setDate(1, p.getDate_part());
            pst.setInt(2, p.getId_medicament());
            pst.setInt(3, p.getId_user());
            pst.executeUpdate();
          

            System.out.println("categorie with id medic = " + p.getId_medicament() + " is added successfully");

        } catch (SQLException ex) {
            System.out.println("error in adding reservation");
            Logger.getLogger(categorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<categorie> recupererCategorie() throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        List<categorie> particip = new ArrayList<>();
        String s = "select * from categorie";
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(s);
        while (rs.next()) {
            categorie pa = new categorie();
            pa.setId_promo(rs.getInt("id_promo"));
            pa.setId_user(rs.getInt("id_user"));
            pa.setId_medicament(rs.getInt("id_medicament"));
            pa.setDate_part(rs.getDate("date_part"));

            particip.add(pa);

        }
        return particip;
    }

    public void supprimercategorie(categorie p) throws SQLException {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String req = "delete from categorie where id_promo  = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, p.getId_promo());
        ps.executeUpdate();
        System.out.println("categorie with id= " + p.getId_promo() + "  is deleted successfully");
    }

    public categorie FetchOneRes(int id) throws SQLException {
        categorie r = new categorie();
        String requete = "SELECT * FROM `categorie` where id_promo=" + id;

        try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs = ste.executeQuery(requete);

            while (rs.next()) {

                r = new categorie(rs.getInt("id_promo"), rs.getDate("date_part"), rs.getInt("id_user"), rs.getInt("id_medicament"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(medicamentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public void Deletecategorie(categorie p) throws SQLException {
        medicamentService es = new medicamentService();
        categorieService rs = new categorieService();

        categorie r = rs.FetchOneRes(p.getId_promo());

        String requete = "delete from categorie where id_promo=" + p.getId_promo();
        try {
            medicament tempmedic = es.FetchOnemedic(r.getId_medicament());
            System.out.println("before" + tempmedic);
            tempmedic.setDisponible(tempmedic.getDisponible() + 1);
            es.modifiermedicament(tempmedic);
            System.out.println("after" + tempmedic);
            pst = (PreparedStatement) cnx.prepareStatement(requete);
            //pst.setInt(1, id);

            pst.executeUpdate();
            System.out.println("categorie with id=" + p.getId_promo() + " is deleted successfully");
        } catch (SQLException ex) {
            System.out.println("error in delete categorie " + ex.getMessage());
        }
    }
    
    public void modifiercategorie(categorie p) throws SQLException {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String req = "UPDATE categorie SET id_user = ?,id_medicament = ?,date_part=? where id_promo = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, p.getId_user());
        ps.setInt(2, p.getId_medicament());
        ps.setDate(3, p.getDate_part());
        ps.setInt(4, p.getId_promo());

        ps.executeUpdate();
    }

}
