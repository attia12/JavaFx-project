/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.UserDetails;
import entities.medicament;
import entities.categorie;
import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import services.categorieService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;
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
import javafx.scene.input.MouseEvent;
import services.medicamentService;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.twilio.rest.api.v2010.account.message.Media;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.MediaPlayer;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import services.Pdf2;


import java.nio.file.Paths;
import java.util.Optional;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Pagination;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;















/**
 * FXML Controller class
 *
 * @author asus
 */
public class AjoutermedicamentController implements Initializable {

    @FXML
    private TextField descriptionmedicField;
    @FXML
    private DatePicker datemedicField;
    @FXML
    private TextField typemedicField;
    @FXML
    private TextField imagemedicField;
    @FXML
    private TextField nom_medicamentField;
    @FXML
    private Button supprimerBoutton;
    @FXML
    private Button ajouterButton;
    @FXML
    private Button afficherBoutton;
    @FXML
    private Button goToPong;
    @FXML
private VBox root;
  
    @FXML
    private TableView<medicament> medicamentTv;
    @FXML
    private TableColumn<medicament, String> nommedicTv;
    @FXML
    private TableColumn<medicament, String> typemedicTv;
    @FXML
    private TableColumn<medicament, String> imagemedicTv;
    @FXML
    private TableColumn<medicament, String> datemedicTv;
    @FXML
    private TableColumn<medicament, String> descriptionmedicTv;
     @FXML
    private TableColumn<medicament, Integer> disponibleTv;
    @FXML
    private TextField disponibleField;
    
    private Date date1;
    @FXML
    private Label partError;
    @FXML
    private Label idLabel;
 
    ObservableList<medicament> medics;
    medicamentService Ev=new medicamentService();
    categorieService Pservice =new categorieService();
    Pdf2 oo=new Pdf2();
    
    @FXML
    private TextField idmodifierField;
    @FXML
    private Button participerbutton;
    @FXML
    private ImageView imageview;
    @FXML
    private TextField rechercher;
    @FXML
    private ImageView QrCode;
    @FXML
    private ImageView GoBackBtn;
    @FXML
    private Canvas myCanvas;

    
    /**
     * Initializes the controller class.
     */
@Override
public void initialize(URL url, ResourceBundle rb) {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Choix de l'action");
    alert.setHeaderText("Que voulez-vous faire ?");
    alert.setContentText("Voulez-vous passer à l'application ou choisir une musique ?");

    ButtonType buttonTypeApp = new ButtonType("Aller à l'application");
    ButtonType buttonTypeMusic = new ButtonType("Choisir une musique");

    alert.getButtonTypes().setAll(buttonTypeApp, buttonTypeMusic);

    Optional<ButtonType> result = alert.showAndWait();
    if (result.get() == buttonTypeApp){
        // Faire quelque chose pour passer à l'application
    } else if (result.get() == buttonTypeMusic) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionner un fichier audio");
        File defaultDirectory = new File("C:\\Users");
        fileChooser.setInitialDirectory(defaultDirectory);
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Fichiers audio (*.mp3, *.wav, *.flac)", "*.mp3", "*.wav", "*.flac");
        fileChooser.getExtensionFilters().add(extFilter);
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            javafx.scene.media.Media javafxMedia = new javafx.scene.media.Media(selectedFile.toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(javafxMedia);
            mediaPlayer.setAutoPlay(true);
        } else {
            System.out.println("Aucun fichier audio sélectionné.");
        }
    }

