/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.workshopjdbc3a48.tests;

import edu.workshopjdbc3a48.entities.Categorie;

import edu.workshopjdbc3a48.entities.Don;
import edu.workshopjdbc3a48.services.ServiceCategorie;
import edu.workshopjdbc3a48.services.ServiceDon;

import edu.workshopjdbc3a48.utils.DataSource;

/**
 *
 *
 */
public class MainClass {
    
    public static void main(String[] args) {
       /*  
  ;
        
        ServicePersonne sp = new ServicePersonne();
        */
       Categorie C1=new Categorie(1,"Abdelaziz", "M","cc");
       Categorie C2=new Categorie("Abde", "M","cc");
      // Don D1 = new Don(1, 5, 5, 4, 5, "sjbd", "hbcdcd", "2023-03-22", "hjbhjb");
       ServiceCategorie cs = new ServiceCategorie();
        cs.ajouter(C1);
        cs.modifier(C2,1);
     // ServiceDon dd = new ServiceDon();
      //dd.ajouter(D1);
         /*
       sp.ajouter(p1);
        sp.ajouter(p2);
        sp.ajouter2(p3);
        sp.ajouter2(p4);
        
        sp.supprimer(3);
        */
         // cs.supprimer(1);
    }
    
}
