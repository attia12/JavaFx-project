package edu.workshopjdbc3a48.entities;

import edu.workshopjdbc3a48.utils.DataSource;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

public class BarCode {

    public static String Barcodecreat(int id) {
        String path = "";
        try {
            Connection cnx = DataSource.getInstance().getCnx();
            PreparedStatement ps = cnx.prepareStatement("SELECT * FROM don WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String imageName = rs.getString(3); // Utiliser le nom de la colonne au lieu de l'index
                String myString1 = " des_type:  "+rs.getString(2)+" titre :  "+rs.getString(3);

                Code128Bean code128 = new Code128Bean();
                code128.setHeight(15f);
                code128.setModuleWidth(0.3);
                code128.setQuietZone(10);
                code128.doQuietZone(true);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/png", 300,
                        BufferedImage.TYPE_BYTE_BINARY, false, 0);
                code128.generateBarcode(canvas, myString1); // Générer le code-barres avec la chaîne de caractères finale
                canvas.finish();
                path = "C:\\Users\\msi\\Desktop\\workshopJDBC3A48\\src\\EXCEL\\" + imageName +".png";
                // Écrire le code-barres dans un fichier PNG
                FileOutputStream fos = new FileOutputStream(path);
                fos.write(baos.toByteArray());
                fos.flush();
                fos.close();
            }
        } catch (Exception e) {
            System.out.println("Exception lors de la génération du code-barres : " + e.getMessage());
        }
        return path;
    }
}