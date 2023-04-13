/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interface1.gui;

import edu.workshopjdbc3a48.entities.Categorie;
import edu.workshopjdbc3a48.services.ServiceCategorie;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class Interface_CategorieController implements Initializable {

    @FXML
    private TextField txtNom;
    @FXML
    private Button btnAdd;
    @FXML
    private TextField txtType;
    @FXML
    private TextField txtDes;
    @FXML
    private TableView<Categorie> table;
    @FXML
    private TableColumn<Categorie, String> Type_CatColmn;
    @FXML
    private TableColumn<Categorie, String> Des_CatColmn;
    @FXML
    private TableColumn<Categorie, String> NomColmn;
    private TableColumn<Categorie, Integer> IDColmn;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table();
    }    

    @FXML
    private void Add_cat(ActionEvent event) {
         String nom,type_cat,type_des;
            nom = txtNom.getText();
            type_cat = txtType.getText();
            type_des= txtDes.getText();
            ServiceCategorie sp = new ServiceCategorie();
                Categorie C = new Categorie(nom,type_cat,type_des);
                sp.ajouter(C);
             
              
                table();
            
            txtNom.setText("");
            txtType.setText("");
            txtDes.setText("");
            txtNom.requestFocus();
            
    }
     public void table() {
        ObservableList<Categorie> categories = FXCollections.observableArrayList();
        ServiceCategorie sp = new ServiceCategorie();
        categories.addAll(sp.getAll());

        table.setItems(categories);
        
        Type_CatColmn.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getType_cat()));
        Des_CatColmn.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getDes_cat()));
        NomColmn.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getNom()));

        table.setRowFactory(tv -> {
            TableRow<Categorie> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    int myIndex = table.getSelectionModel().getSelectedIndex();
                    int id = table.getItems().get(myIndex).getId();
                    String name = table.getItems().get(myIndex).getNom();
                    String type_cat = table.getItems().get(myIndex).getType_cat()   ;
                    String type_des = table.getItems().get(myIndex).getDes_cat();
                    txtNom.setText(name);
                    txtType.setText(type_cat);
                    txtDes.setText(type_des);
                }
            });
            return myRow;
        });
    }

    @FXML
    private void Update_cat(ActionEvent event) {
         int myIndex = table.getSelectionModel().getSelectedIndex();
       int id = table.getItems().get(myIndex).getId();
      String nom = txtNom.getText();
            String type_cat = txtType.getText();
            String type_des= txtDes.getText();
            ServiceCategorie sp = new ServiceCategorie();
            Categorie C1 = new Categorie(nom,type_cat,type_des);
            sp.modifier(C1,id);
            table();
    }

    @FXML
    private void Delete_cat(ActionEvent event) {
        int myIndex = table.getSelectionModel().getSelectedIndex();
       int id = table.getItems().get(myIndex).getId();
        ServiceCategorie sp = new ServiceCategorie();
                
                sp.supprimer(id);
              
             
                table();
                
       
    }


 

   

}




