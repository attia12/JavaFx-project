/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.medicament;
import entities.categorie;
import java.sql.Date;
import java.sql.SQLException;
import services.medicamentService;
import services.categorieService;


/**
 *
 * @author asus
 */
public class test {
    
      public static void main(String[] args) {   
          
          Date d=Date.valueOf("2022-06-11");
          Date d1=Date.valueOf("2020-04-12");
        try {
            //kifeh ya9ra el orde fel base de donnée , kifeh 3raf nom medic bch n3amarha f nom 
            medicament e = new medicament(2,10,"nom21", "type21","image21.png","description21",d1);
            medicament e1 = new medicament(5,"nom3", "type3","image3.png","description3",d);
            medicament e2 = new medicament(6,"nom4", "type4","image4.png","description4",d);
            medicament e3 = new medicament(5,8,"nom5", "type5","image5.png","description5",d);
            
            
            categorie p=new categorie(d,1,2);
            categorie p1=new categorie(d1,3,4);
            categorie p2=new categorie(27,d1,55,45);

            categorieService ps=new categorieService();
            //ps.categorie(p);
          //  ps.categorie(p1);
           // ps.categorie(p2);
            ps.modifiercategorie(p2);
            //ps.categorie(p2);
            System.out.println("");
            medicamentService ab = new medicamentService();
          
            System.out.println(ab.recuperermedicament());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
