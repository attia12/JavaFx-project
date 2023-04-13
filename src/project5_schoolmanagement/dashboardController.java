/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project5_schoolmanagement;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import edu.esparit.services.ReclamationC;
import edu.esparit.services.ResponseC;
import edu.esprit.entities.Reclamation;
import edu.esprit.entities.Response;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author attia
 */
public class dashboardController implements Initializable {

    @FXML
    private AnchorPane navbar;
    @FXML
    private Circle circle;
    @FXML
    private Button home;
    @FXML
    private Button reclamation;
    @FXML
    private Button response;
    @FXML
    private Button data;
    @FXML
    private Button edit;
    @FXML
    private FontAwesomeIcon edit_icon;
    @FXML
    private Button cog_btn;
    @FXML
    private AnchorPane home_page;
    @FXML
    private AnchorPane total_student_card;
    @FXML
    private Label total_student;
    @FXML
    private AnchorPane total_enrolled_card;
    @FXML
    private Label total_enrolled;
    @FXML
    private AnchorPane total_graduated_card;
    @FXML
    private Label total_graduated;
    @FXML
    private AnchorPane total_inactive_card;
    @FXML
    private Label total_inactive;
    @FXML
    private AnchorPane student_page;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField description;
    @FXML
    private Button insert;
    @FXML
    private Button update;
    @FXML
    private Button clear;
    @FXML
    private Button delete;
    @FXML
    private TableView<Reclamation> table_view;
    @FXML
    private TableColumn<Reclamation, String> col_nom;
    @FXML
    private TableColumn<Reclamation, String> col_prenom;
    @FXML
    private TableColumn<Reclamation, String> col_email;
    @FXML
    private TableColumn<Reclamation, Integer> col_status;
    @FXML
    private TableColumn<Reclamation, String> col_description;
    @FXML
    private Button print;
    @FXML
    private TextField email;
    @FXML
    private AnchorPane record_page;
    @FXML
    private ComboBox<Reclamation> sr_current;
    @FXML
    private TableView<Response> sr_table_view;
    @FXML
    private TableColumn<?, ?> col_sr_id;
    @FXML
    private TableColumn<Response, Reclamation> col_sr_surname;
    @FXML
    private Button sr_clear;
    @FXML
    private AnchorPane data_page;
    @FXML
    private AnchorPane line_chart_page;
    @FXML
    private LineChart<?, ?> lineChart;
    @FXML
    private Button show_Chart_Button;
    @FXML
    private AnchorPane bar_chart_page;
    @FXML
    private BarChart<?, ?> barChart;
    @FXML
    private AnchorPane area_chart_page;
    @FXML
    private AreaChart<?, ?> areaChart;
    @FXML
    private AnchorPane nav_chart;
    @FXML
    private Button line_chart_button;
    @FXML
    private Button bar_chart_button;
    @FXML
    private Button area_chart_button;
    @FXML
    private AnchorPane logout_card;
    @FXML
    private Button logout_button;
    @FXML
    private Button insertresponse;
    @FXML
    private Button deleteresponse;
    @FXML
    private Button sr_update11;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void SRFieldDesign(){
        
        if(sr_current.isFocused()){
            
            sr_current.setStyle("-fx-background-color:#fff;"
                    + " -fx-border-width:2px");
            description1.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            
        }else if(description1.isFocused()){
            
            sr_current.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            description1.setStyle("-fx-background-color:#fff;"
                    + "-fx-border-width:2px");
            
        }else{
            
            sr_current.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            description1.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            
        }
        
    }
     
