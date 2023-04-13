/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interface1.gui;

import edu.workshopjdbc3a48.entities.Don;
import edu.workshopjdbc3a48.services.ServiceDon;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class StatController implements Initializable {

    @FXML
    private PieChart PieChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
ServiceDon serviceDon = new ServiceDon();


List<Don> dons = serviceDon.getAll();

// create a HashMap to store the data
HashMap<String, Integer> data = new HashMap<>();

// iterate through the list of Don objects
for (Don don : dons) {
    // get the date of the current Don object
    LocalDate date = LocalDate.parse(don.getDate());
   

    // format the date as a String in the format "yyyy-MM-dd"
    String formattedDate = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
     

    // if the HashMap already contains the formatted date as a key, increment the value by 1
    if (data.containsKey(formattedDate)) {
         
       
        data.put(formattedDate, data.get(formattedDate) + 1 );
        
       
        
    }
    // otherwise, add the formatted date as a new key with a value of 1
    else {
        data.put(formattedDate, 1);
    }
}

// create a new PieChart object
PieChart chart = new PieChart();

// create a new ObservableList to store the data for the chart
ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

// iterate through the HashMap and add the data to the ObservableList
for (String key : data.keySet()) {
    pieChartData.add(new PieChart.Data(key, data.get(key)));
    System.out.println(key);
}

// set the data for the chart
chart.setData(pieChartData);

// add the chart to a Scene and display it
Scene scene = new Scene(new Group(chart));
Stage stage = new Stage();
stage.setScene(scene);
stage.show();
    
    }
}
