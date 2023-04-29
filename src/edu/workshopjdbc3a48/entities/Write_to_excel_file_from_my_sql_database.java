
package edu.workshopjdbc3a48.entities;

import static edu.workshopjdbc3a48.entities.Read_File.read_a_file;
import edu.workshopjdbc3a48.utils.DataSource;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jxl.Workbook;
import jxl.write.*;

public class Write_to_excel_file_from_my_sql_database {

    public static void main(String[] args) {
        Connection cnx = DataSource.getInstance().getCnx();
String s =read_a_file("C:\\Users\\msi\\Desktop\\workshopJDBC3A48\\src\\EXCEL\\mahdii.xls");

        WritableWorkbook wworkbook;
        try {
            wworkbook = Workbook.createWorkbook(new File("C:\\Users\\msi\\Desktop\\workshopJDBC3A48\\src\\EXCEL\\mahdii.xls"));

            String req = "SELECT * FROM categorie";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            WritableSheet wsheet = wworkbook.createSheet("First Sheet", 0);
           
            Label label = new Label(0, 0, "Nom");
            wsheet.addCell(label);
            label = new Label(1, 0, "Description");
            wsheet.addCell(label);
            label = new Label(2, 0, "Date création");
            wsheet.addCell(label);

            int row = 1;
            while (rs.next()) {
                int col = 0;
               
              
                label = new Label(col++, row, rs.getString(2));
                wsheet.addCell(label);
                label = new Label(col++, row, rs.getString(3));
                wsheet.addCell(label);
                label = new Label(col++, row, rs.getString(4));
                wsheet.addCell(label);

                row++;
            }

            wworkbook.write();
            wworkbook.close();
            System.out.println("Excel file generated successfully.");

        } catch (Exception e) {
            System.out.println("An error occurred while generating the Excel file: " + e.getMessage());
        }
    }
}