    @FXML
    private TextField description1;
    
    
    
     
    
   
    @FXML
     public void SRComboBox(){
         ReclamationC rc=new ReclamationC();
        
        //List<Reclamation> list = new ArrayList<>();
        List<Reclamation> listReclamation = new ArrayList<>();
        
        listReclamation=rc.getAll();
         
        

       /* for(Reclamation contain: listReclamation){
            
            list.add(contain);
            
        }*/
        
        ObservableList addData = FXCollections.observableArrayList(listReclamation);
        
        sr_current.setItems(addData);
        
        
          
        
    }
    public void navButton(){
        
        home.setOnMouseClicked((MouseEvent event) ->{
            
            home.setStyle("-fx-background-color:linear-gradient(to bottom right,"
                    + " rgba(121, 172, 255, 0.6), rgba(255, 106, 239, 0.6));"
                    + "-fx-border-color:linear-gradient(to bottom, #517ab5, #ae44a5);"
                    + "-fx-border-width:0px 0px 0px 5px");
            
            reclamation.setStyle("-fx-background-color:linear-gradient(to bottom right,"
                    + " rgba(121, 172, 255, 0.2), rgba(255, 106, 239, 0.2))");
            
            response.setStyle("-fx-background-color:linear-gradient(to bottom right,"
                    + " rgba(121, 172, 255, 0.2), rgba(255, 106, 239, 0.2))");
            
            data.setStyle("-fx-background-color:linear-gradient(to bottom right,"
                    + " rgba(121, 172, 255, 0.2), rgba(255, 106, 239, 0.2))");
        });
        
        reclamation.setOnMouseClicked((MouseEvent event) ->{
            
            home.setStyle("-fx-background-color:linear-gradient(to bottom right,"
                    + " rgba(121, 172, 255, 0.2), rgba(255, 106, 239, 0.2))");
            
            reclamation.setStyle("-fx-background-color:linear-gradient(to bottom right,"
                    + " rgba(121, 172, 255, 0.6), rgba(255, 106, 239, 0.6));"
                    + "-fx-border-color:linear-gradient(to bottom, #517ab5, #ae44a5);"
                    + "-fx-border-width:0px 0px 0px 5px");
            
            response.setStyle("-fx-background-color:linear-gradient(to bottom right,"
                    + " rgba(121, 172, 255, 0.2), rgba(255, 106, 239, 0.2))");
            
            data.setStyle("-fx-background-color:linear-gradient(to bottom right,"
                    + " rgba(121, 172, 255, 0.2), rgba(255, 106, 239, 0.2))");
        });
        
       response.setOnMouseClicked((MouseEvent event) ->{
            
            home.setStyle("-fx-background-color:linear-gradient(to bottom right,"
                    + " rgba(121, 172, 255, 0.2), rgba(255, 106, 239, 0.2))");
            
            reclamation.setStyle("-fx-background-color:linear-gradient(to bottom right,"
                    + " rgba(121, 172, 255, 0.2), rgba(255, 106, 239, 0.2))");
            
            response.setStyle("-fx-background-color:linear-gradient(to bottom right,"
                    + " rgba(121, 172, 255, 0.6), rgba(255, 106, 239, 0.6));"
                    + "-fx-border-color:linear-gradient(to bottom, #517ab5, #ae44a5);"
                    + "-fx-border-width:0px 0px 0px 5px");
            
            data.setStyle("-fx-background-color:linear-gradient(to bottom right,"
                    + " rgba(121, 172, 255, 0.2), rgba(255, 106, 239, 0.2))");
        });
        
        data.setOnMouseClicked((MouseEvent event) ->{
            
            home.setStyle("-fx-background-color:linear-gradient(to bottom right,"
                    + " rgba(121, 172, 255, 0.2), rgba(255, 106, 239, 0.2))");
            
            reclamation.setStyle("-fx-background-color:linear-gradient(to bottom right,"
                    + " rgba(121, 172, 255, 0.2), rgba(255, 106, 239, 0.2))");
            
            response.setStyle("-fx-background-color:linear-gradient(to bottom right,"
                    + " rgba(121, 172, 255, 0.2), rgba(255, 106, 239, 0.2))");
            
            data.setStyle("-fx-background-color:linear-gradient(to bottom right,"
                    + " rgba(121, 172, 255, 0.6), rgba(255, 106, 239, 0.6));"
                    + "-fx-border-color:linear-gradient(to bottom, #517ab5, #ae44a5);"
                    + "-fx-border-width:0px 0px 0px 5px");
        });
        
    }
    public boolean validationEmail(){
//        EXAMPLE: admin_123@marcoman.com [FIRST LETTER] [2ND LETTER TO NUMBER] @ [marcoman] . [com]
        Pattern pattern = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        
        Matcher match = pattern.matcher(email.getText());
        
        if(match.find() && match.group().equals(email.getText())){
            
            return true;
            
        }else{
            
            Alert alert = new Alert(AlertType.ERROR);
            
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Email");
            alert.showAndWait();
            
            return false;
            
        }
        
    }
    public boolean validatateInput(String input){
        
        Pattern pattern = Pattern.compile("[a-zA-Z ]*");
          Matcher match = pattern.matcher(input);
           return match.matches();
    
        
    
    
    }
     public void selectDataResponse(){
        
        int num = sr_table_view.getSelectionModel().getSelectedIndex();
         
        
        Response data1 = sr_table_view.getSelectionModel().getSelectedItem();
        
        if(num-1 < -1)
            return;
        
        description1.setText(data1.getDescription());
        sr_current.setValue(data1.getReclamationid());
        
        
        
        
    }
    
