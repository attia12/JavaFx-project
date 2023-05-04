/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.UserDetails;
import entities.medicament;
import entities.categorie;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import services.medicamentService;
import services.categorieService;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class medicamentController implements Initializable {

    int idmedic;
    @FXML
    private Label nommedicLabel;
    @FXML
    private Label typemedicLabel;
    @FXML
    private Label descriptionmedicLabel;
    @FXML
    private Label datemedicLabel;
    @FXML
    private Button participermedicButton;
    @FXML
    private Label nb_participantsLabel;
    
    UserDetails u=new UserDetails();
    categorieService Ps=new categorieService();
    @FXML
    private TextField idmedicF;
    @FXML
    private TextField iduserF;
    
    medicamentService Ev=new medicamentService();
    @FXML
    private ImageView imageview;
    @FXML
    private Label categorieComplet;
    @FXML
    private TextField idPartField;
    @FXML
    private Button annulerButton;
    @FXML
    private Button likeButton;
     @FXML
    private Button deslikeButton;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        idmedicF.setVisible(false);
        deslikeButton.setVisible(false);
        likeButton.setVisible(true);
                iduserF.setVisible(false);
                categorieComplet.setVisible(false);
                annulerButton.setVisible(false);
        likeButton.setOnAction(event -> {
    likeButton.setStyle("-fx-background-color: green;");
    deslikeButton.setVisible(false);
    PauseTransition delay = new PauseTransition(Duration.seconds(5));
});
deslikeButton.setVisible(true);
likeButton.setVisible(true);
deslikeButton.setOnAction(event -> {
    PauseTransition delay = new PauseTransition(Duration.seconds(5));
    delay.setOnFinished(medic -> {
        likeButton.setStyle("-fx-background-color: green;");
        
    });
    delay.play();
    deslikeButton.setStyle("-fx-background-color: red;");
    likeButton.setVisible(false);
});



                

    }    
    private medicament eve=new medicament();
    
    public void setmedicament(medicament e) {
        this.eve=e;
        nommedicLabel.setText(e.getNom_medicament());
        typemedicLabel.setText(e.getType_medicament());
        descriptionmedicLabel.setText(e.getDescription_medicament());
        datemedicLabel.setText(String.valueOf(e.getDate()));
        nb_participantsLabel.setText(String.valueOf(e.getDisponible()));
        idmedicF.setText(String.valueOf(e.getId_ab()));
        iduserF.setText(String.valueOf(1));
         String path = e.getImage_medicament();
         File file=new File(path);
         Image img = new Image(file.toURI().toString());
         imageview.setImage(img);

    }
    public void setIdmedic(int idmedic){
        this.idmedic=idmedic;
    }


    @FXML
    private void participermedic(MouseEvent medic) throws SQLException {

        LocalDate dateActuelle = LocalDate.now();
        Date dateSQL = Date.valueOf(dateActuelle);
        categorie p=new categorie(dateSQL,Integer.parseInt(iduserF.getText()),Integer.parseInt(idmedicF.getText()));
        
        Ps.ajoutercategorie(p);

        idPartField.setText(String.valueOf(27));
        annulerButton.setVisible(true);
       
        
        participermedicButton.setVisible(false);
        
 
        }
    
    public void arretermedic()
    {
        participermedicButton.setVisible(false);
        categorieComplet.setVisible(true);
    }

    @FXML
    private void annulercategorie(ActionEvent medic) throws SQLException {
        categorie p=new categorie();
        p.setId_promo(Integer.parseInt(idPartField.getText()));
        Ps.Deletecategorie(p);
        participermedicButton.setVisible(true);
        annulerButton.setVisible(false);
        
    }
    
    
}
