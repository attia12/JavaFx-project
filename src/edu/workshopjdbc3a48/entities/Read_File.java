/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.workshopjdbc3a48.entities;

/**
 *
 * @author msi
 */
import java.io.BufferedReader;
import java.io.FileReader;
public class Read_File {
    public static String read_a_file(String file_name) {
		BufferedReader br = null; 
		String read_string="";
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(file_name));
			while ((sCurrentLine = br.readLine()) != null) {
				read_string=read_string+sCurrentLine;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return read_string;
	}
    
}
