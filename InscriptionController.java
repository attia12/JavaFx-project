/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.gui;

import edu.esprit.entities.Aarticle;
import edu.esprit.services.AarticleCrud;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author user
 */
public class InscriptionController implements Initializable {

    @FXML
private TextField tfArticleId;
    @FXML
    private TextField tfTitle;
    @FXML
    private TextField tfDescription;
    @FXML
    private TextField tfPublished;
    @FXML
    private TextField tfImage;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnAfficherListeArticles;
    @FXML
private TableView<Aarticle> tvArticle;
@FXML
private TableColumn<Aarticle, Integer> colID;
@FXML
private TableColumn<Aarticle, String> colTitle;
@FXML
private TableColumn<Aarticle, String> colDescription;
@FXML
private TableColumn<Aarticle, String> colPublished;

private void populateTableView(List<Aarticle> articles) {
    // Configurer les colonnes pour mapper les propriétés de Aarticle
    colID.setCellValueFactory(new PropertyValueFactory<>("id"));
    colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
    colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
    colPublished.setCellValueFactory(new PropertyValueFactory<>("published"));

    // Convertir la liste des articles en ObservableList et la définir comme source de données pour le TableView
    ObservableList<Aarticle> observableList = FXCollections.observableArrayList(articles);
    tvArticle.setItems(observableList);
}

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveAarticle(ActionEvent event) {
        String title = tfTitle.getText().trim();
          String description = tfDescription.getText() .trim();
            String published = tfPublished.getText().trim();
              String image = tfImage.getText() .trim();
               // Vérifier si le titre commence par une majuscule
     // Vérifier si tous les champs sont remplis
    if (title.isEmpty() || description.isEmpty() || published.isEmpty() || image.isEmpty()) {
        System.out.println("Erreur: Veuillez remplir tous les champs.");
        return;
    }

    // Vérifier si le titre commence par une majuscule
    if (!title.matches("[A-Z].*")) {
        System.out.println("Erreur: Le titre doit commencer par une majuscule.");
        return;
    }

    // Vérifier si la description commence par une majuscule
    if (!description.matches("[A-Z].*")) {
        System.out.println("Erreur: La description doit commencer par une majuscule.");
        return;
    }

    // Vérifier si l'image commence par une majuscule
    if (!image.matches("[A-Z].*")) {
        System.out.println("Erreur: L'image doit commencer par une majuscule.");
        return;
    }

    // Vérifier si le champ published est soit "oui" ou "non" seulement
    if (!published.matches("(?i)oui|non")) {
        System.out.println("Erreur: Le champ 'published' doit être 'oui' ou 'non' seulement.");
        return;
    }
              Aarticle p = new Aarticle(title, description, published, image);
              AarticleCrud pc = new AarticleCrud();
              pc.ajouterAarticle2(p);
              
              FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsWindow.fxml"));
        try {
            Parent root = loader.load();
            DetailsWindowController dwc = loader.getController();
            dwc.setTextTitle(p.getTitle());
            dwc.setTextDescription(p.getDescription());
            dwc.setTextPublished(p.getPublished());
            dwc.setTextImage(p.getImage());
            tfTitle.getScene().setRoot(root);
            
        } catch (IOException ex) {
System.out.println("Error: "+ex.getMessage());       }
    }
    
    @FXML
private void supprimerAarticle(ActionEvent event) {
    String articleId = tfArticleId.getText();
    // Vérifiez que l'ID de l'article est saisi
    if (!articleId.isEmpty()) {
        int id = Integer.parseInt(articleId);
        AarticleCrud pc = new AarticleCrud();
        // Appelez la méthode de suppression d'article par ID
        pc.supprimerAarticleById(id);
        // Affichez un message de confirmation de suppression
        System.out.println("Article supprimé avec succès.");
        // Réinitialisez le champ d'ID de l'article à supprimer
        tfArticleId.clear();
    } else {
        System.out.println("Veuillez entrer un ID d'article valide.");
    }
}

@FXML
private void modifierAarticle(ActionEvent event) {
    String articleId = tfArticleId.getText();
    // Vérifiez que l'ID de l'article est saisi
    if (!articleId.isEmpty()) {
        int id = Integer.parseInt(articleId);
        String title = tfTitle.getText();
        String description = tfDescription.getText();
        String published = tfPublished.getText();
        String image = tfImage.getText();

        Aarticle p = new Aarticle(title, description, published, image);
        AarticleCrud pc = new AarticleCrud();
        // Appelez la méthode de modification d'article par ID
        pc.modifierAarticleById(id, p);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsWindow.fxml"));
        try {
            Parent root = loader.load();
            DetailsWindowController dwc = loader.getController();
            dwc.setTextTitle(p.getTitle());
            dwc.setTextDescription(p.getDescription());
            dwc.setTextPublished(p.getPublished());
            dwc.setTextImage(p.getImage());
            tfTitle.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    } else {
        System.out.println("Veuillez entrer un ID d'article valide.");
    }
}

@FXML
private void afficherListeArticles(ActionEvent event) {
    // Appeler la méthode de récupération de la liste des articles
    AarticleCrud pc = new AarticleCrud();
    List<Aarticle> listeArticles = pc.afficherAarticles();

    // Remplir le TableView avec les données de la liste d'articles
    populateTableView(listeArticles);
}

}
