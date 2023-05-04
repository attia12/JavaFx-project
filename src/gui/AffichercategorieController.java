/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.medicament;
import entities.categorie;
import java.io.IOException;
import services.categorieService;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
    import services.medicamentService;



/**
 * FXML Controller class
 *
 * @author asus
 */
public class AffichercategorieController implements Initializable {

    @FXML
    private TableView<categorie> tablecategorie;
     medicamentService ab=new medicamentService();
    @FXML
    private TableColumn<categorie, Integer> iduserTv;
    @FXML
    private TableColumn<categorie, Integer> idmedicTv;
    @FXML
    private TableColumn<categorie, Date> datePartTv;
    @FXML
    private Button modifierPartBtn;
    @FXML
    private Button supprimerPartBtn;
     @FXML
    private Button ajouter;
    @FXML
    private TextField idread;
    @FXML
    private TextField iduserField;
    @FXML
    private TextField idmedicField;
    @FXML
    private DatePicker datepartField;
    @FXML
    private TextField cherchermedicField;
    
    categorieService Ps=new categorieService();
    @FXML
    private TextField datepartField1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        getCategorie();
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
    @FXML
    private void recherchermedicament(KeyEvent medic) {
        try {
            List<medicament> medicaments = ab.cherchermedic(cherchermedicField.getText());
            
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
                
                if(medicaments.get(i).getDisponible()<=0)
                {
                 // ab.supprimermedicament(medicaments.get(i));
                controller.arretermedic();
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }   
    }
    @FXML
    private void modifiercategorie(ActionEvent medic) throws SQLException {
        
         categorie pa = new categorie();
        pa.setId_promo(Integer.valueOf(idread.getText()));
        pa.setId_medicament(Integer.valueOf(idmedicField.getText()));
        pa.setId_user(Integer.valueOf(iduserField.getText()));
            Date d=Date.valueOf(datepartField.getValue());
        pa.setDate_part(d);
        //pa.setDate_part(datepartField.getText());
       
        Ps.modifiercategorie(pa);
        resetPart();
        getCategorie();
           
        
    }

    @FXML
    private void supprimercategorie(ActionEvent medic) {
         categorie p = tablecategorie.getItems().get(tablecategorie.getSelectionModel().getSelectedIndex());
      
        try {
            Ps.Deletecategorie(p);
        } catch (SQLException ex) {
            Logger.getLogger(AjoutermedicamentController.class.getName()).log(Level.SEVERE, null, ex);
        }   
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information ");
        alert.setHeaderText("categorie delete");
        alert.setContentText("categorie deleted successfully!");
        alert.showAndWait();
        getCategorie();
     
    }

    @FXML
    private void choisircategorie(ActionEvent medic) {
        categorie part = tablecategorie.getItems().get(tablecategorie.getSelectionModel().getSelectedIndex());
        
        idread.setText(String.valueOf(part.getId_promo()));
        idmedicField.setText(String.valueOf(part.getId_medicament()));
        iduserField.setText(String.valueOf(part.getId_user())); 
        datepartField1.setText(String.valueOf(part.getDate_part()));
        //datepartField.setValue((part.getDate_part()));
        
    }
    
    
    public void getCategorie(){
        try {
       

           // TODO
            List<categorie> part = Ps.recupererCategorie();
            ObservableList<categorie> olp = FXCollections.observableArrayList(part);
            tablecategorie.setItems(olp);
            iduserTv.setCellValueFactory(new PropertyValueFactory("id_user"));
            idmedicTv.setCellValueFactory(new PropertyValueFactory("id_medicament"));
            datePartTv.setCellValueFactory(new PropertyValueFactory("date_part"));
            // this.delete();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }
    
    public void resetPart() {
        idread.setText("");
        idmedicField.setText("");
        iduserField.setText("");
        datepartField.setValue(null);
        
    }
   
    
}


 