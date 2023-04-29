package edu.workshopjdbc3a48.entities;

import java.awt.EventQueue;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
public class maill {

	private JFrame frame;
	private JTextField txtEmail;
	JTextArea txtmsg;
	private JTextField txtsub;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					maill window = new maill();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public maill() {
		initialize();
		
	}

	public void sendmail()
	{
		 String to = "";
	      String from = "";
	      String host = "localhost";
	      String port = "25";
	  
	      final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	 
	         Properties props = System.getProperties();
	         props.setProperty("mail.smtp.host", "smtp.gmail.com");
	         props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
	         props.setProperty("mail.smtp.socketFactory.fallback", "false");
	         props.setProperty("mail.smtp.port", "465");
	         props.setProperty("mail.smtp.socketFactory.port", "465");
	         props.put("mail.smtp.auth", "true");
	         props.put("mail.debug", "true");
	         props.put("mail.store.protocol", "pop3");
	         props.put("mail.transport.protocol", "smtp");
	         final String username = "mahdi.dahmani@esprit.tn";//
	         final String password = "7122019.est.est..";
	         try{
	         Session session = Session.getInstance(props, 
	                              new Authenticator(){
	                                 protected PasswordAuthentication getPasswordAuthentication() {
	                                    return new PasswordAuthentication(username, password);
	                                 }});
	     
	         Message msg = new MimeMessage(session);

	   
	         msg.setFrom(new InternetAddress(txtEmail.getText()));
	         msg.setRecipients(Message.RecipientType.TO, 
	                          InternetAddress.parse(txtEmail.getText(),false));
	         msg.setSubject(txtsub.getText());
	         msg.setText(txtmsg.getText());
	         
	         
	         
	        
	         
	         msg.setSentDate(new Date());
	         Transport.send(msg);
	         JOptionPane.showMessageDialog(null, "Sent");
	      }catch (MessagingException e){ System.out.println("Erreur d'envoi, cause: " + e);}
	   }  
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 477, 438);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(48, 108, 378, 195);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtEmail.setBounds(170, 27, 177, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("To");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel.setBounds(22, 29, 36, 17);
		panel.add(lblNewLabel);
		
		JLabel lblSubject = new JLabel("Message");
		lblSubject.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblSubject.setBounds(22, 139, 95, 30);
		panel.add(lblSubject);
		
		 txtmsg = new JTextArea();
		 txtmsg.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtmsg.setBounds(170, 123, 177, 61);
		panel.add(txtmsg);
		
		JLabel lblSubject_1 = new JLabel("Subject");
		lblSubject_1.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblSubject_1.setBounds(22, 80, 95, 18);
		panel.add(lblSubject_1);
		
		txtsub = new JTextField();
		txtsub.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtsub.setColumns(10);
		txtsub.setBounds(170, 78, 177, 20);
		panel.add(txtsub);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				sendmail();
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(286, 331, 138, 44);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblSendEmail = new JLabel("Send Email");
		lblSendEmail.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblSendEmail.setBounds(48, 27, 180, 44);
		frame.getContentPane().add(lblSendEmail);
	}
}