    partError.setVisible(false);
    //idLabel.setText("");
    getmedics(); 
    getmedicss(); 
}




    
  
     private boolean NoDate() {
         LocalDate currentDate = LocalDate.now();     
         LocalDate myDate = datemedicField.getValue(); 
         int comparisonResult = myDate.compareTo(currentDate);      
         boolean test = true;
        if (comparisonResult < 0) {
        // myDate est antérieure à currentDate
        test = true;
        } else if (comparisonResult > 0) {
         // myDate est postérieure à currentDate
         test = false;
        }
        return test;
    }
          @FXML
    private void ajoutermedicament(ActionEvent medic) {
    
         int part=0;
        if ((nom_medicamentField.getText().length() == 0) || (typemedicField.getText().length() == 0) || (imagemedicField.getText().length() == 0) || (disponibleField.getText().length() == 0)|| (descriptionmedicField.getText().length() == 0)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error ");
            alert.setHeaderText("Error!");
            alert.setContentText("Fields cannot be empty");
            alert.showAndWait();
        }
       else if (NoDate() == true) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error ");
            alert.setHeaderText("Error!");
            alert.setContentText("la date date doit être aprés la date d'aujourd'hui");
            alert.showAndWait();
        }
       else{     
            try {
                part = Integer.parseInt(disponibleField.getText());
                partError.setVisible(false);
            } catch (Exception exc) {
                System.out.println("Number of disponible int");
                partError.setVisible(true);
                return;
            }
            if(part<1)
            {Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error ");
            alert.setHeaderText("Error!");
            alert.setContentText("le code promo doit être suupp ou egale  à 10");
            alert.showAndWait();
            partError.setVisible(true);}
            else
            {
        medicament e = new medicament();
        if (typemedicField.getText().equals("Gold")) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Information");
    alert.setHeaderText("Prix de l'medicament");
    alert.setContentText("Le prix de cette medicament est 250 DT.");
    alert.showAndWait();
} else if (typemedicField.getText().equals("SILVER")) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Information");
    alert.setHeaderText("Prix de l'medicament");
    alert.setContentText("Le prix de cette medicament est 150 DT.");
    alert.showAndWait();
} else if (typemedicField.getText().equals("BRONZE")) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Information");
    alert.setHeaderText("Prix de l'medicament");
    alert.setContentText("Le prix de cette medicament est 100 DT.");
    alert.showAndWait();
}

        e.setNom_medicament(nom_medicamentField.getText());
        e.setType_medicament(typemedicField.getText());
        e.setDescription_medicament(descriptionmedicField.getText());
        java.util.Date date_debut=java.util.Date.from(datemedicField.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date sqlDate = new Date(date_debut.getTime());
        e.setDate(sqlDate);
        e.setDisponible(Integer.valueOf(disponibleField.getText()));
        
        //lel image
        e.setImage_medicament(imagemedicField.getText());      
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information ");
            alert.setHeaderText("medicament add");
            alert.setContentText("medicament added successfully!");
            alert.showAndWait();      
        try {
            Ev.ajoutermedicament(e);
            reset();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }      
        getmedics();
        getmedicss(); 
        

    }}}
    
    //fin d ajout d'un medicament
    private void reset() {
        nom_medicamentField.setText("");
        typemedicField.setText("");
        descriptionmedicField.setText("");
        imagemedicField.setText("");
        disponibleField.setText("");
        datemedicField.setValue(null);    
    }
    
   public void getmedics() {  
         try {
            // TODO
            List<medicament> medicaments = Ev.recuperermedicament();
            ObservableList<medicament> olp = FXCollections.observableArrayList(medicaments);
            medicamentTv.setItems(olp);
            nommedicTv.setCellValueFactory(new PropertyValueFactory("nom_medicament"));
            typemedicTv.setCellValueFactory(new PropertyValueFactory("type_medicament"));
            imagemedicTv.setCellValueFactory(new PropertyValueFactory("image_medicament"));
            datemedicTv.setCellValueFactory(new PropertyValueFactory("date"));
            descriptionmedicTv.setCellValueFactory(new PropertyValueFactory("description_medicament"));
            disponibleTv.setCellValueFactory(new PropertyValueFactory("disponible"));
            
            
           // this.delete();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }//get medics
 public void getmedicss() {  
    try {
        List<medicament> abonnements = Ev.recuperermedicament();
        int pageSize = 3;
        int pageCount = (int) Math.ceil((double) abonnements.size() / pageSize);
        Pagination pagination = new Pagination(pageCount, 0);
        
        pagination.currentPageIndexProperty().addListener((obs, oldIndex, newIndex) -> {
            int startIndex = newIndex.intValue() * pageSize;
            int endIndex = Math.min(startIndex + pageSize, abonnements.size());
            ObservableList<medicament> page = FXCollections.observableArrayList(abonnements.subList(startIndex, endIndex));
            medicamentTv.setItems(page);
        });
        nommedicTv.setCellValueFactory(new PropertyValueFactory("nom_medicament"));
        typemedicTv.setCellValueFactory(new PropertyValueFactory("type_medicament"));
        imagemedicTv.setCellValueFactory(new PropertyValueFactory("image_medicament"));
        datemedicTv.setCellValueFactory(new PropertyValueFactory("date"));
        descriptionmedicTv.setCellValueFactory(new PropertyValueFactory("description_medicament"));
       disponibleTv.setCellValueFactory(new PropertyValueFactory("disponible"));
        VBox root = new VBox(medicamentTv, pagination);
this.root.getChildren().setAll(root);
    } catch (SQLException ex) {
        System.out.println("error" + ex.getMessage());
    }
}
     
     @FXML
   private void modifiermedicament(ActionEvent medic) throws SQLException {
        medicament e = new medicament();
        e.setId_ab(Integer.valueOf(idmodifierField.getText()));
        e.setNom_medicament(nom_medicamentField.getText());
        e.setType_medicament(typemedicField.getText());
        e.setDescription_medicament(descriptionmedicField.getText()); 
        Date d=Date.valueOf(datemedicField.getValue());
        e.setDate(d);
        e.setImage_medicament(imagemedicField.getText());
        e.setDisponible(Integer.valueOf(disponibleField.getText()));         
        Ev.modifiermedicament(e);
        reset();
        getmedics();   
         getmedicss(); 
    }

    @FXML
    private void supprimermedicament(ActionEvent medic) {
           medicament e = medicamentTv.getItems().get(medicamentTv.getSelectionModel().getSelectedIndex());
        try {
            Ev.supprimermedicament(e);
        } catch (SQLException ex) {
            Logger.getLogger(AjoutermedicamentController.class.getName()).log(Level.SEVERE, null, ex);
        }   
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information ");
        alert.setHeaderText("medicament delete");
        alert.setContentText("medicament deleted successfully!");
        alert.showAndWait();        
        getmedics(); 
         getmedicss(); 
    }

    @FXML
    private void affichermedicament(ActionEvent medic) {
        try {
            //navigation
            Parent loader = FXMLLoader.load(getClass().getResource("affichermedicament.fxml"));
            typemedicField.getScene().setRoot(loader);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }   
    }

  
    @FXML
    //ta3 tablee bch nenzel 3ala wehed ya5tarou w yet3abew textfield
    private void choisirmedic(MouseEvent medic) throws IOException {
        medicament e = medicamentTv.getItems().get(medicamentTv.getSelectionModel().getSelectedIndex());     
        //idLabel.setText(String.valueOf(e.getid_ab()));
        idmodifierField.setText(String.valueOf(e.getId_ab()));
        nom_medicamentField.setText(e.getNom_medicament());
        typemedicField.setText(e.getType_medicament());
        imagemedicField.setText(e.getImage_medicament());
        descriptionmedicField.setText(e.getDescription_medicament());
        //datemedicField.setValue((e.getDate()));
        disponibleField.setText(String.valueOf(e.getDisponible()));       
        //lel image
        String path = e.getImage_medicament();
               File file=new File(path);
              Image img = new Image(file.toURI().toString());
                imageview.setImage(img);
                
        //////////////      
            String filename = Ev.GenerateQrmedic(e);
            System.out.println("filename lenaaa " + filename);
            String path1="C:\\xampp\\htdocs\\imgQr\\qrcode"+filename;
             File file1=new File(path1);
              Image img1 = new Image(file1.toURI().toString());
              //Image image = new Image(getClass().getResourceAsStream("src/utils/img/" + filename));
            QrCode.setImage(img1); 
            
    }

    private void participer(ActionEvent medic) {

        UserDetails u=new UserDetails();
        LocalDate dateActuelle = LocalDate.now();
        Date dateSQL = Date.valueOf(dateActuelle);
        categorie p=new categorie();
        p.setDate_part(dateSQL);
        //p.medicament();
        p.setId_medicament(Integer.parseInt(idmodifierField.getText()));
        p.setId_user(u.getId());
        Pservice.ajoutercategorie(p);
    }

    @FXML
    private void affichercategories(ActionEvent medic) {     
         try {
            //navigation
            Parent loader = FXMLLoader.load(getClass().getResource("affichercategorie.fxml"));
            typemedicField.getScene().setRoot(loader);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }    
    }

    @FXML
    private void uploadImage(ActionEvent medic)throws FileNotFoundException, IOException  {

        Random rand = new Random();
        int x = rand.nextInt(1000);
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload File Path");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File file = fileChooser.showOpenDialog(null);
        String DBPath = "C:\\\\xampp\\\\htdocs\\\\imageP\\\\"  + x + ".jpg";
        if (file != null) {
            FileInputStream Fsource = new FileInputStream(file.getAbsolutePath());
            FileOutputStream Fdestination = new FileOutputStream(DBPath);
            BufferedInputStream bin = new BufferedInputStream(Fsource);
            BufferedOutputStream bou = new BufferedOutputStream(Fdestination);
            System.out.println(file.getAbsoluteFile());
            String path=file.getAbsolutePath();
            Image img = new Image(file.toURI().toString());
            imageview.setImage(img);    
            imagemedicField.setText(DBPath);
            int b = 0;
            while (b != -1) {
                b = bin.read();
                bou.write(b);
            }
            bin.close();
            bou.close();          
        } else {
            System.out.println("error");
        }
    }

    @FXML
    private void excelmedic(ActionEvent medic) {
           
try{
String filename="C:\\xampp\\htdocs\\datamedic.xls" ;
    HSSFWorkbook hwb=new HSSFWorkbook();
    HSSFSheet sheet =  hwb.createSheet("new sheet");
    HSSFRow rowhead=   sheet.createRow((short)0);
rowhead.createCell((short) 0).setCellValue("nom medicament");
rowhead.createCell((short) 1).setCellValue("type d'medicament");
rowhead.createCell((short) 2).setCellValue("description ");
List<medicament> medicaments = Ev.recuperermedicament();
  for (int i = 0; i < medicaments.size(); i++) {          
HSSFRow row=   sheet.createRow((short)i);
row.createCell((short) 0).setCellValue(medicaments.get(i).getNom_medicament());
row.createCell((short) 1).setCellValue(medicaments.get(i).getType_medicament());
row.createCell((short) 2).setCellValue(medicaments.get(i).getDescription_medicament());
//row.createCell((short) 3).setCellValue((medicaments.get(i).getDate()));
i++;
            }
int i=1;
    FileOutputStream fileOut =  new FileOutputStream(filename);
hwb.write(fileOut);
fileOut.close();
System.out.println("Your excel file has been generated!");
 File file = new File(filename);
        if (file.exists()){ 
        if(Desktop.isDesktopSupported()){
            Desktop.getDesktop().open(file);
        }}       
} catch ( Exception ex ) {
    System.out.println(ex);
}
    }
    
    @FXML
    private void pdfmedic(ActionEvent medic) throws FileNotFoundException, SQLException, IOException {        
       // medicament tab_Recselected = medicamentTv.getSelectionModel().getSelectedItem();
               long millis = System.currentTimeMillis();
        java.sql.Date DateRapport = new java.sql.Date(millis);

        String DateLyoum = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(DateRapport);//yyyyMMddHHmmss
        System.out.println("Date d'aujourdhui : " + DateLyoum);

        com.itextpdf.text.Document document = new com.itextpdf.text.Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(String.valueOf(DateLyoum + ".pdf")));//yyyy-MM-dd
            document.open();
            Paragraph ph1 = new Paragraph("Voici un rapport détaillé de notre application qui contient tous les medicaments . Pour chaque medicament, nous fournissons des informations telles que la date d'Aujourd'hui :" + DateRapport );
            Paragraph ph2 = new Paragraph(".");
            PdfPTable table = new PdfPTable(4);
            //On créer l'objet cellule.
            PdfPCell cell;
            //contenu du tableau.
            table.addCell("nom_medicament");
            table.addCell("type_medicament");
            table.addCell("description_medicament");
            table.addCell("image_medicament");
             
            medicament r = new medicament();
            Ev.recuperermedicament().forEach(new Consumer<medicament>() {
                @Override
                public void accept(medicament e) {
                    table.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(String.valueOf(e.getNom_medicament()));
                    table.addCell(String.valueOf(e.getType_medicament()));
                    table.addCell(String.valueOf(e.getDescription_medicament()));
                    try {
    // Créer un objet Image à partir de l'image
    String path = e.getImage_medicament();
    com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance(path);
    
    // Définir la taille de l'image dans le tableau
    img.scaleToFit(100, 100); // Définir la largeur et la hauteur de l'image
    
    // Ajouter l'image à la cellule du tableau
    PdfPCell cell = new PdfPCell(img);
    table.addCell(cell);
} catch (Exception ex) {
    table.addCell("Erreur lors du chargement de l'image");
}
         }
            });
            document.add(ph1);
            document.add(ph2);
            document.add(table);
             } catch (Exception e) {
            System.out.println(e);
        }
        document.close();

        ///Open FilePdf
        File file = new File(DateLyoum + ".pdf");
        Desktop desktop = Desktop.getDesktop();
        if (file.exists()) //checks file exists or not  
        {
            desktop.open(file); //opens the specified file   
        }
    }
    
    @FXML
    private void recherchermedic(KeyEvent medic) {
        
        medicamentService bs=new medicamentService(); 
        medicament b= new medicament();
        ObservableList<medicament>filter= bs.cherchermedic(rechercher.getText());
        populateTable(filter);
    }
     private void populateTable(ObservableList<medicament> branlist){
       medicamentTv.setItems(branlist);
   
       }
       @FXML
    private void GoBk(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Statistics.fxml"));
            Parent root = loader.load();

            // Set the root of the current scene to the new FXML file
            GoBackBtn.getScene().setRoot(root);
    }
  
@FXML
private void goToPong(ActionEvent medic) {
    try {
            //navigation
            Parent loader = FXMLLoader.load(getClass().getResource("pppppp.fxml"));
            goToPong.getScene().setRoot(loader);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } // canvas est le nom de votre composant Canvas
}


    }


    





    

