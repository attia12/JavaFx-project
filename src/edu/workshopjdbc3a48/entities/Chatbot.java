/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.workshopjdbc3a48.entities;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.*;
import java.time.*;
import java.util.Optional;
import java.util.Scanner;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import java.awt.Desktop;
import java.io.IOException;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.*;

import javafx.scene.text.TextFlow;

import javafx.application.Application;
import javafx.scene.effect.InnerShadow;

import javafx.scene.effect.Reflection;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.Font;








/**
 *
 * @author rahul
 */
public class Chatbot extends Application {
    private JTextField textEnter;
    private JTextArea textchat;
    private TextField t1;
    private TextArea t2;
    private Button button;
    private Label label;
     private MediaPlayer mediaPlayer;
     private TextFlow f;
    private Stage stage2;
    private Stage stage3;
    private Stage stage4;
    private Scene change;
    private Scene scene;
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        stage2=primaryStage;
        stage3=primaryStage;
         textEnter=new JTextField();
         textchat=new JTextArea();
         t1=new TextField();
        t2=new TextArea();
       
        Text t = new Text();
t.setX(10.0f);
t.setY(50.0f);
t.setCache(true);
t.setText("santer Bot");
t.setFill(javafx.scene.paint.Color.DARKMAGENTA); 
t.setFont(Font.font(null, FontWeight.BOLD,35));

Reflection r = new Reflection();
r.setFraction(0.7);
t.setEffect(r);
 t.setLayoutY(5);
 t.setTranslateY(-310);
        
        
        
        
       f=new TextFlow(t2);
        t1.setMaxSize(500, 30);
        t2.setMaxSize(500,510);
        t2.setId("x");
    
        
       //t1.setAlignment(Pos.BOTTOM_CENTER);
       t2.setLayoutX(50);
       t2.setTranslateX(2.5);
       t1.setLayoutX(50);
       t1.setTranslateX(2);
       t1.setLayoutY(8);
       t1.setTranslateY(270);

        
        
        
      
       InnerShadow g=new InnerShadow();
           g.setRadius(2);
           g.setWidth(5);
           g.setColor(javafx.scene.paint.Color.BLUEVIOLET);
           t2.setEffect(g);
           
           InnerShadow g1=new InnerShadow();
           g1.setRadius(2);
           g1.setWidth(5);
           g1.setColor(javafx.scene.paint.Color.DARKMAGENTA);
           t1.setEffect(g1);
           
        t2.setEditable(false);
        t1.setEditable(true);
        t1.setId("y");
        button=new Button("Change Theme");
       
