/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.medicament;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import services.medicamentService;
import utils.mailing;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
/**
 * FXML Controller class
 *
 * @author asus
 */
public class AffichermedicamentController implements Initializable {

    @FXML
    private GridPane gridmedic;

    medicamentService ab=new medicamentService();
    @FXML
    private TextField cherchermedicField;
    @FXML
    private Button ajouter;
    @FXML
    private Button mailButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        affichermedicament();
               
    }    


    @FXML
    private void ajoutermedicament(ActionEvent medic) {
      try {
            //navigation
            Parent loader = FXMLLoader.load(getClass().getResource("ajoutermedicament.fxml"));
            cherchermedicField.getScene().setRoot(loader);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void affichermedicament(){
         try {
            List<medicament> medicaments = ab.recuperermedicament();
            gridmedic.getChildren().clear();
            int row = 0;
            int column = 0;
            for (int i = 0; i < medicaments.size(); i++) {
                //chargement dynamique d'une interface
                FXMLLoader loader = new FXMLLoader(getClass().getResource("medicament.fxml"));
                AnchorPane pane = loader.load();
               
                //passage de parametres
                medicamentController controller = loader.getController();
                controller.setmedicament(medicaments.get(i));
                controller.setIdmedic(medicaments.get(i).getId_ab());
                gridmedic.add(pane, column, row);
                column++;
                if (column > 1) {
                    column = 0;
                    row++;
                }
                if(medicaments.get(i).getDisponible()<=0)
                {
                 // ab.medicament(medicament.get(i));
                controller.arretermedic();
                }
            }
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }   
    }

    @FXML
    private void recherchermedicament(KeyEvent medic) {
        try {
            List<medicament> medicaments = ab.cherchermedic(cherchermedicField.getText());
            gridmedic.getChildren().clear();
            int row = 0;
            int column = 0;
            for (int i = 0; i < medicaments.size(); i++) {
                //chargement dynamique d'une interface
                FXMLLoader loader = new FXMLLoader(getClass().getResource("medicament.fxml"));
                AnchorPane pane = loader.load();         
                //passage de parametres
                medicamentController controller = loader.getController();
                controller.setmedicament(medicaments.get(i));
                controller.setIdmedic(medicaments.get(i).getId_ab());
                gridmedic.add(pane, column, row);
                column++;
                if (column > 1) {
                    column = 0;
                    row++;
                }
                if(medicaments.get(i).getDisponible()<=0)
                {
                 // ab.medicament(medicament.get(i));
                controller.arretermedic();
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }   
    }

    @FXML
    private void mailingg(ActionEvent medic) throws MessagingException, AddressException, IOException, URISyntaxException {
        
        String link = "https://mail.google.com/mail/u/0/?tab=cm&zx=6vpa7piztdtn#inbox?compose=GTvVlcSKhbnqsGRcGNBNHqGhtzrPdQxJTjTWlbhlKHrcFhZjBphDzNJnjcPDwvPGJfSsqhDmLbkDr";
         Desktop.getDesktop().browse(new URI(link));
    }

    @FXML
    private void triermedicament(ActionEvent medic) throws SQLException {
        try {
            List<medicament> medicaments = ab.triermedic();
            gridmedic.getChildren().clear();
            int row = 0;
            int column = 0;
            for (int i = 0; i < medicaments.size(); i++) {
                //chargement dynamique d'une interface
                FXMLLoader loader = new FXMLLoader(getClass().getResource("medicament.fxml"));
                AnchorPane pane = loader.load();      
                //passage de parametres
                medicamentController controller = loader.getController();
                controller.setmedicament(medicaments.get(i));
                controller.setIdmedic(medicaments.get(i).getId_ab());
                gridmedic.add(pane, column, row);
                column++;
                if (column > 1) {
                    column = 0;
                    row++;
                }
                if(medicaments.get(i).getDisponible()<=0)
                {
                 // ab.supprimerEvenement(medicament.get(i));
                controller.arretermedic();
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
 
    }
    
}
