/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interface1.gui;
import edu.workshopjdbc3a48.entities.Dyanamic_QR;
import edu.workshopjdbc3a48.entities.CombineImages;
import edu.workshopjdbc3a48.entities.Categorie;
import edu.workshopjdbc3a48.entities.Don;
import edu.workshopjdbc3a48.entities.BarCode;
import static edu.workshopjdbc3a48.entities.Read_File.read_a_file;
import edu.workshopjdbc3a48.services.ServiceCategorie;
import edu.workshopjdbc3a48.services.ServiceDon;
import edu.workshopjdbc3a48.utils.DataSource;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import java.io.File;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;

import jxl.Workbook;
import org.dom4j.SetTextTest;


/**
 * FXML Controller class
 *
 * @author msi
 */
public class Interface_donnController implements Initializable {
String s;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnAdd;
    @FXML
    private TableView<Don> table;
    @FXML
    private TableColumn<Don,String> Id_BenC;
    @FXML
    private TableColumn<Don,String> TitreC;
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
    private TableColumn<Don,ImageView> ImageC;
    @FXML
    private ComboBox<String> txtId_cat_id;
    @FXML
    private TextField txtType;
    @FXML
    private TextField txtId_local;
    @FXML
    private TextField txtId_Ben;
    @FXML
    private TextField txtTitre;
    @FXML
    private TextField txtQte;
    @FXML
    private TextField txtType1;
    private TextField txtId_local1;
    private TextField txtId_cat_id1;
    @FXML
    private Button txtImge;
    @FXML
    private AnchorPane txtDate;
    @FXML
    private DatePicker txtDatee;
    @FXML
    private ImageView img;
    @FXML
    private Button btnAdd1;
    @FXML
    private TableView<Categorie> table1;
    @FXML
    private TableColumn<Categorie, String> Type_CatColmn;
    @FXML
    private TableColumn<Categorie, String> Des_CatColmn;
    @FXML
    private TableColumn<Categorie, String> NomColmn;
    @FXML
    private Button btnUpdate1;
    @FXML
    private Button btnDelete1;
    @FXML
    private TextField txtNom1;
    @FXML
    private TextField txtDes1;
    @FXML
    private TextField searchBar;
    @FXML
    private Button btnStat;
    @FXML
    private Button btnBack;
    @FXML
    private Button QR;
    @FXML
    private TextField qr_text;
    @FXML
    private Button excel;
    @FXML
    private Button excelCat;
   
    @FXML
    private Button combine;
    @FXML
    private TextField txtcombine;
    @FXML
    private Button cod_bar;
    @FXML
    private Button facebook;
    @FXML
    private Button email;
    @FXML
    private Button email1;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        searchBar.setOnKeyReleased(this::searchDon);
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
        
