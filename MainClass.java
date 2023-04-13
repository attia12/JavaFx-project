/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.tests;

import edu.esprit.entities.Aarticle;
import edu.esprit.services.AarticleCrud;
import edu.esprit.utils.MyConnection;
import static java.time.Clock.system;


/**
 *
 * @author user
 */
public class MainClass {
    public static void main(String[]args){
        //MyConnection mc  =new MyConnection();
                MyConnection mc  = MyConnection.getInstance();
                MyConnection mc2 = MyConnection.getInstance();
System.out.println(mc.hashCode()+ " - "+mc2.hashCode());
        //AarticleCrud pcd = new AarticleCrud();
        //Aarticle p2 = new Aarticle("aman", "zaaaama","eyy","http");
       // pcd.ajouterAarticle2(p2);
      // System.out.println(pcd.afficherAarticles());
    }
}
 