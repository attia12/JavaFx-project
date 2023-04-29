package edu.workshopjdbc3a48.entities;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CombineImages {
 public void Combine(File image2File, String nom){
       
        try {
           
            // Load the two images to be combined
            File image1File = new File("C:\\Users\\msi\\Desktop\\mahdii\\logo.png");
            
            BufferedImage image1 = ImageIO.read(image1File);
            BufferedImage image2 = ImageIO.read(image2File);

            // Resize image2 to desired dimensions
            int newWidth = 800;
            int newHeight = 800;
            Image scaledImage2 = image2.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            BufferedImage resizedImage2 = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = resizedImage2.createGraphics();
            g2.drawImage(scaledImage2, 0, 0, null);
            g2.dispose();

            // Create a new image that is a combination of the two images
            int combinedWidth = Math.max(image1.getWidth(), resizedImage2.getWidth());
            int combinedHeight = Math.max(image1.getHeight(), resizedImage2.getHeight());
            BufferedImage combined = new BufferedImage(combinedWidth, combinedHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = combined.createGraphics();
            g.drawImage(image1, 625, 650, null);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f)); // set the opacity of the second image
            g.drawImage(resizedImage2, 0, 0, null);
            g.dispose();

            // Save the combined image
            File outputFile = new File("C:\\Users\\msi\\Desktop\\workshopJDBC3A48\\src\\EXCEL\\M.png");
            ImageIO.write(combined, "png", outputFile);
            System.out.println("Combined image saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

    