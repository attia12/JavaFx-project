package interface1.gui;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatServerController {

    @FXML
    private TextArea messageArea;

    @FXML
    private TextField messageField;

    @FXML
    private Button sendButton;

    private ServerSocket serverSocket;
    private Socket connectionSocket;
    private PrintWriter outFromServer;
    private Scanner inFromClient;

    public void initialize() throws IOException {
        serverSocket = new ServerSocket(6785);
        connectionSocket = serverSocket.accept();
        outFromServer = new PrintWriter(connectionSocket.getOutputStream(), true);
        inFromClient = new Scanner(connectionSocket.getInputStream());

        Thread messageReceiver = new Thread(() -> {
            while (true) {
                String message = inFromClient.nextLine();
                if (message.equals("**close**")) {
                    break;
                }
                Platform.runLater(() -> messageArea.appendText("Client: " + message + "\n"));
            }
        });
        messageReceiver.start();
    }

    @FXML
    private void sendMessage() {
        String message = messageField.getText();
        outFromServer.println(message);
        outFromServer.flush();
        messageArea.appendText("Server: " + message + "\n");
        messageField.setText("");
    }

    public void stop() throws IOException {
        serverSocket.close();
        connectionSocket.close();
        outFromServer.close();
        inFromClient.close();
    }

}