        table();
        affimage("C:\\Users\\msi\\Downloads\\workshopJDBC3A48\\workshopJDBC3A48\\src\\11.jpg");
        table1();
        
        
        
    
    }

    @FXML
    private void Uapdate_Don(ActionEvent event) {
       
    int myIndex = table.getSelectionModel().getSelectedIndex();
    int id = table.getItems().get(myIndex).getId();
    int idBen = Integer.parseInt(txtId_Ben.getText());
    String titre = txtTitre.getText();
    int qte = Integer.parseInt(txtQte.getText());
    String type = txtType.getText();
    String date = txtDatee.getValue().toString();
    int idLocal = Integer.parseInt(txtId_local.getText());
   
    int idCatId = Integer.parseInt(txtId_cat_id.getValue());
    String imge = s;
    
    ServiceDon sp = new ServiceDon();
    Don d = new Don(id, idBen, titre, qte, type, date, idLocal, idCatId, imge);
   boolean check,check2,check3,check4,check5,check6,check7;
if (d.getTitre().isEmpty()||d.getTitre().matches(".*\\d+.*")==true||!Character.isUpperCase(d.getTitre().charAt(0))||d.getTitre().length()<3)
{check=false;
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Alerte");
alert.setHeaderText(null);
alert.setContentText("Fomrat Titre");
alert.showAndWait();}
else check=true;




if (Integer.toString(d.getQte()).matches(".*\\d+.*")==false||Integer.toString(d.getQte()).isEmpty()||d.getQte()<100)
{ check2=false;
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Alerte");
alert.setHeaderText(null);
alert.setContentText("Fomrat Qte");
alert.showAndWait();
}
else{check2=true;}

if (!Integer.toString(d.getId_ben()).matches(".*\\d+.*")==true||Integer.toString(d.getId_ben()).isEmpty()||d.getId_ben()<100)
{ check3=false;
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Alerte");
alert.setHeaderText(null);
alert.setContentText("Fomrat ID_ben");
alert.showAndWait();
}
else{check3=true;}


if (!Integer.toString(d.getId_local()).matches(".*\\d+.*")==true||Integer.toString(d.getId_local()).isEmpty()||d.getId_local()<100)
{ check4=false;
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Alerte");
alert.setHeaderText(null);
alert.setContentText("Fomrat Local");
alert.showAndWait();
}
else{check4=true;}

if (d.getType().matches(".*\\d+.*")==true||!Character.isUpperCase(d.getType().charAt(0))||d.getType().isEmpty()||d.getType().length()<3)
{check5=false;
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Alerte");
alert.setHeaderText(null);
alert.setContentText("Fomrat type");
alert.showAndWait();}
else check5=true;



if (d.getImge().isEmpty()||d.getImge().length()<3)
{check6=false;
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Alerte");
alert.setHeaderText(null);
alert.setContentText("Fomrat imge");
alert.showAndWait();}
else check6=true;

if (d.getDate().isEmpty()||d.getDate().length()<3)
{check7=false;
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Alerte");
alert.setHeaderText(null);
alert.setContentText("Fomrat Date");
alert.showAndWait();}
else check7=true;








if (check==true&&check2==true&&check3==true&&check4==true&&check5==true&&check6==true&&check7==true)
{sp.modifier(d, id);}
    
    table();
    
}

    

    @FXML
    private void Delete_Don(ActionEvent event) {
         
        int myIndex = table.getSelectionModel().getSelectedIndex();
       int id = table.getItems().get(myIndex).getId();
        ServiceDon sp = new ServiceDon();
                
                sp.supprimer(id);
              
             
                table();
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
    boolean check,check2,check3,check4,check5,check6,check7;
  
if (d.getTitre().isEmpty()||d.getTitre().matches(".*\\d+.*")==true||!Character.isUpperCase(d.getTitre().charAt(0))||d.getTitre().length()<3)
{check=false;
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Alerte");
alert.setHeaderText(null);
alert.setContentText("Fomrat Titre");
alert.showAndWait();}
else check=true;




if (Integer.toString(d.getQte()).matches(".*\\d+.*")==false||Integer.toString(d.getQte()).isEmpty()||d.getQte()<100)
{ check2=false;
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Alerte");
alert.setHeaderText(null);
alert.setContentText("Fomrat Qte");
alert.showAndWait();
}
else{check2=true;}

if (!Integer.toString(d.getId_ben()).matches(".*\\d+.*")==true||Integer.toString(d.getId_ben()).isEmpty()||d.getId_ben()<100)
{ check3=false;
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Alerte");
alert.setHeaderText(null);
alert.setContentText("Fomrat ID_ben");
alert.showAndWait();
}
else{check3=true;}


if (!Integer.toString(d.getId_local()).matches(".*\\d+.*")==true||Integer.toString(d.getId_local()).isEmpty()||d.getId_local()<100)
{ check4=false;
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Alerte");
alert.setHeaderText(null);
alert.setContentText("Fomrat Local");
alert.showAndWait();
}
else{check4=true;}

if (d.getType().matches(".*\\d+.*")==true||!Character.isUpperCase(d.getType().charAt(0))||d.getType().isEmpty()||d.getType().length()<3)
{check5=false;
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Alerte");
alert.setHeaderText(null);
alert.setContentText("Fomrat type");
alert.showAndWait();}
else check5=true;



if (d.getImge().isEmpty()||d.getImge().length()<3)
{check6=false;
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Alerte");
alert.setHeaderText(null);
alert.setContentText("Fomrat imge");
alert.showAndWait();}
else check6=true;

if (d.getDate().isEmpty()||d.getDate().length()<3)
{check7=false;
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Alerte");
alert.setHeaderText(null);
alert.setContentText("Fomrat Date");
alert.showAndWait();}
else check7=true;







if (check==true&&check2==true&&check3==true&&check4==true&&check5==true&&check6==true&&check7==true)
{serviceDon.ajouter(d);}

    
    table();
    }
