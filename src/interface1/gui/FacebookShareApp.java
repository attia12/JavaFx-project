/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package interface1.gui;

/**
 *
 * @author msi
 */
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.Arrays;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.restfb.DefaultFacebookClient;
import com.restfb.DefaultJsonMapper;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.FacebookType;

public class FacebookShareApp extends Application {

    private static final String APP_ID = "1281861029206081";
    private static final String APP_SECRET = "0c915c4e5a9790b5814f45149179135a";
    private static final String PAGE_ACCESS_TOKEN = "EAASN2IdMGEEBAJPx0UDr2u0DSv6IKsK6f6QBdl11rqE7A6hqNQqPzQgD38uZBKWgRfWYHkMZAZBlebWh5gh8y8lR1t1R7LdGr2R8K1lwSbkZBtSqBOE8ivGV0XbUAw1WM34gtZB5QDyc8lG8ZBb9yvnjh79aYCAmBR7nh5ULJTcHaZADx3iHshuwfzczqG0TxTG3fmBVxZCA6ZACH7ZBIQZCje7";
    private static final String PAGE_ID = "102749279478198";
    private static final String API_VERSION = "v12.0";
    private TextArea postText;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        VBox vbox = new VBox();
        postText = new TextArea();
        Button shareButton = new Button("Partager");
        shareButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String postContent = postText.getText();
                shareOnFacebook(postContent);
            }
        });
        vbox.getChildren().addAll(postText, shareButton);
        root.setCenter(vbox);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

   private void shareOnFacebook(String postContent) {
        FacebookClient facebookClient = new DefaultFacebookClient(PAGE_ACCESS_TOKEN, Version.getVersionFromString(API_VERSION));
        facebookClient.publish("me/feed", FacebookType.class, Parameter.with("message", postContent));

        System.out.println("Post partagé avec succès sur Facebook");
       
    }

    public static void main(String[] args) {
        launch(args);
    }
}