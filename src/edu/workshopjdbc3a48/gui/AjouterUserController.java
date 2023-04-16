/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.workshopjdbc3a48.gui;

import edu.workshopjdbc3a48.entities.Utilisateur;
import edu.workshopjdbc3a48.services.ServiceUtilisateur;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AjouterUserController implements Initializable {
   int pass_vis=0;
String s;
    @FXML
    private PasswordField Confirm_mdp_ajout;
    @FXML
    private Label conf;
    @FXML
    private ImageView show_pass;
    @FXML
    private TextField mdp_ajout;

    public AjouterUserController() {
    }

private AfficherUserController firstInterface;
    @FXML
    private Label e_nom;
    @FXML
    private Label e_prenom;
    @FXML
    private Label e_email;
    @FXML
    private Label e_mdp;
    @FXML
    private Label e_num;

    public void setFirstInterface(AfficherUserController firstInterface) {
        this.firstInterface = firstInterface;
    }
    @FXML
    private TextField tfNom_ajout;
    @FXML
    private TextField tfPrenom_ajout;
    @FXML
    private TextField tfEmail_ajout;
    @FXML
    private TextField tfMdp_ajout;
    @FXML
    private TextField tfNum_ajout;
    @FXML
    private TextField tfaddress_ajout;
    @FXML
    private Button btnAjout;
    @FXML
    private ComboBox<String> cbType_ajout;
  
    @FXML
    private ComboBox<String> cbEtat_ajout;
    @FXML
    private Button btn_image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<String> items = FXCollections.observableArrayList("Admin", "Medecin", "Patient");
cbType_ajout.setItems(items); // TODO
  ObservableList<String> itemss = FXCollections.observableArrayList("0","1");
cbEtat_ajout.setItems(itemss); // TODO
  String filePath = "C:\\knownFaces\\pass.png";
System.out.println(filePath); // check if there are any extra characters or spaces
File file4 = new File(filePath);
if(file4.exists()) {
    Image image4 = new Image(file4.toURI().toString());
    show_pass.setImage(image4);
} else {
    System.out.println("Image file not found!");
}
if (pass_vis ==0)
{mdp_ajout.setVisible(false);
tfMdp_ajout.setVisible(true);
}
else
{
mdp_ajout.setVisible(true);
tfMdp_ajout.setVisible(false);
}
    }    

    @FXML
    private void AjoutUser(ActionEvent event) throws IOException {
      
      System.out.println(cbType_ajout.getValue());
      System.out.println(Integer.parseInt(cbEtat_ajout.getValue()));
        Utilisateur u = new Utilisateur(tfNom_ajout.getText(),tfPrenom_ajout.getText(),tfEmail_ajout.getText(),tfMdp_ajout.getText(),tfaddress_ajout.getText(),Integer.parseInt(tfNum_ajout.getText()),cbType_ajout.getValue(),s,Integer.parseInt(cbEtat_ajout.getValue()));
      boolean check1=true,check2=true,check3=true,check5=true,check6=true;
      if (u.getNom().matches(".*\\d+.*")==true||!Character.isUpperCase(u.getNom().charAt(0)))
      {
      check1=false;
      tfNom_ajout.setStyle("-fx-background-color: #ff0000;");
      if (!Character.isUpperCase(u.getNom().charAt(0)))
      e_nom.setText("* Nom doit commence par Majuscule");
      else
      {e_nom.setText("* Nom Contenir des chiffres");}
      }
     else {
       check1=true;
      tfNom_ajout.setStyle("-fx-background-color: #ffffff;");
      e_nom.setText("");
      
      
      
      }
      if (u.getPrenom().matches(".*\\d+.*")==true||!Character.isUpperCase(u.getPrenom().charAt(0)))
      {
      check2=false;
      tfPrenom_ajout.setStyle("-fx-background-color: #ff0000;");
        if (!Character.isUpperCase(u.getPrenom().charAt(0)))
      e_prenom.setText("* Prenom doit commence par Majuscule");
      else
      {e_prenom.setText("* Prenom Contenir des chiffres");}
      
      }
       else {
       check2=true;
      tfPrenom_ajout.setStyle("-fx-background-color: #ffffff;");
      e_prenom.setText("");
      
      
      
      }
      if (!Integer.toString(u.getNum()).matches(".*\\d+.*")==true)
      {
      check3=false;
      tfNum_ajout.setStyle("-fx-background-color: #ff0000;");
      }
       else {
       check3=true;
      tfNum_ajout.setStyle("-fx-background-color: #ffffff;");
      e_num.setText("");
      
      
      
      }
      if (u.getMdp().length()<8)
      {
      check5=false;
      tfMdp_ajout.setStyle("-fx-background-color: #ff0000;");
       e_mdp.setText("* Mdp doit être > 8");
      }
       else {
       check5=true;
      tfMdp_ajout.setStyle("-fx-background-color: #ffffff;");
      e_mdp.setText("");
      
      
      
      }
       boolean check_mdp=false;
      if (tfMdp_ajout.getText().equals(Confirm_mdp_ajout.getText()))
      {
       check_mdp=true;
        conf.setText("");
      tfMdp_ajout.setStyle("-fx-background-color: #ffffff;");
       Confirm_mdp_ajout.setStyle("-fx-background-color: #ffffff;");
      }
      else {
      check_mdp=false;
         Confirm_mdp_ajout.setStyle("-fx-background-color: #ff0000;");
         tfMdp_ajout.setStyle("-fx-background-color: #ff0000;");
         conf.setText("Veuillez confirmer votre mot de pass !");
         
      }
      if (u.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")==false)
      {
      check6=false;
      tfEmail_ajout.setStyle("-fx-background-color: #ff0000;");
       e_email.setText("* Email format incorrect");
      }
       else {
       check6=true;
      tfEmail_ajout.setStyle("-fx-background-color: #ffffff;");
      e_email.setText("");
      
      
      
      }
     if (check1&&check2&&check3&&check5&&check6&&check_mdp)
     {ServiceUtilisateur su = new ServiceUtilisateur();
       su.ajouter(u);
    Stage stage = (Stage) btnAjout.getScene().getWindow();
    stage.close();   
 firstInterface.update();}
        
    }

    @FXML
    private void AddImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
File selectedFile = fileChooser.showOpenDialog(null);
        
        s=selectedFile.toString();
        System.out.println(s);
    }

    @FXML
    private void show(MouseEvent event) {
         if (pass_vis==0)
        {pass_vis=1;
        mdp_ajout.setVisible(true);
tfMdp_ajout.setVisible(false);
mdp_ajout.setText(tfMdp_ajout.getText());
        }
        else if (pass_vis==1)
        {pass_vis=0;
        tfMdp_ajout.setText(mdp_ajout.getText());
        mdp_ajout.setVisible(false);
tfMdp_ajout.setVisible(true);}
    }
    
    
    
}
