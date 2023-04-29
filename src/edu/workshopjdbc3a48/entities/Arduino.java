package edu.workshopjdbc3a48.entities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */


    import javafx.application.Application;
import javafx.stage.Stage;
import edu.workshopjdbc3a48.entities.SerialPortApp;
import static javafx.application.Application.launch;
    
public class Arduino extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        SerialPortApp serialPortApp = new SerialPortApp("com11"); // Remplacez "COM11" par le nom de votre port série
        // Attendre pendant quelques secondes pour que la classe SerialPortApp commence à écouter les données du port série
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         // Fermer le port série
    }

    public static void main(String[] args) {
        launch(args);
    }
}


