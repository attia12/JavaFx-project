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
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class AfficherController implements Initializable {

    @FXML
    private TableView<Don> table;
    @FXML
    private TableColumn<Don,String> Id_BenC;
    @FXML
    private TableColumn<Don,String > TitreC;
    @FXML
    private TableColumn<Don,String> QteC;
    @FXML
    private TableColumn<Don,String> TypeC;
    @FXML
    private TableColumn<Don,String> DateC;
    @FXML
    private TableColumn<Don,String> Id_localC;
    @FXML
    private TableColumn<Don,String> Id_cat_idC;
    @FXML
    private TableColumn<Don,String> ImageC;
    @FXML
    private ImageView img;
    @FXML
    private TextField searchBar;
    @FXML
    private Button btnajouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       table();
    }    
 public void affimage(String s){
        
       File file = new File(s);
if(file.exists()) {
    Image image = new Image(file.toURI().toString());
    img.setImage(image);
} else {
    System.out.println("Image file not found!");
}
    }
public void table() {
    ObservableList<Don> dons = FXCollections.observableArrayList();
    ServiceDon serviceDon = new ServiceDon();
    dons.addAll(serviceDon.getAll());

    table.setItems(dons);

    Id_BenC.setCellValueFactory(f -> new SimpleIntegerProperty(f.getValue().getId_ben()).asString());
    TitreC.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getTitre()));
    QteC.setCellValueFactory(f -> new SimpleIntegerProperty(f.getValue().getQte()).asString());
    TypeC.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getType()));
    DateC.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getDate()));
    Id_localC.setCellValueFactory(f -> new SimpleIntegerProperty(f.getValue().getId_local()).asString());
    Id_cat_idC.setCellValueFactory(f -> new SimpleIntegerProperty(f.getValue().getId_cat_id()).asString());
    ImageC.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getImge()));

    table.setRowFactory(tv -> {
        TableRow<Don> myRow = new TableRow<>();
        myRow.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                int myIndex = table.getSelectionModel().getSelectedIndex();
                
                String imge = table.getItems().get(myIndex).getImge();
                affimage(imge);
               
      
              
            }
        });
        return myRow;
    });
    
    
}
    @FXML
    private void searchDon(KeyEvent event) {
String searchText = searchBar.getText().trim();
    ServiceDon sp = new ServiceDon();
    ObservableList<Don> list = FXCollections.observableArrayList();
    List<Don> results = sp.searchByTitre(searchText);
    list.addAll(results);
    table.setItems(list);
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("afficher.fxml"));
        javafx.scene.Scene scene = new javafx.scene.Scene(root);
        
       
        
    }
    
}
