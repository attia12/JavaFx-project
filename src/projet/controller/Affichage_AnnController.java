/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package projet.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import edu.workshopjdbc3a48.services.ServiceDon;
import edu.workshopjdbc3a48.entities.Don;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class Affichage_AnnController implements Initializable {

    @FXML
    private AnchorPane brand;
    @FXML
    private VBox affich_produit;
    @FXML
    private TextField Searchp;
    @FXML
    private VBox vboxx;
    @FXML
    private Pane pane_m;
    @FXML
    private Button to_profile;
    @FXML
    private Button to_panier;
    @FXML
    private Circle circle;
    @FXML
    private Button nom_u;
    @FXML
    private Button Programmes;
    @FXML
    private Button Locaux;
    @FXML
    private Button Evenements;
    @FXML
    private Button to_menu;
    @FXML
    private Button Accueil;
private ServiceDon cp = new ServiceDon();
    private Don o;

    List<Don> liste = new ArrayList<Don>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         HBox item = new HBox();
        affich_produit.getChildren().add(item);
        liste = cp.getAll();

        int taille = liste.size();
        for (int i = 0; i < taille; i++) {

            if (i % 4 == 0) {
                item = new HBox();
                affich_produit.getChildren().add(item);
            }
            VBox content = new VBox();

            Label title = new Label();
            o = liste.get(i);

            Image image = null;
            try {
                image = new Image(new FileInputStream( liste.get(i).getImge()));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Affichage_AnnController.class.getName()).log(Level.SEVERE, null, ex);
            }
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(150);
            imageView.setFitWidth(200);

            Label description = new Label((liste.get(i).getTitre()));
            description.setStyle("-fx-strikethrough: true");
            description.getStyleClass().add("barre");

            Label reference = new Label(String.valueOf(liste.get(i).getId()));

            description.setStyle("-fx-strikethrough: true");
            description.getStyleClass().add("barre");

            Label prixpromo = new Label(liste.get(i).getType());
            prixpromo.setStyle("-fx-font-weight: bold");

            content.getChildren().addAll(imageView, title, prixpromo, description, reference);
            Button btn = new Button("", content);
           
            Don o1 = new Don(o.getId(), o.getId_ben(), o.getTitre(), o.getQte(), o.getType(), o.getDate(), o.getId_local(),o.getId_cat_id(),o.getImge());

            btn.setOnAction(event -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/interface1/gui/DetailController.fxml"));

                    Scene scene = new Scene(loader.load());

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                    stage.setScene(scene);

                    stage.show();
                    DetailController controller = loader.<DetailController>getController();

                    controller.initData(o1);
                } catch (IOException ex) {
                    Logger.getLogger(Affichage_AnnController.class.getName()).log(Level.SEVERE, null, ex);
                }

            });
            btn.setPrefWidth(200);
            item.getChildren().add(btn);
            affich_produit.setSpacing(50);
            item.setSpacing(20);
        }

        // TODO
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
    private void Programmes(ActionEvent event) {
    }

    @FXML
    private void Locaux(ActionEvent event) {
    }

    @FXML
    private void Evenements(ActionEvent event) {
    }

    @FXML
    private void ToMenu(ActionEvent event) {
    }

    @FXML
    private void To_Accueil(ActionEvent event) {
    }
    
}
