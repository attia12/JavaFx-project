
package interface1.gui;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatClientController {
    
    @FXML
    private TextArea messageArea;
    
    @FXML
    private TextField messageField;
    
    @FXML
    private Button sendButton;
    
    private Socket clientSocket;
    private PrintWriter outToServer;
    private Scanner inFromServer;
    
    public void initialize() throws IOException {
        clientSocket = new Socket("localhost", 6789);
        outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
        inFromServer = new Scanner(clientSocket.getInputStream());
        
        Thread messageReceiver = new Thread(() -> {
            while (true) {
                String message = inFromServer.nextLine();
                if (message.equals("**close**")) {
                    break;
                }
                messageArea.appendText("Server: " + message + "\n");
            }
        });
        messageReceiver.start();
    }
    
    @FXML
    private void sendMessage() {
        String message = messageField.getText();
        outToServer.println(message);
        outToServer.flush();
        messageArea.appendText("Client: " + message + "\n");
        messageField.setText("");
    }
    
    public void stop() throws IOException {
        outToServer.println("**close**");
        outToServer.flush();
        clientSocket.close();
    }
}

