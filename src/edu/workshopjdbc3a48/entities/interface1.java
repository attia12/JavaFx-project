package edu.workshopjdbc3a48.entities;

import java.io.IOException;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class interface1 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("arduino.fxml"));
            Scene scene = new Scene(root);

            primaryStage.setTitle("My JavaFX Application");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
