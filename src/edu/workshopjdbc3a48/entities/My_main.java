package edu.workshopjdbc3a48.entities;

import java.io.PrintWriter;

public class My_main {
    public static void main(String[] args) {
        String input_file = "C:\\Users\\msi\\Desktop\\OCR\\mm.png";
        String output_file = "C:\\Users\\msi\\Desktop\\OCR\\out";
        String tesseract_install_path = "C:\\Users\\msi\\Desktop\\OCR\\OCTInstall\\tesseract.exe";

        String[] command = {"cmd"};

        try {
            Process p = Runtime.getRuntime().exec(command);
            new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
            new Thread(new SyncPipe(p.getInputStream(), System.out)).start();

            PrintWriter stdin = new PrintWriter(p.getOutputStream());
            stdin.println("\"" + tesseract_install_path + "\" \"" + input_file + "\" \"" + output_file + "\" -l eng");
            stdin.close();

            p.waitFor();

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

            System.out.println(Read_File.read_a_file(output_file + ".txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


