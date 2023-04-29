/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package projet.controller;
import edu.workshopjdbc3a48.services.ServiceDon;
import edu.workshopjdbc3a48.entities.Don;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import tray.animations.AnimationType;
/*import tray.animations.AnimationType;
import tray.notification.NotificationType;*/

import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;


/**
 * FXML Controller class
 *
 * @author msi
 */
public class DetailController implements Initializable {

    @FXML
    private AnchorPane brand;
    @FXML
    private Label ref;
    @FXML
    private ImageView image;
    @FXML
    private Label depart;
    @FXML
    private Label desc;
    @FXML
    private Label nom;
    @FXML
    private Button confirmer;
    @FXML
    private Button Retour;
    @FXML
    private Label disponibilite;
    @FXML
    private Pane pane_m;
    @FXML
    private Button to_profile;
    @FXML
    private Button to_panier;
    @FXML
    private Button Alerts;
    @FXML
    private Label alerts;
    @FXML
    private Button Locaux;
    @FXML
    private Circle circle;
    @FXML
    private Button nom_u;
    @FXML
    private Button Accueil;
    @FXML
    private Button Reclamations;

    /**
     * Initializes the controller class.
     */
    private Don o;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }  
    public void initData(Don o) throws MalformedURLException {

        this.o = o;

        //   cl_mail.setText(o.getMailen());
        //Ref.setText(o.getId_annonce());
        //int id = o.getId_annonce();
        //Label ref = new Label();
             File file = new File (o.getImge());

        Image imageForFile = null;

        imageForFile = new Image(file.toURI().toURL().toExternalForm());

        ref.setText(Integer.toString(o.getId()));

        ref.setWrapText(true);

        nom.setText(o.getTitre());
        nom.setWrapText(true);
        desc.setText(o.getType());
       
      
        image.setImage(imageForFile);
    }


   

    @FXML
    private void ajouter(ActionEvent event) {
    // Code pour ajouter les données dans la base de données

    // Affichage de la notification
    TrayNotification tray = new TrayNotification();
    AnimationType type = AnimationType.POPUP;
    tray.setAnimationType(type);
    tray.setTitle("Don Confirmee");
    tray.setMessage("succees");
    tray.setNotificationType(NotificationType.SUCCESS);
    tray.showAndDismiss(Duration.millis(5000));
}


    @FXML
    private void Retour(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/interface1/gui/Affichage_Ann.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void To_Profile(ActionEvent event) {
    }

    @FXML
    private void To_Panier(ActionEvent event) {
    }

    @FXML
    private void Deconnexion(ActionEvent event) {
    }

    @FXML
    private void Alerts(ActionEvent event) {
    }

    @FXML
    private void Locaux(ActionEvent event) {
    }

    @FXML
    private void To_Accueil(ActionEvent event) {
    }

    @FXML
    private void Reclamations(ActionEvent event) {
    }
    
}
