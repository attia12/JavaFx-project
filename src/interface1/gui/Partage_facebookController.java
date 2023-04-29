/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interface1.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.FacebookType;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class Partage_facebookController implements Initializable {

    @FXML
    private TextArea postText;
    @FXML
    private Button Partager;

    private static final String PAGE_ACCESS_TOKEN = "EAASN2IdMGEEBALJwPgfaevUUXgaHh1NU2DZBpkDrWZAlqwVKnXfnarDenVleqlMy73SM5m3O2NhqpAtAfE9kfhRSFBFhpIQ123ffSgXAZC8jrDQzwS1eKNbK9Fqj3AjY8rATKS93wwVwqinO5cpzNOoaEZBVgBryBZCOQkyfpEK35WDijKQZBaQY6UZC7fvf1uq3aoQtoVaFzANrEVFlGFW";
    private static final String API_VERSION = "v12.0";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Partager(ActionEvent event) {
        String postContent = postText.getText();
        shareOnFacebook(postContent);
    }

    public void shareOnFacebook(String postContent) {
        FacebookClient facebookClient = new DefaultFacebookClient(PAGE_ACCESS_TOKEN, Version.getVersionFromString(API_VERSION));
        facebookClient.publish("me/feed", FacebookType.class, Parameter.with("message", postContent));

        System.out.println("Post partagé avec succès sur Facebook");
        
    }

}
