/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author user
 */
public class DetailsWindowController implements Initializable {

    @FXML
    private TextField TextTitle;
    @FXML
    private TextField TextDescription;
    @FXML
    private TextField TextPublished;
    @FXML
    private TextField TextImage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void setTextTitle(String message) {
        this.TextTitle.setText(message);
    }

    public void setTextDescription(String message) {
        this.TextDescription.setText(message);
    }

    public void setTextPublished(String message) {
        this.TextPublished.setText(message);
    }

    public void setTextImage(String message) {
        this.TextImage.setText(message);
    }
}
