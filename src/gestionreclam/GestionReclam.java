/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionreclam;

import edu.esparit.services.ReclamationC;
import edu.esparit.services.ResponseC;
import edu.esprit.entities.Reclamation;
import edu.esprit.entities.Response;
import edu.esprit.utils.MyConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author attia
 */
public class GestionReclam {

    private static boolean validateInput(String input) {
          Pattern pattern = Pattern.compile("[a-zA-Z ]*");
          Matcher match = pattern.matcher(input);
           return match.matches();
    
    }
    public static List<String> inappropriateWords = Arrays.asList("badword1", "badword2", "badword3");
 public static String filterInput(String input) {
    String filteredInput = input;
    for (String word : inappropriateWords) {
        String regex = "(?i)\\b" + Pattern.quote(word) + "\\b";
        filteredInput = filteredInput.replaceAll(regex, "*****");
    }
    return filteredInput;
}
   
   
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
            // TODO code application logic here
            // MyConnection mc=new MyConnection();
            // ReclamationC rc=new ReclamationC();
           // Reclamation r=new Reclamation(69,"nihed","attia","attia@gmail.com","nicenice");
           /* System.out.println(r.toString());*/
           
            
            
             //rc.ajouter(r);
             //System.out.println(rc.getAll());
             //rc.supprimer(70);
           // ResponseC res=new ResponseC();
            //Response re=new Response(22,"mohamedyassine",r);
            //res.modifier(re);
           
           //String input = "47566";
//boolean isValid = validateInput(input);
       // System.out.println(isValid);
       // System.out.println(!isValid);
           
      
            //res.ajouter(re);
           // res.supprimer(re.getId());
            
            
            
            //System.out.println(rc.getTbyId(69));
            //System.out.println(res.getAll());
           //res.modifier(re);
            
           // System.out.println(res.getTbyId(20));
           //rc.modifier(r);
           String userInput = "badword1";
            System.out.println(userInput);
String filteredInput = filterInput(userInput);
        System.out.println(filteredInput);

            
          
          
                    
        
                
    }
    
}
