package com.ant.technology.infotrafic.utils;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {

public static void	envoyerEmail(String to,String subject,String object) throws MessagingException{
	
	
//	String from = "Info trafic";// change accordingly
	final String username = "infotrafic2019@gmail.com";// change accordingly
	final String password = "50587534infotrafic";// change accordingly
	// Assuming you are sending email through relay.jangosmtp.net
	String host = "smtp.gmail.com";
	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", host);
	props.put("mail.smtp.port", "587");
	props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	// Get the Session object.
	Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	});

	// Create a default MimeMessage object.
	javax.mail.Message message = new MimeMessage(session);
	// Set From: header field of the header.
	message.setFrom(new InternetAddress(username));
	// Set To: header field of the header.
	
	message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(to));
	// Set Subject: header field
	message.setSubject(subject);
	// Now set the actual message
	//message.setText(reponse);
	  BodyPart messageBodyPart = new MimeBodyPart();

         // Now set the actual message
         messageBodyPart.setText(object);

         // Create a multipar message
         Multipart multipart = new MimeMultipart();

         // Set text message part
		multipart.addBodyPart(messageBodyPart);

         // Part two is attachment
         messageBodyPart = new MimeBodyPart();
        
         // Send the complete message parts
         message.setContent(multipart);
	// Send message
	Transport.send(message);
	System.out.println("Sent message successfully....");
}



}
