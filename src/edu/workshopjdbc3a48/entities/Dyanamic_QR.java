package edu.workshopjdbc3a48.entities;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import edu.workshopjdbc3a48.utils.DataSource;

public class Dyanamic_QR {

    public String generateQRCode(int id) {
        String filePath = null;
        try (Connection cnx = DataSource.getInstance().getCnx();
             PreparedStatement ps = cnx.prepareStatement("SELECT * FROM don WHERE id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String imageName = rs.getString(4); // Utiliser le nom de la colonne au lieu de l'index
                String qrCodeData = " des_type:  "+rs.getString(2)+" type:  "+rs.getString(3)+" nom:  "+rs.getString(4);
                filePath = "C:\\Users\\msi\\Desktop\\workshopJDBC3A48\\src\\EXCEL\\" + imageName + ".png";
                String charset = StandardCharsets.UTF_8.name(); // Utiliser la constante StandardCharsets.UTF_8 au lieu d'une chaîne de caractères
                Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<>();
                hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
                BitMatrix matrix = new MultiFormatWriter().encode(
                        new String(qrCodeData.getBytes(charset), charset),
                        BarcodeFormat.QR_CODE, 200, 200, hintMap);
                MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), new File(filePath));
                System.out.println("QR Code image created successfully!");
            } else {
                System.err.println("No record found for id: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error executing SQL query: " + e);
        } catch (Exception e) {
            System.err.println("Error generating QR code: " + e);
        }
        return filePath;
    }
}