public void table() {
    ObservableList<Don> dons = FXCollections.observableArrayList();
    ServiceDon serviceDon = new ServiceDon();
    dons.addAll(serviceDon.getAll());

    table.setItems(dons);

   // Id_BenC.setCellValueFactory(f -> new SimpleIntegerProperty(f.getValue().getId_ben()).asString());
    TitreC.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getTitre()));
    QteC.setCellValueFactory(f -> new SimpleIntegerProperty(f.getValue().getQte()).asString());
    TypeC.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getType()));
    DateC.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getDate()));
 //   Id_localC.setCellValueFactory(f -> new SimpleIntegerProperty(f.getValue().getId_local()).asString());

    ImageC.setCellValueFactory(f -> {
    String imagePath = f.getValue().getImge();
    
    ImageView imageView = new ImageView(new Image(new File(imagePath).toURI().toString()));
    imageView.setFitHeight(100); // ajuster la hauteur de l'image
    imageView.setFitWidth(100); // ajuster la largeur de l'image
    return new SimpleObjectProperty<>(imageView);
});

    table.setRowFactory(tv -> {
        TableRow<Don> myRow = new TableRow<>();
        myRow.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                int myIndex = table.getSelectionModel().getSelectedIndex();
              //  int idBen = table.getItems().get(myIndex).getId_ben();
                String titre = table.getItems().get(myIndex).getTitre();
                int qte = table.getItems().get(myIndex).getQte();
                String type = table.getItems().get(myIndex).getType();
                String date = table.getItems().get(myIndex).getDate();
               // int idLocal = table.getItems().get(myIndex).getId_local();
                //int idCatId = table.getItems().get(myIndex).getId_cat_id();
                String imge = table.getItems().get(myIndex).getImge();
               
                affimage(imge);
                int idqrcode=table.getItems().get(myIndex).getId();
               // txtId_Ben.setText(Integer.toString(idBen));
                txtTitre.setText(titre);
                txtQte.setText(Integer.toString(qte));
                txtType.setText(type);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         LocalDate datee = LocalDate.parse(date, formatter);
      
               txtDatee.setValue(datee);
           //     txtId_local.setText(Integer.toString(idLocal));
           //     txtId_cat_id.setValue(Integer.toString(idCatId));
                txtImge.setText(s);
                qr_text.setText(Integer.toString(idqrcode));
                txtcombine.setText(imge);
                
            }
        });
        return myRow;
    });
    
    
}


@FXML
    private void AddImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
