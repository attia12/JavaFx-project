/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.utils;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


/**
 *
 * @author attia
 */
public class MyConnection {
    public String url="jdbc:mysql://localhost:3306/gestionreclamation";
     public String login="root";
     public String pwd="";
     private Connection cnx;
     private static MyConnection instance;
     

    public MyConnection() {
        try {
            cnx=DriverManager.getConnection(url, login, pwd);
            System.out.println("Connected !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }

    /**
     *
     * @return
     */
    public Connection getCnx() {
        return this.cnx;
    }
    
    public static MyConnection getInstance() {
        if(instance == null)
            instance = new MyConnection();
        return instance;
    }
   
     
    
}
