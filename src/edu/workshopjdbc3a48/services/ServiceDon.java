/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.workshopjdbc3a48.services;


import edu.workshopjdbc3a48.entities.Don;
import edu.workshopjdbc3a48.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
 import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.collections.ObservableList;

/**
 *
 * @author msi
 */
public class ServiceDon implements IService<Don> {
     Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Don D) {
        try {
            String req = "INSERT INTO don (id_ben, titre, qte, type, date, id_local, id_cat_id, imge) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
PreparedStatement ps = cnx.prepareStatement(req);
ps.setString(1,Integer.toString(D.getId_ben()));
ps.setString(2, D.getTitre());
ps.setInt(3, D.getQte());
ps.setString(4, D.getType());
ps.setString(5,D.getDate());
ps.setInt(6, D.getId_local());
ps.setInt(7, D.getId_cat_id());
ps.setString(8, D.getImge());
ps.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ADD Don");
 
alert.setHeaderText("ADD Don");
alert.setContentText("ADD!");
 
alert.showAndWait();
                  
        }
        
    
         catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
   

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `don` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("update Don");
 
alert.setHeaderText("Delete Don");
alert.setContentText("Delete!");
 
alert.showAndWait();
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     *
     * @param 
     * @throws java.sql.SQLException
     */
    @Override
    public void modifier(Don D,int id) {
           try {      
               id=D.getId();
               String req = "UPDATE `don` SET `id_ben` = '" + D.getId_ben() + "', `titre` = '" + D.getTitre() + "', `qte` = '" + D.getQte()+ "', `type` = '" + D.getType()+ "', `date` = '" + D.getDate()+ "', `id_local` = '" + D.getId_local()+ "', `id_cat_id` = '" + D.getId_cat_id()+ "', `imge` = '" + D.getImge()+ "' WHERE `id` = " + id;
               Statement st = cnx.createStatement();
               st.executeUpdate(req);
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("update Don");
 
alert.setHeaderText("update Don");
alert.setContentText("Update!");
 
alert.showAndWait();
           } catch (SQLException ex) {
               Logger.getLogger(ServiceDon.class.getName()).log(Level.SEVERE, null, ex);
           }
           
        
    }

    @Override
    public List<Don> getAll() {
        List<Don> list = new ArrayList<>();
        try {
            String req = "Select * from don";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                 Don D = new Don(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7),rs.getInt(8),rs.getString(9));
            list.add(D);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    public List<Don> searchByTitre(String titre) {
    List<Don> list = new ArrayList<>();
    try {
        String query = "SELECT * FROM Don WHERE Titre LIKE ?";
        PreparedStatement stmt = cnx.prepareStatement(query);
        stmt.setString(1, "%" + titre + "%");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Don don = new Don(
                    rs.getInt("id"),
                    rs.getInt("id_ben"),
                    rs.getString("titre"),
                    rs.getInt("qte"),
                    rs.getString("type"),
                    rs.getString("date"),
                    rs.getInt("id_local"),
                    rs.getInt("id_cat_id"),
                    rs.getString("imge")
            );
            list.add(don);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return list;
}
    
public void recupererpdf(Don l) throws DocumentException, BadElementException, IOException {
    
            
    // Ouvrir le document PDF
    Document document = new Document();
    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("iTextFacture1.pdf"));
    document.open();

    // Ajouter le titre de la facture
    //Font fontTitre = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.GREEN);
    Font fontTitre = FontFactory.getFont(FontFactory.COURIER_BOLD, 25, new BaseColor(10, 150, 100));
    Chunk chunkTitre = new Chunk("Don                                      ", fontTitre);
    document.add(chunkTitre);
    
    LineSeparator line = new LineSeparator();
line.setLineColor(new BaseColor(10, 150, 100));
line.setLineWidth(2);
document.add(line);
    
    
   /* Image image1 = Image.getInstance("‪C:\\Users\\msi\\Desktop\\OCR\\mm.png");
image1.setAbsolutePosition(520, PageSize.A4.getHeight() - -120 - image1.getHeight());
image1.scaleToFit(100, 70);
document.add(image1);
*/
    // Ajouter le tableau
    PdfPTable table = new PdfPTable(4); // Nombre de colonnes
    table.setWidthPercentage(100); // Largeur de la table
    table.setSpacingBefore(10f); // Espace avant la table
    table.setSpacingAfter(10f); // Espace après la table
    // Ajouter les cellules
    PdfPCell cell;
    cell = new PdfPCell(new Phrase("Num livraison"));
    cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
    table.addCell(cell);

    cell = new PdfPCell(new Phrase("Date livraison"));
    cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
    table.addCell(cell);

    cell = new PdfPCell(new Phrase("Adresse Client"));
    cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
    table.addCell(cell);

    cell = new PdfPCell(new Phrase("Prix livraison"));
    cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
    table.addCell(cell);

    // Ajouter les données du tableau
    // Récupérer la valeur du TextField
       

// Récupérer les données du tableau



    // Vérifier si le numéro de livraison correspond à celui entré dans le TextField
    
     //   String image_pr = "";
        //String adresseClient = livraison.getDest_liv();
       // String prixLivraison = Double.toString(livraison.getPrix());
       String num_liv = Integer.toString(l.getId());
      
      
        String prixLivraison = Integer.toString(l.getId_ben());
        table.addCell(num_liv);
        

        // table.addCell(l.getImge());
        table.addCell(prixLivraison);
    


    // Centrer le tableau
    table.setTotalWidth(new float[] { 50f, 130f, 200f, 50f }); // ajustez les valeurs en fonction de vos besoins

    PdfContentByte canvas = writer.getDirectContent();
    Rectangle rect = canvas.getPdfDocument().getPageSize();
    //table.setTotalWidth(table.getTotalWidth());
    table.writeSelectedRows(0, -1, (rect.getLeft() + rect.getRight() - table.getTotalWidth()) / 2, rect.getTop() - table.getTotalHeight() - 200, canvas);

    
  
    
    // Ajouter une image en bas à droite de la page
    File imagefile = new File("‪ C:\\Users\\msi\\Desktop\\mm.png");
    String s=imagefile.getAbsolutePath();
   // System.out.println("s");
Image image = Image.getInstance("MM1.png");
image.setAbsolutePosition(PageSize.A4.getWidth() - 200, 300);
document.add(image);


/*Image imag2 = Image.getInstance("C:\\Users\\msi\\Desktop\\OCR\\mm25.png");
imag2.scaleAbsolute(300, 200);
imag2.setAbsolutePosition(PageSize.A4.getWidth() - 450, 90);
document.add(imag2);
*/


PdfContentByte cb = writer.getDirectContent();
cb.beginText();
cb.setFontAndSize(FontFactory.getFont(FontFactory.COURIER_BOLD, 14, new BaseColor(0, 128, 0)).getBaseFont(), 14);
cb.showTextAligned(Element.ALIGN_RIGHT, "BUGBUSTERS", PageSize.A4.getWidth() - 20, 400, 0);
cb.endText();

//PdfContentByte cb = writer.getDirectContent();
cb.beginText();
cb.setFontAndSize(FontFactory.getFont(FontFactory.COURIER_BOLD, 14, new BaseColor(0, 128, 0)).getBaseFont(), 14);
cb.showTextAligned(Element.ALIGN_RIGHT, "Signature du Livreur : ", PageSize.A4.getWidth() - 399, 400, 0);
cb.endText();

cb.beginText();
cb.setFontAndSize(FontFactory.getFont(FontFactory.COURIER_BOLD, 14, new BaseColor(0, 200, 0)).getBaseFont(), 18);
cb.showTextAligned(Element.ALIGN_RIGHT, "FACTURE : ", PageSize.A4.getWidth() - 260, 700, 0);
cb.endText();

cb.beginText();
cb.setFontAndSize(FontFactory.getFont(FontFactory.COURIER_BOLD, 14, new BaseColor(0, 128, 0)).getBaseFont(), 14);
cb.showTextAligned(Element.ALIGN_RIGHT, "Signature du Client : ", PageSize.A4.getWidth() - 407, 350, 0);
cb.endText();

/*Font font = FontFactory.getFont(FontFactory.COURIER_BOLD, 12, BaseColor.BLACK);
Paragraph p = new Paragraph("BUGBUSTERS", font);
p.setAlignment(Element.ALIGN_RIGHT);
document.add(p);

   */ // Fermer le document PDF
    document.close();
  
}
      
     
       
   

   
    
    

}  