    public void defaultHomeDesign(){
        
        home.setStyle("-fx-background-color:linear-gradient(to bottom right,"
                    + " rgba(121, 172, 255, 0.6), rgba(255, 106, 239, 0.6));"
                    + "-fx-border-color:linear-gradient(to bottom, #517ab5, #ae44a5);"
                    + "-fx-border-width:0px 0px 0px 5px");
        
    }
    @FXML
    public void exit(){
        
        System.exit(0);
        
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        navButton();
        showData();
       
        SRComboBox();
        showResponseRecord();
        // TODO
    }    

    @FXML
    private void changePage(ActionEvent event) {
        if(home.isFocused()){
            
            home_page.setVisible(true);
            student_page.setVisible(false);
            record_page.setVisible(false);
            data_page.setVisible(false);
            
//            TO SEE IMMIDIATELY THE RECORD!
            //totalStudent();
           // totalGraduated();
            //totalEnrolled();
            //totalInactive();
            
            nav_chart.setVisible(false);
            
        }else if(reclamation.isFocused()){
            
            home_page.setVisible(false);
            student_page.setVisible(true);
            record_page.setVisible(false);
            data_page.setVisible(false);
            
            //showData();
            
            nav_chart.setVisible(false);
            
        }else if(response.isFocused()){
            
            home_page.setVisible(false);
            student_page.setVisible(false);
            record_page.setVisible(true);
            data_page.setVisible(false);
            
            //showStudentRecord();
            
            nav_chart.setVisible(false);
            
        }else if(data.isFocused()){
            
            home_page.setVisible(false);
            student_page.setVisible(false);
            record_page.setVisible(false);
            data_page.setVisible(true);
            
            nav_chart.setVisible(true);
            
        }
    }

    @FXML
    private void insertImage(ActionEvent event) {
    }

    @FXML
    private void openLogoutCard(MouseEvent event) {
    }

    private void exit(ActionEvent event) {
        exit();
    }

    @FXML
    private void textfieldRecord(MouseEvent event) {
    }

    @FXML
    private void textfieldRecord(KeyEvent event) {
    }

