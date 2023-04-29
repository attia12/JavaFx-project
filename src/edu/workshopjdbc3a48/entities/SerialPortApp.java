package edu.workshopjdbc3a48.entities;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;


public class SerialPortApp {

    private SerialPort serialPort;

 
   

    

    public SerialPortApp(String portName) {
        serialPort = new SerialPort(portName);
        try {
            // Open the port
            serialPort.openPort();
            // Set the parameters of the port
            serialPort.setParams(SerialPort.BAUDRATE_115200, 
                                 SerialPort.DATABITS_8, 
                                 SerialPort.STOPBITS_1, 
                                 SerialPort.PARITY_NONE);
            // Set the event listener
            serialPort.addEventListener(new SerialPortEventListener() {
                @Override
                public void serialEvent(SerialPortEvent event) {
                    if (event.isRXCHAR()) {
                        try {
                            // Read the data from the port
                            byte[] buffer = serialPort.readBytes();
                            String data = new String(buffer);
                            // Do something with the data
                            System.out.println("Received data: " + data);
                        } catch (SerialPortException ex) {
                            System.err.println("Error reading from serial port: " + ex.getMessage());
                        }
                    }
                }
            }, SerialPort.MASK_RXCHAR);
        } catch (SerialPortException ex) {
            System.err.println("Error opening serial port: " + ex.getMessage());
        }
    }

    public String getResult() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void closeSerialPort() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void openSerialPort() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}
