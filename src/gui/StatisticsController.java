/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.medicament;
import services.medicamentService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author HP
 */
   
    


    public class StatisticsController implements Initializable {

    @FXML
    private ImageView GoBackBtn;
    @FXML
    private PieChart StatsChart;

    medicamentService rs = new medicamentService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            displayStatistics();
        } catch (SQLException ex) {
            Logger.getLogger(StatisticsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void displayStatistics() throws SQLException {
        // Récupérer toutes les medicament de la base de données
        List<medicament> medicaments = rs.recuperermedicament();
        
        // Regrouper les medicament par type
        Map<String, Long> medicamentsParType = medicaments.stream()
                .collect(Collectors.groupingBy(medicament::getType_medicament, Collectors.counting()));
        
        // Calculer le prix total pour chaque type d'V
        Map<String, Double> prixParType = new HashMap<>();
        prixParType.put("GOLD", medicamentsParType.getOrDefault("GOLD", 0L) * 250 * 0.6); // 40% de réduction
        prixParType.put("SILVER", medicamentsParType.getOrDefault("SILVER", 0L) * 150 * 0.75); // 25% de réduction
        prixParType.put("BRONZE", medicamentsParType.getOrDefault("BRONZE", 0L) * 100 * 0.9); // 10% de réduction
        
        // Ajouter les données de prix à la liste des données pie chart
        List<PieChart.Data> pieChartData = prixParType.keySet().stream()
        .map(type -> {
            medicament ab = medicaments.stream()
                    .filter(a -> a.getType_medicament().equals(type))
                    .findFirst()
                    .orElse(null);
            double prix = 0.0;
            if (ab != null) {
                switch (type) {
                    case "GOLD":
                        prix = 250;
                        break;
                    case "SILVER":
                        prix = 150;
                        break;
                    case "BRONZE":
                        prix = 100;
                        break;
                }
            }
            return new PieChart.Data(type + " (" + Math.round(prix) + " DT)", prix);
        })
        .collect(Collectors.toList());


        // Définir les éléments de données dans le PieChart
        StatsChart.setData(FXCollections.observableArrayList(pieChartData));

        // Configurer l'animation pour les données pie chart
        StatsChart.getData().forEach(data ->
                data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
                    ScaleTransition st = new ScaleTransition(Duration.millis(200), data.getNode());
                    st.setToX(1.1);
                    st.setToY(1.1);
                    st.play();
                })
        );
        StatsChart.getData().forEach(data ->
                data.getNode().addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
                    ScaleTransition st = new ScaleTransition(Duration.millis(200), data.getNode());
                    st.setToX(1.0);
                    st.setToY(1.0);
                    st.play();
                })
        );

        // Configurer l'interactivité pour les données pie chart
       StatsChart.getData().forEach(data ->
    data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
        // Obtenir la valeur actuelle de l'élément data
        double currentValue = data.getPieValue();

        // Obtenir le nombre d'medicament de ce type
        long nbMedicaments = medicamentsParType.getOrDefault(data.getName().split(" ")[0], 0L);

        // Afficher un message avec la valeur de data et le nombre d'medicament
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Statistique medicament(s)");
        alert.setHeaderText(data.getName());
        String reduction = "";
        double totalWithDiscount = calculateTotalWithDiscount(currentValue, data.getName(), nbMedicaments);
        switch(data.getName().split(" ")[0]) {
            case "BRONZE":
                reduction = "10" + "%";
                
                break;
            case "SILVER":
                reduction = "25" + "%";
                
                break;
            case "GOLD":
              
                reduction = "40" + "%" ;
                if (nbMedicaments % 3 >= 1) {
        reduction = "41" + "%" ;
    }
                break;
        }
        alert.setContentText("Nombre d'medicaments : " + nbMedicaments + "\n"
            + "Prix total : " + Math.round(currentValue) * nbMedicaments + " DT\n"
            + "Réduction : " + reduction + "\n"
            + "Prix total avec réduction pour " + nbMedicaments + " medicaments : " + Math.round(totalWithDiscount) + " DT");
        alert.showAndWait();
    })
);


    }
    private double calculateTotalWithDiscount(double price, String subscriptionType, long nbMedicaments) {
    double discount = 0.0;
    
    switch (subscriptionType.split(" ")[0]) {
        case "BRONZE":
            discount = 0.1;
   
    
            
            break;
        case "SILVER":
            discount = 0.25;
       
   
          
            break;
        case "GOLD":
            discount = 0.4;
    
    if (nbMedicaments % 3 >= 1) {
        discount += 0.01;
    }
           
            break;
    }

    // Incrémenter le pourcentage de réduction de 1% si le nombre d'medicament est un multiple de 3
    
    
    
   
    
    
   
    
    

    double discountedPrice = price - (price * discount);
    return discountedPrice * nbMedicaments;
}





    @FXML
    private void GoBk(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ajoutermedicament.fxml"));
            Parent root = loader.load();

            // Set the root of the current scene to the new FXML file
            GoBackBtn.getScene().setRoot(root);
    }
    
}
