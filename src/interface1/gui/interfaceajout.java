/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package interface1.gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.Scene;


import javafx.stage.Stage;

/**
 *
 * @author msi
 */
public class interfaceajout extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        try{
          Parent root = FXMLLoader.load(getClass().getResource("ajout.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Don");
        primaryStage.setScene(scene);
        primaryStage.show();
        }catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}