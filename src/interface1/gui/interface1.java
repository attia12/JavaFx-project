package interface1.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class interface1 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("interface_donn.fxml"));
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
