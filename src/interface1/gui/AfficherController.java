/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interface1.gui;

import edu.workshopjdbc3a48.entities.Categorie;
import edu.workshopjdbc3a48.entities.Don;
import edu.workshopjdbc3a48.services.ServiceCategorie;
import edu.workshopjdbc3a48.services.ServiceDon;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class AfficherController implements Initializable {

    @FXML
    private Button btnajouter;
    @FXML
    private Button btnback;
    @FXML
    private ListView<Don> listView;
    @FXML
    private ImageView img;
    @FXML
    private TextField searchBar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listView();
    }

    public void affimage(String s) {
        File file = new File(s);
        if (file.exists()) {
            Image image = new Image(file.toURI().toString());
            img.setImage(image);
        } else {
            System.out.println("Image file not found!");
        }
    }

  public void listView() {
    ObservableList<Don> dons = FXCollections.observableArrayList();
    ServiceDon serviceDon = new ServiceDon();
    dons.addAll(serviceDon.getAll());
    
        
    listView.setItems(dons);

    listView.setOnMouseClicked((MouseEvent event) -> {
        Don selectedDon = listView.getSelectionModel().getSelectedItem();
        String imge = selectedDon.getImge();
        affimage(imge);
    });
}

    

    @FXML
    private void searchDon(KeyEvent event) {
        String searchText = searchBar.getText().trim();
        ServiceDon sp = new ServiceDon();
        ObservableList<String> list = FXCollections.observableArrayList();
        List<Don> results = sp.searchByTitre(searchText);
        for (Don don : results) {
            list.add(don.getTitre());
        }
        listView.setItems(list);
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ajout.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void back(ActionEvent event) {
        Stage stage = (Stage) btnback.getScene().getWindow();
        stage.close();
    }

}