        button.setLayoutY(8);
        button.setTranslateY(300);
        button.setLayoutX(8);
        button.setTranslateX(-50);
        t1.setPromptText("Type here"); 
          t1.setOnAction((ActionEvent e)->{
              //Label utext=new Label();
             String utext=t1.getText();             
             
              t2.appendText("\nYou: "+utext+"\n\n");
               if(utext.contains("hi"))
                       {
                            
                           botSay("Hello !");
                       }
               
                       else if(utext.contains("How are You?")||utext.contains("How r u?"))
                       {
                           int decide=(int) (Math.random()*2+1);
                           if(decide==1)
                           {
                               botSay("I'm doing well,thanks!");
                           }
                           else if(decide==2)
                           {
                               botSay("Not too bad");
                           }
                           
                       }
               else if(utext.contains("tu fait quoi ?")||utext.contains("whats are u doing?") || utext.contains("whats going on?"))
                       {
                           int decide=(int) (Math.random()*4+1);
                           if(decide==1)
                           {
                               botSay("Im just talking with u! u shoul know it .. lol");
                           }
                           else if(decide==2)
                           {
                               botSay("read my previous reply!");
                           }
                       }
                       else if(utext.contains("temps")||utext.contains("What time is it now?")||utext.contains("Time"))
                       {
                           LocalTime now= LocalTime.now();
                           botSay("Here is is :"+now);
                       }
                       else if(utext.contains("date")||utext.contains("show me todays date")||utext.contains("today date")||utext.contains("date today"))
                       {
                           LocalDate today= LocalDate.now();
                           botSay("Here is the Result : "+today);
                       }
                       else if(utext.contains("who developed u?")||utext.contains("who created u?")||utext.contains("developer?"))
                       {
                           botSay("Mahdi dahmani!");
                       }
                     
                       else if(utext.contains("facebook"))
                       {
                           botSay("Sure sir!");
                                            try {
                    Desktop d=Desktop.getDesktop();
                     URI url=new URI("https://www.facebook.com/");
                     d.browse(url);
                 } catch (URISyntaxException ex) {
                     Logger.getLogger(Chatbot.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (IOException ex) {
                     Logger.getLogger(Chatbot.class.getName()).log(Level.SEVERE, null, ex);
                 }
                       }
                     
                      
                       
                          
                          
                          
                       
                      
                       else if(utext.contains("music")){
                          
                           final URL resource = getClass().getResource("main agar.mp3");
                           
          final Media media = new Media(resource.toString());
            mediaPlayer= new MediaPlayer(media);
             mediaPlayer.play();
            t1.requestFocus();
            t1.clear();
          utext=t1.getText();
          
         }
                       else if(utext.contains("pause"))
                       {
                           
                           botSay("Done sir!");
                 mediaPlayer.pause();
                           
                       }
                       else if(utext.contains("resume"))
                       {
                           botSay("okay..i resumed it!");
                           mediaPlayer.play();
                       }
                       else if(utext.contains("stop"))
                       {
                           botSay("okay..! i stopped the song");
                           mediaPlayer.stop();  
                       }
              
                       
//                     
                       else if(utext.contains("Don")||utext.contains("don"))
                       {
                           botSay("Action de donner, de céder quelque chose que l'on possède et, en particulier, action de donner de l'argent à quelqu'un, à une institution, une œuvre ; chose ou somme ainsi donnée, cadeau : ");
                       }
                      /* else if(utext.contains("google")||utext.contains("open google"))
                       {
                           botSay("Sure sir!");
                           google();
                       }*/
                      else if(utext.contains("Comment on peut faire un don ?    ")||utext.contains("don"))
                       {
                           botSay(
"La donation est possible à condition que les donateurs et donataires respectent certaines conditions :\n" +
"Le donateur doit : être sain d'esprit, avoir 16 ans minimum et posséder la capacité juridique de gérer ses biens.\n" +
"Le bénéficiaire doit : accepter la donation, de manière expresse et non tacite. ");
                       }
                           
                       
                               
                      
                           
                        
                      
          
                       
                      
                   
                   
              
              
          });
          
        
        StackPane root = new StackPane();
        
         
         t2.setStyle("-fx-text-fill:green;");
        
        scene = new Scene(root,600,700);
        //scene.getStylesheets().add(Chatbot.class.getResource("Style.css").toExternalForm());
        Button b2=new Button("Default Theme");
         b2.setOnAction(e->
         {
              t.setFill(javafx.scene.paint.Color.DARKMAGENTA);
             root.setId("z1");
             t2.setStyle("-fx-text-fill:green;");
         });
         b2.setLayoutY(8);
         b2.setTranslateY(300);
         b2.setLayoutX(10);
         b2.setTranslateX(100);
         button.setOnAction(e->{
            //label.setStyle("-fx-text-fill:violet");
            t.setFill(javafx.scene.paint.Color.DEEPSKYBLUE);
            root.setId("z");
            t2.setStyle("-fx-text-fill:red;");
            
        });
         root.getChildren().addAll(t1,t2,button,t,b2);
        
        primaryStage.setTitle("Java AI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void botSay(String s)
    {
        
        t2.appendText("AI :"+s+"\n");
       
    }
   
    
    
       
       
        
        
    
    public void get()
    {
        Scanner sc=new Scanner(System.in);
        String s;
        s=sc.nextLine();
        botSay("Enter something");
        t1.setText(s);
        if(t1.toString().contains("a"))
        {
            botSay("u entered");
        }
         
        
        
    }
}

    /**
     *
     */

   
    

    /**
     * @param args the command line arguments
     */
    
    