    @FXML
    private void insert(ActionEvent event) {
         if(nom.getText().isEmpty() | prenom.getText().isEmpty()
                    | email.getText().isEmpty() 
                    | description.getText().isEmpty()
                    )
             
         {
             
              Alert alert = new Alert(AlertType.ERROR);
                
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Enter all blank fields!");
                alert.showAndWait();
         
         
         
         
         }
         
         else {
            boolean isValid=validatateInput(nom.getText());
               if(nom.getText().length() < 2 || isValid==false ){Alert alert = new Alert(AlertType.ERROR);
                
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Invalid Nom");
                alert.showAndWait();} 
                else if(description.getText().length()<8){ Alert alert = new Alert(AlertType.ERROR);
                
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Invalid description");
                alert.showAndWait();}
               
           
          else {    
              if( validationEmail() )
           {
               
              
              
               
               
                String Nom=nom.getText();
        String Prenom=prenom.getText();
        String Email=email.getText();
        String Description=description.getText();
        Reclamation r=new Reclamation(Nom, Prenom, Email, Description);
        ReclamationC rc=new ReclamationC();
        rc.ajouter(r);
         Alert alert = new Alert(AlertType.INFORMATION);
                
                alert.setTitle("Insertion");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Inserted!");
                alert.showAndWait();
                
                 clear();
                 showData();
               
               
               }
             
            
                
         
             }
         
         }
    }
    @FXML
    public void clear(){
        
        nom.setText("");
        prenom.setText("");
        email.setText("");
       
        description.setText("");
        
        
    }
    public void clearResponse(){
        
        description1.setText("");
        sr_current.getSelectionModel().clearSelection();
        
        
    }
    public void showData(){
        ReclamationC rc=new ReclamationC();
        
        List<Reclamation> show = rc.getAll();
        ObservableList<Reclamation> observableShow = FXCollections.observableArrayList(show);
        
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        
        table_view.setItems( observableShow);
        
    }
    public void showResponseRecord(){
    ResponseC rc=new ResponseC();
    List<Response> showresponse=rc.getAll();
       // System.out.println(showresponse);
    ObservableList<Response> observableShow = FXCollections.observableArrayList(showresponse);
   
    
    col_sr_id.setCellValueFactory(new PropertyValueFactory<>("description"));
    col_sr_surname.setCellValueFactory(new PropertyValueFactory<>("reclamationid"));
    
   sr_table_view.setItems(observableShow);
    }
    @FXML
     public void selectData(){
        
        int num = table_view.getSelectionModel().getSelectedIndex();
         
        
        Reclamation data1 = table_view.getSelectionModel().getSelectedItem();
        
        if(num-1 < -1)
            return;
        
        nom.setText(data1.getNom());
        prenom.setText(data1.getPrenom());
        email.setText(data1.getEmail());
        description.setText(data1.getDescription());
        
    }
     
     

    @FXML
    private void update(ActionEvent event) {
        ReclamationC rc=new ReclamationC();
        
        
         if(nom.getText().isEmpty() | prenom.getText().isEmpty()
                    | email.getText().isEmpty() 
                    | description.getText().isEmpty() 
                    )
         {
            Alert alert = new Alert(AlertType.ERROR);
                
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Something wrong :3");
                alert.showAndWait();
         
         
         }
         else {
               
               
                Reclamation r = table_view.getSelectionModel().getSelectedItem();
        
             System.out.println(r);
             r.setNom(nom.getText());
             r.setPrenom(prenom.getText());
             r.setEmail(email.getText());
             r.setDescription(description.getText());
             
             
             
             rc.modifier(r);
             System.out.println(r);
             
             
             
             Alert alert = new Alert(AlertType.INFORMATION);
                
                alert.setTitle("Updated Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated!");
                alert.showAndWait();
                
                showData();
                clear();
         
         
         
         
         }
    }

    private void clear(ActionEvent event) {
        clear();
    }

    @FXML
    private void delete(ActionEvent event) {
        ReclamationC rc=new ReclamationC();
        
        Reclamation r = table_view.getSelectionModel().getSelectedItem();
        if(r.equals(null))
        {
          Alert alert = new Alert(AlertType.ERROR);
                
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Select REclamation to delete");
                alert.showAndWait();
        
        
        }
        else {
             Alert alert = new Alert(AlertType.CONFIRMATION);
                
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure?");
                
                Optional<ButtonType> option = alert.showAndWait();
                if(option.get() != ButtonType.OK)
                    
                    return;
                else {
                    
                    rc.supprimer(r.getId());
                
                
                }
                showData();
                clear();
                
        
        
        
        
        }
    }
    
    
    
    
    @FXML
     public void navigationChartButton(){
        
        if(line_chart_button.isFocused()){
            
            line_chart_page.setVisible(true);
            bar_chart_page.setVisible(false);
            area_chart_page.setVisible(false);
            
        }else if(bar_chart_button.isFocused()){
            
            line_chart_page.setVisible(false);
            bar_chart_page.setVisible(true);
            area_chart_page.setVisible(false);
            
        }else if(area_chart_button.isFocused()){
            
            line_chart_page.setVisible(false);
            bar_chart_page.setVisible(false);
            area_chart_page.setVisible(true);
            
        }
        
    }
     

