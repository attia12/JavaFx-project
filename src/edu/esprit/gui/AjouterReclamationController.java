/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esparit.services.ReclamationC;
import edu.esprit.entities.Reclamation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author attia
 */
public class AjouterReclamationController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField description;
    @FXML
    private Button valider;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveReclamation(ActionEvent event) {
        String Nom=nom.getText();
        String Prenom=prenom.getText();
        String Email=email.getText();
        String Description=description.getText();
        Reclamation r=new Reclamation(Nom, Prenom, Email, Description);
        ReclamationC rc=new ReclamationC();
        rc.ajouter(r);
    }
    
}