File selectedFile = fileChooser.showOpenDialog(null);
        
        s=selectedFile.toString();
        System.out.println(s);
        
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

    @FXML
    private void Add_cat(ActionEvent event) {
           String nom,type_cat,type_des;
            nom = txtNom1.getText();
            type_cat = txtType1.getText();
            type_des= txtDes1.getText();
            ServiceCategorie sp = new ServiceCategorie();
                Categorie C = new Categorie(nom,type_cat,type_des);
                
              boolean check,check2,check3;  
                if (C.getNom().matches(".*\\d+.*")==true||!Character.isUpperCase(C.getNom().charAt(0))||C.getNom().isEmpty()||C.getNom().length()<3)
    {check=false;
Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Alerte");
alert.setHeaderText(null);
alert.setContentText("Fomrat Nom");
alert.showAndWait();}
else check=true;
                
 if (C.getType_cat().matches(".*\\d+.*")==true||!Character.isUpperCase(C.getType_cat().charAt(0))|| C.getType_cat().isEmpty()||C.getType_cat().length()<3)
{check2=false;
Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Alerte");
alert.setHeaderText(null);
alert.setContentText("Fomrat Type_Cat");
alert.showAndWait();}
 
else check2=true;
               
 if (C.getDes_cat().matches(".*\\d+.*")==true||!Character.isUpperCase(C.getDes_cat().charAt(0))||C.getDes_cat().isEmpty()||C.getDes_cat().length()<3)
{check3=false;
Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Alerte");
alert.setHeaderText(null);
alert.setContentText("Fomrat Des_cat");
alert.showAndWait();}
else check3=true;
                if (check==true&&check2==true&&check3==true)         
                { sp.ajouter(C);}
             
              
                table1();
            
            txtNom1.setText("");
            txtType1.setText("");
            txtDes1.setText("");
            txtNom1.requestFocus();
            
            
            
    }
    
    public void table1() {
        ObservableList<Categorie> categories = FXCollections.observableArrayList();
        ServiceCategorie sp = new ServiceCategorie();
        categories.addAll(sp.getAll());

        table1.setItems(categories);
        
        Type_CatColmn.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getType_cat()));
        Des_CatColmn.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getDes_cat()));
        NomColmn.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getNom()));

        table1.setRowFactory(tv -> {
            TableRow<Categorie> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    int myIndex = table1.getSelectionModel().getSelectedIndex();
                    int id = table1.getItems().get(myIndex).getId();
                    String name = table1.getItems().get(myIndex).getNom();
                    String type_cat = table1.getItems().get(myIndex).getType_cat()   ;
                    String type_des = table1.getItems().get(myIndex).getDes_cat();
                    txtNom1.setText(name);
                    txtType1.setText(type_cat);
                    txtDes1.setText(type_des);
                }
            });
            return myRow;
        });
    }

    @FXML
    private void Update_cat(ActionEvent event) {
        int myIndex = table1.getSelectionModel().getSelectedIndex();
       int id = table1.getItems().get(myIndex).getId();
      String nom = txtNom1.getText();
            String type_cat = txtType1.getText();
            String type_des= txtDes1.getText();
            ServiceCategorie sp = new ServiceCategorie();
            Categorie C = new Categorie(nom,type_cat,type_des);
             boolean check,check2,check3;  
                   if (C.getNom().matches(".*\\d+.*")==true||!Character.isUpperCase(C.getNom().charAt(0))||C.getNom().isEmpty()||C.getNom().length()<3)
    {check=false;
Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Alerte");
alert.setHeaderText(null);
alert.setContentText("Fomrat Nom");
alert.showAndWait();}
else check=true;
                
 if (C.getType_cat().matches(".*\\d+.*")==true||!Character.isUpperCase(C.getType_cat().charAt(0))|| C.getType_cat().isEmpty()||C.getType_cat().length()<3)
{check2=false;
Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Alerte");
alert.setHeaderText(null);
alert.setContentText("Fomrat Type_Cat");
alert.showAndWait();}
 
else check2=true;
               
 if (C.getDes_cat().matches(".*\\d+.*")==true||!Character.isUpperCase(C.getDes_cat().charAt(0))||C.getDes_cat().isEmpty()||C.getDes_cat().length()<3)
{check3=false;
Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Alerte");
alert.setHeaderText(null);
alert.setContentText("Fomrat Des_cat");
alert.showAndWait();}
else check3=true;
                if (check==true&&check2==true&&check3==true)    
                {sp.modifier(C,id);}
            table1();
    }

    @FXML
    private void Delete_cat(ActionEvent event) {
        int myIndex = table1.getSelectionModel().getSelectedIndex();
       int id = table1.getItems().get(myIndex).getId();
        ServiceCategorie sp = new ServiceCategorie();
                
                sp.supprimer(id);
              
             
                table1();
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
    private void Stat(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("stat.fxml"));
    }

    @FXML
    private void Back(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("afficher.fxml"));
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException ex) {
                Logger.getLogger(AfficherController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
          stage.show();
    }

    @FXML
    private void QR_press(ActionEvent event) {
       
          int id = Integer.parseInt(qr_text.getText());
          
    Dyanamic_QR qr = new Dyanamic_QR();
    String image=qr.generateQRCode(id);
        affimage(image);
        System.out.println(image);

        
    }

    @FXML
    private void excel_press(ActionEvent event) {
        Connection cnx = DataSource.getInstance().getCnx();
      

        WritableWorkbook wworkbook;
        try {
            wworkbook = Workbook.createWorkbook(new File("C:\\Users\\msi\\Desktop\\workshopJDBC3A48\\src\\EXCEL\\mahdii.xls"));

            String req = "SELECT * FROM don";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            WritableSheet wsheet = wworkbook.createSheet("First Sheet", 0);
           
            jxl.write.Label label = new jxl.write.Label(0, 0, "id_ben");
            wsheet.addCell(label);
            label = new jxl.write.Label(1, 0, "titre");
            wsheet.addCell(label);
            label = new jxl.write.Label(2, 0, "qte");
            wsheet.addCell(label);
             label = new jxl.write.Label(3, 0, " type ");
            wsheet.addCell(label);
             label = new jxl.write.Label(4, 0, "date");
            wsheet.addCell(label);
             label = new jxl.write.Label(5, 0, " id_local ");
            wsheet.addCell(label);
             label = new jxl.write.Label(6, 0, "id_cat_id ");
            wsheet.addCell(label);
 label = new jxl.write.Label(7, 0, "imge");
            wsheet.addCell(label);


            int row = 1;
            while (rs.next()) {
                int col = 0;
               
              
                label = new jxl.write.Label(col++, row, rs.getString(1));
                wsheet.addCell(label);
                label = new jxl.write.Label(col++, row, rs.getString(2));
                wsheet.addCell(label);
                label = new jxl.write.Label(col++, row, rs.getString(3));
                wsheet.addCell(label);
                label = new jxl.write.Label(col++, row, rs.getString(4));
                wsheet.addCell(label);
                label = new jxl.write.Label(col++, row, rs.getString(5));
                wsheet.addCell(label);
                label = new jxl.write.Label(col++, row, rs.getString(6));
                wsheet.addCell(label);
                label = new jxl.write.Label(col++, row, rs.getString(7));
                wsheet.addCell(label);
                label = new jxl.write.Label(col++, row, rs.getString(8));
                wsheet.addCell(label);
                

                row++;
            }

            wworkbook.write();
            wworkbook.close();
            System.out.println("Excel file generated successfully.");

        } catch (Exception e) {
            System.out.println("An error occurred while generating the Excel file: " + e.getMessage());
        }
    }

    private void excelCAT_press(ActionEvent event) {
         Connection cnx = DataSource.getInstance().getCnx();


        WritableWorkbook wworkbook;
        try {
            wworkbook = Workbook.createWorkbook(new File("C:\\Users\\msi\\Desktop\\workshopJDBC3A48\\src\\EXCEL\\Categorie.xls"));

            String req = "SELECT * FROM categorie";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            WritableSheet wsheet = wworkbook.createSheet("First Sheet", 0);
           
            jxl.write.Label label = new jxl.write.Label(0, 0, "Nom");
            wsheet.addCell(label);
            label = new jxl.write.Label(1, 0, "Description");
            wsheet.addCell(label);
            label = new jxl.write.Label(2, 0, "Date création");
            wsheet.addCell(label);

            int row = 1;
            while (rs.next()) {
                int col = 0;
               
              
                label = new jxl.write.Label(col++, row, rs.getString(2));
                wsheet.addCell(label);
                label = new jxl.write.Label(col++, row, rs.getString(3));
                wsheet.addCell(label);
                label = new jxl.write.Label(col++, row, rs.getString(4));
                wsheet.addCell(label);

                row++;
            }

            wworkbook.write();
            wworkbook.close();
            System.out.println("Excel file generated successfully.");

        } catch (Exception e) {
            System.out.println("An error occurred while generating the Excel file: " + e.getMessage());
        }
    }

    @FXML
    private void combin_press(ActionEvent event) {
    
        
   File image2File = new File(txtcombine.getText());
   String titre = txtTitre.getText();
   CombineImages combine= new CombineImages();
   combine.Combine(image2File, titre);
   
           
            
            
            }

     @FXML
    private void email_press(ActionEvent event) {
    }
    
    @FXML
    private void codbar_press(ActionEvent event) {
         int id = Integer.parseInt(qr_text.getText());
          
  BarCode br = new BarCode();
    String image=br.Barcodecreat(id);
        affimage(image);
        System.out.println(image);
    }

    @FXML
    private void facebook_press(ActionEvent event) {
         String titre =(txtTitre.getText());
        Partage_facebookController p=new Partage_facebookController();
        p.shareOnFacebook(titre);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Alerte");
alert.setHeaderText(null);
alert.setContentText("partage avec succes");
alert.showAndWait();
                
                
    }

    @FXML
    private void pdf_press(ActionEvent event) {
        ServiceDon don =new ServiceDon();
        don.recupererpdf();
        
    }
    
    

   
}
