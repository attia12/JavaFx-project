    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.workshopjdbc3a48.entities;

/**
 *
 * @author msi
 */
public class Don {

private int id ,id_ben;
      
private String titre;
       
        private int  qte;
                private String  type,date;
                        private int  id_local,id_cat_id;
                          private String imge ;

    public Don(int id, int id_ben, String titre, int qte, String type, String date, int id_local, int id_cat_id, String imge) {
        this.id = id;
        this.id_ben = id_ben;
        this.titre = titre;
        this.qte = qte;
        this.type = type;
        this.date = date;
        this.id_local = id_local;
        this.id_cat_id = id_cat_id;
        this.imge = imge;
    }

    public Don(int id_ben, String titre, int qte, String type, String date, int id_local, int id_cat_id, String imge) {
        this.id_ben = id_ben;
        this.titre = titre;
        this.qte = qte;
        this.type = type;
        this.date = date;
        this.id_local = id_local;
        this.id_cat_id = id_cat_id;
        this.imge = imge;
    }

  


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_ben() {
        return id_ben;
    }

    public void setId_ben(int id_ben) {
        this.id_ben = id_ben;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public int getId_local() {
        return id_local;
    }

    public void setId_local(int id_local) {
        this.id_local = id_local;
    }

    public int getId_cat_id() {
        return id_cat_id;
    }

    public void setId_cat_id(int id_cat_id) {
        this.id_cat_id = id_cat_id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImge() {
        return imge;
    }

    public void setImge(String imge) {
        this.imge = imge;
    }

    public String getId_cat_idC() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