    private void selectData(MouseEvent event) {
        selectData();
        
        
    }
    @FXML
    
    private void SRComboBox(ActionEvent event) {
        
      Reclamation reclamation=sr_current.getSelectionModel().getSelectedItem();
      //sr_current.setValue(reclamation);
    
        //SRComboBox();
        // System.out.println(reclamation);
          //sr_current.setItems((ObservableList<Reclamation>)sr_current.getSelectionModel().getSelectedItem());
      
      
         
         // System.out.println(recla);
        
       
    }
    

    @FXML
    private void print(ActionEvent event) {
        
    }
    
    private void SRFieldDesign(MouseEvent event) {
        SRFieldDesign();
    }

    private void SRFieldDesign(KeyEvent event) {
        SRFieldDesign();
    }
  
     

    @FXML
    private void StudentRecordUpdate(ActionEvent event) {
        ResponseC rc=new ResponseC();
         if(
                     description1.getText().isEmpty())
         {
              Alert alert = new Alert(AlertType.ERROR);
                
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Select the Response Data!");
                alert.showAndWait();
         
         
         }
         else {
             
             
                
                Response r = sr_table_view.getSelectionModel().getSelectedItem();
        
             System.out.println(r);
             r.setDescription(description1.getText());
             //r.setReclamationid(sr_current.getSelectionModel().getSelectedItem());
             
             
             
             
             
             rc.modifier(r);
             System.out.println(r);
             
             
             
             Alert alert = new Alert(AlertType.INFORMATION);
                
                alert.setTitle("Updated Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated!");
                alert.showAndWait();
                
                 showResponseRecord();
                clearResponse();
         
         
         
         
         
         
         }
        
        
        
    }

    @FXML
    private void selectStudentRecord(MouseEvent event) {
        selectDataResponse();
        
        
    }

    @FXML
    private void clearStudentRecord(ActionEvent event) {
        clearResponse();
    }

    @FXML
    private void showChart(ActionEvent event) {
    }

    private void navigationChartButton(ActionEvent event) {
        navigationChartButton();
    }

    @FXML
    private void logoutAccount(ActionEvent event) {
    }

    @FXML
    private void InsertResponse(ActionEvent event) {
        ResponseC rep=new ResponseC();
         if(description1.getText().isEmpty() | sr_current.getSelectionModel().isEmpty())
                    
                    
                    
         {
             
              Alert alert = new Alert(AlertType.ERROR);
                
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Enter all blank fields!");
                alert.showAndWait();
         
         
         
         
         
         
         
         
         }
         else {
             
             
             String Description=description1.getText();
             
             Reclamation reclamations=(Reclamation)sr_current.getSelectionModel().getSelectedItem();
             System.out.println(reclamations);
            
                     
             Response reponse=new Response(Description,reclamations);
              System.out.println(response);
              
             
             rep.ajouter(reponse);
              Alert alert = new Alert(AlertType.INFORMATION);
                
                alert.setTitle("Insertion");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Inserted!");
                alert.showAndWait();
                showResponseRecord();
                clearResponse();
                
                 
         
         
         
         }
        
    }

    @FXML
    private void deleteresponse(ActionEvent event) {
         ResponseC  rc=new ResponseC();
        
        Response r = sr_table_view.getSelectionModel().getSelectedItem();
        System.out.println(r);
        //System.out.println(r);
        
       
        if(r.equals(null))
        {
          Alert alert = new Alert(AlertType.ERROR);
                
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Select Response to delete");
                alert.showAndWait();
        
        
        }
        else {
             Alert alert = new Alert(AlertType.CONFIRMATION);
                
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure?");
                
                Optional<ButtonType> option = alert.showAndWait();
                if(option.get() != ButtonType.OK)
                    
                    return;
                else {
                    rc.supprimer(r.getId());
                
                
                }
                showResponseRecord();
                clearResponse();
                
        
        
        
        
        }
        
    }
    
    
}
