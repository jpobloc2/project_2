package com.revature.services;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.UserRole;
import com.revature.entities.Users;
import com.revature.repo.RoleRepo;
import com.revature.repo.UsersRepo;

@Service
public class UsersService implements UsersServiceInterface {
	@Autowired
	private UsersRepo usersRepo;
	@Autowired
	private RoleRepo roleRepo;

	@Override
	public void createNew(Users u) {
		// Set role based on the string that was passed in
		UserRole tmp = roleRepo.findByUserRole(u.getRole().getUserRole());
		u.setRole(tmp);

		// Set userId to 0 so that it creates a new user rather than updating
		u.setUserId(0);

		usersRepo.save(u);
	}

	@Override
	public Users login(String username, String password) {
		Users u = usersRepo.findByUsername(username);
		if (u.getPassword().equals(password)) {
			return usersRepo.findByUsername(username);
		} else {
			return null;
		}
	}

	@Override
	public void forgotPass(int id) {
		String from = "GoldTeamMailer@gmail.com";
		String pass = "gtmailer";
		String to = "maaraken@yahoo.com";
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
		      message.setSubject("This is the Subject Line!");

		      // Now set the actual message
		      message.setText("This is actual message");

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

