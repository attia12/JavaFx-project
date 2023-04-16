/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.workshopjdbc3a48.gui;

import edu.workshopjdbc3a48.entities.Utilisateur;
import edu.workshopjdbc3a48.services.EmailSender;
import edu.workshopjdbc3a48.services.ServiceUtilisateur;
import edu.workshopjdbc3a48.services.UserSession;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * FXML Controller class
 *
 * @author user
 */
public class VerficationcompteController implements Initializable {

    @FXML
    private Label chrono;
  
    public VerficationcompteController() {
    }

    @FXML
    private TextField tfCode;
    @FXML
    private Button btnCode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         

      
    }    

    @FXML
    private void Activer(ActionEvent event) throws IOException {
        Utilisateur u = UserSession.getInstance().getCurrentUser();
        if (u.getCode()==Integer.parseInt(tfCode.getText()))
        {
         ServiceUtilisateur su = new ServiceUtilisateur();
         su.ActiverUser(u);
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
    Parent root = loader.load();

            
            
    Stage stage = new Stage();
    stage.setScene(new Scene(root));
    stage.show();
     Stage stage1;
            stage1 = (Stage) btnCode.getScene().getWindow();
        stage1.close();
    }
    else
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Alerte");
alert.setHeaderText(null);
alert.setContentText("Code incorrect !");
alert.showAndWait();
        
        
        }
    
    
    
    
    }

    @FXML
    private void Renvoie(ActionEvent event) {
         Utilisateur u = UserSession.getInstance().getCurrentUser();
          Random rand = new Random();
        int randomNumber = rand.nextInt(10000);
        u.setCode(randomNumber);
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Alerte");
alert.setHeaderText(null);
alert.setContentText("Merci de verifier votre boite E-mail pour activer votre compte !");
alert.showAndWait();
UserSession.getInstance().setCurrentUser(u);
  try {
            
            
            
    EmailSender.sendEmail(u.getEmail(), "Activation compte", "Bonjour "+u.getNom() + " " + u.getPrenom()+ " A fin d'activer votre compte merci d'utiliser ce code : "+u.getCode());
    System.out.println("Email sent successfully!");
} catch (MessagingException ex) {
    System.out.println("Failed to send email: " + ex.getMessage());
}
    }
    
}
