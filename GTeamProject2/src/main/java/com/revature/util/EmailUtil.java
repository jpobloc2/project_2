package com.revature.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {
	
	public void sendMessage(String to, String subject, String body) {
		String from = "GoldTeamMailer@gmail.com";
		String pass = "gtmailer";
		String host = "smtp.gmail.com";

		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		
		Session session = Session.getDefaultInstance(props);
		
		try {
			MimeMessage message = new MimeMessage(session);
		      // Set From: header field of the header.
		      message.setFrom(new InternetAddress(from));

		      // Set To: header field of the header.
		      message.addRecipient(Message.RecipientType.TO,
		                               new InternetAddress(to));

		      // Set Subject: header field
		      message.setSubject(subject);

		      // Now set the actual message
		      message.setText(body);

		      // Send message
		      Transport transport = session.getTransport("smtp");
		      transport.connect(host, from, pass);
		      transport.sendMessage(message, message.getAllRecipients());
		      transport.close();
		      System.out.println("Sent message successfully....");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
			
		}
	
	public void recieveMessage(String from, String subject, String body) {
		String pass = "gtmailer";
		String host = "smtp.gmail.com";

		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		
		Session session = Session.getDefaultInstance(props);
		
		try {
			MimeMessage message = new MimeMessage(session);
		      // Set From: header field of the header.
		      message.setFrom(new InternetAddress(from));

		      // Set To: header field of the header.
		      message.addRecipient(Message.RecipientType.TO,
		                               new InternetAddress("GoldTeamMailer@gmail.com"));

		      // Set Subject: header field
		      message.setSubject(subject);

		      // Now set the actual message
		      message.setText(body);

		      // Send message
		      Transport transport = session.getTransport("smtp");
		      transport.connect(host, from, pass);
		      transport.sendMessage(message, message.getAllRecipients());
		      transport.close();
		      System.out.println("Sent message successfully....");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
			
		}

}
