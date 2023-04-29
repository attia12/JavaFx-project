import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class table extends JFrame {

  public table() {
    // Créer les données de la table
    Object[][] data = {
      {"John", "Doe", 30},
      {"Jane", "Doe", 25},
      {"Bob", "Smith", 40},
      {"Alice", "Jones", 35}
    };
    
    // Créer les noms des colonnes de la table
    String[] columnNames = {"Prénom", "Nom", "Âge"};
    
    // Créer la table avec les données et les noms de colonnes
    JTable table = new JTable(data, columnNames);
    
    // Ajouter la table à un JScrollPane pour permettre le défilement
    JScrollPane scrollPane = new JScrollPane(table);
    
    // Ajouter le JScrollPane à la fenêtre
    add(scrollPane);
    
    // Configurer la fenêtre
    setTitle("Exemple de table");
    setSize(400, 300);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    table ex = new table();
    ex.setVisible(true);
  }
}
