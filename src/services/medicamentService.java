/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

//import com.sun.javafx.iio.ImageStorage.ImageType;
import entities.medicament;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utils.MyDB;
import javafx.collections.ObservableList;

//**************//
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import static org.apache.poi.hssf.usermodel.HeaderFooter.date;

/**
 *
 * @author asus
 */
public class medicamentService implements ImedicamentService<medicament> {

    Connection cnx;
    public Statement ste;
    public PreparedStatement pst;

    public medicamentService() {
        cnx = MyDB.getInstance().getCnx();

    }

    @Override
    public void ajoutermedicament(medicament e) throws SQLException {

        String requete = "INSERT INTO `medicament` (`nom_medicament`,`type_medicament`,`image_medicament`,`description_medicament`,`date`,`disponible`) "
                + "VALUES (?,?,?,?,?,?);";
        try {
            pst = (PreparedStatement) cnx.prepareStatement(requete);
            pst.setString(1, e.getNom_medicament());
            pst.setString(2, e.getType_medicament());
            pst.setString(3, e.getImage_medicament());
            pst.setString(4, e.getDescription_medicament());
            pst.setDate(5, e.getDate());
            pst.setInt(6, e.getDisponible());
            pst.executeUpdate();
            System.out.println("medic " + e.getNom_medicament() + " added successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void modifiermedicament(medicament e) throws SQLException {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String req = "UPDATE medicament SET nom_medicament = ?,type_medicament = ?,image_medicament=?,description_medicament = ?,date=?,disponible=? where id_ab = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, e.getNom_medicament());
        ps.setString(2, e.getType_medicament());
        ps.setString(3, e.getImage_medicament());
        ps.setString(4, e.getDescription_medicament());
        ps.setDate(5, e.getDate());
        ps.setInt(6, e.getDisponible());
        ps.setInt(7, e.getId_ab());
        ps.executeUpdate();
    }

    @Override
    public void supprimermedicament(medicament e) throws SQLException {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String req = "delete from medicament where id_ab = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, e.getId_ab());
        ps.executeUpdate();
        System.out.println("medic with id= " + e.getId_ab() + "  is deleted successfully");
    }

    @Override
    public List<medicament> recuperermedicament() throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        List<medicament> medicaments = new ArrayList<>();
        String s = "select * from medicament";
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(s);
        while (rs.next()) {
            medicament e = new medicament();
            e.setNom_medicament(rs.getString("nom_medicament"));
            e.setType_medicament(rs.getString("type_medicament"));
            e.setImage_medicament(rs.getString("Image_medicament"));
            e.setDescription_medicament(rs.getString("description_medicament"));
            e.setDate(rs.getDate("date"));
            e.setDisponible(rs.getInt("disponible"));
            e.setId_ab(rs.getInt("id_ab"));

            medicaments.add(e);

        }
        return medicaments;
    }

    public medicament FetchOnemedic(int id) {
        medicament medic = new medicament();
        String requete = "SELECT * FROM `medicament` where id_ab = " + id;

        try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs = ste.executeQuery(requete);

            while (rs.next()) {

                medic = new medicament(rs.getInt("id_ab"), rs.getInt("disponible"), rs.getString("nom_medicament"), rs.getString("type_medicament"), rs.getString("image_medicament"), rs.getString("description_medicament"), rs.getDate("date"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(medicamentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medic;
    }

    public ObservableList<medicament> Fetchmedics() {
        ObservableList<medicament> medics = FXCollections.observableArrayList();
        String requete = "SELECT * FROM `medicament`";
        try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs = ste.executeQuery(requete);

            while (rs.next()) {
                medics.add(new medicament(rs.getInt("id_ab"), rs.getInt("disponible"), rs.getString("nom_medicament"), rs.getString("type_medicament"), rs.getString("image_medicament"), rs.getString("description_medicament"), rs.getDate("date")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(medicamentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medics;
    }

    public String GenerateQrmedic(medicament medic) throws FileNotFoundException, IOException {
        String medicName = "medic name: " + medic.getNom_medicament() + "\n" + "medic date: " + medic.getDate() + "\n" + "medic description: " + medic.getDescription_medicament() + "\n";
        ByteArrayOutputStream out = QRCode.from(medicName).to(ImageType.JPG).stream();
        String filename = medic.getNom_medicament() + "_QrCode.jpg";
        //File f = new File("src\\utils\\img\\" + filename);
                File f = new File("C:\\xampp\\htdocs\\imgQr\\qrcode" + filename);
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(out.toByteArray());
        fos.flush();
       
        System.out.println("qr yemshi");
        return filename;
    }
    

    public ObservableList<medicament> cherchermedic(String chaine) {
        String sql = "SELECT * FROM medicament WHERE (nom_medicament LIKE ? or type_medicament LIKE ?  ) order by nom_medicament ";
        //Connection cnx= Maconnexion.getInstance().getCnx();
        String ch = "%" + chaine + "%";
        ObservableList<medicament> myList = FXCollections.observableArrayList();
        try {

            Statement ste = cnx.createStatement();
            // PreparedStatement pst = myCNX.getCnx().prepareStatement(requete6);
            PreparedStatement stee = cnx.prepareStatement(sql);
            stee.setString(1, ch);
            stee.setString(2, ch);

            ResultSet rs = stee.executeQuery();
            while (rs.next()) {
                medicament e = new medicament();

                e.setNom_medicament(rs.getString("nom_medicament"));
                e.setType_medicament(rs.getString("type_medicament"));
                e.setImage_medicament(rs.getString("Image_medicament"));
                e.setDescription_medicament(rs.getString("description_medicament"));
                e.setDate(rs.getDate("date"));
                e.setDisponible(rs.getInt("disponible"));
                e.setId_ab(rs.getInt("id_ab"));

                myList.add(e);
                System.out.println("medic trouvé! ");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }

    public List<medicament> triermedic()throws SQLException {
        List<medicament> medicaments = new ArrayList<>();
        String s = "select * from medicament order by nom_medicament ";
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(s);
        while (rs.next()) {
            medicament e = new medicament();
            e.setNom_medicament(rs.getString("nom_medicament"));
            e.setType_medicament(rs.getString("type_medicament"));
            e.setImage_medicament(rs.getString("Image_medicament"));
            e.setDescription_medicament(rs.getString("description_medicament"));
            e.setDate(rs.getDate("date"));
            e.setDisponible(rs.getInt("disponible"));
            e.setId_ab(rs.getInt("id_ab"));
            medicaments.add(e);
        }
        return medicaments;
    }
   

}
