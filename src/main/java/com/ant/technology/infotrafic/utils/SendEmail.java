package com.ant.technology.infotrafic.utils;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
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

	public static void envoyerEmail(String to, String subject, String object) throws MessagingException {

//String from = "Info trafic";// change accordingly
//final String username = "infotrafic19@gmail.com";// change accordingly
//final String password = "50587534info";// change accordingly
		final String username = "tbidt123@gmail.com";
		final String password = "123TBIDT123";
		//String username = "arp.tunisie.2018@gmail.com";
		//String password = "arp123456";
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
		// message.setText(reponse);
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

	

	public static void send(String email, String subject, String object) {

		final String username = "tbidt123@gmail.com";
		final String password = "123TBIDT123";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject(subject);
			message.setText(object);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		// ahwka b 5edmtek la9dima yab3eth
		
		try {
			envoyerEmail("maryem.msehli.54@gmail.com", "test", "123");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
