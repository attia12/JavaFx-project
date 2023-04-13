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
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class AjoutController implements Initializable {
String s;
    @FXML
    private TextField txtId_Ben;
    @FXML
    private TextField txtTitre;
    @FXML
    private TextField txtQte;
    @FXML
    private TextField txtType;
    @FXML
    private TextField txtId_local;
    @FXML
    private ComboBox<String> txtId_cat_id;
    @FXML
    private Button txtImge;
    @FXML
    private DatePicker txtDatee;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnback;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceCategorie sc = new ServiceCategorie();
        List <Categorie> l = sc.getAll();
       System.out.println(l.size());
        int i=0;
        ObservableList<String> items = FXCollections.observableArrayList();
        while (i<l.size())
        {
        
        System.out.println(l.get(0));
        
        items.add(Integer.toString(l.get(i).getId()));
        
        i=i+1;
        }
        txtId_cat_id.setItems(items);
        
    }    

    @FXML
    private void AddImage(ActionEvent event) {
         FileChooser fileChooser = new FileChooser();
File selectedFile = fileChooser.showOpenDialog(null);
        
        s=selectedFile.toString();
        System.out.println(s);
    }

    @FXML
    private void Add_Don(ActionEvent event) {
         int idBen = Integer.parseInt(txtId_Ben.getText());
    String titre = txtTitre.getText();
    int qte = Integer.parseInt(txtQte.getText());
    String type = txtType.getText();
     String date = txtDatee.getValue().toString();
    int idLocal = Integer.parseInt(txtId_local.getText());
    int idCatId = Integer.parseInt(txtId_cat_id.getValue());
    String imge = s;
    
    ServiceDon serviceDon = new ServiceDon();
    Don d = new Don(idBen, titre, qte, type, date, idLocal, idCatId,imge);
    System.out.println(d);
    boolean check,check2;
if (d.getTitre().matches(".*\\d+.*")==true||!Character.isUpperCase(d.getTitre().charAt(0)))
{check=false;
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Alerte");
alert.setHeaderText(null);
alert.setContentText("Fomrat Titre");
alert.showAndWait();}
else check=true;




if (!Integer.toString(d.getQte()).matches(".*\\d+.*")==true)
{ check2=false;
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Alerte");
alert.setHeaderText(null);
alert.setContentText("Fomrat Qte");
alert.showAndWait();
}
else{check2=true;}









if (check==true&&check2==true)
{serviceDon.ajouter(d);}

    
    }

    @FXML
    private void back(ActionEvent event) {
        
    }
    
}
