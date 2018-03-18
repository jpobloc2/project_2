package com.revature.services;

import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.revature.entities.UserRole;
import com.revature.entities.Users;
import com.revature.repo.RoleRepo;
import com.revature.repo.UsersRepo;
import com.revature.util.EmailUtil;

@Service
public class UsersService implements UsersServiceInterface {
	@Autowired
	private UsersRepo usersRepo;
	@Autowired
	private RoleRepo roleRepo;
	@Autowired
	private AuthenticationService as;
	@Autowired
	private PasswordEncoder pe;

	@Override
	public Users createNew(Users u, String token) throws AuthenticationException {
		// Set role based on the string that was passed in
		Users submitter = as.validateToken(token);
		as.validateManager(submitter);
		UserRole tmp = roleRepo.findByUserRole("Employee");
		u.setRole(tmp);
		u.setEmployer(submitter);
		// Set userId to 0 so that it creates a new user rather than updating
		u.setUserId(0);
		u.setPassword(pe.encode(u.getPassword()));
		String to = u.getUserEmail();
		emailNewUser(to);
		return usersRepo.save(u);
	}

	@Override
	public void changePass(Users u, String token) throws AuthenticationException {
		Users tmp = as.validateToken(token);
		tmp.setPassword(u.getPassword());
		usersRepo.save(tmp);
	}

	@Override
	public Users login(String username, String password) {
		Users u = usersRepo.findByUsername(username);
		if (pe.matches(password, u.getPassword())) {
			return u;
		} else {
			return null;
		}
	}

	@Override
	public List<Users> findAll() {
		return usersRepo.findAll();
	}

	@Override
	public Users findById(int id) {
		return usersRepo.findByUserId(id);
	}

	@Override
	// sendEmail (String to, String msg)
	public void forgotPass(String username) {
		String newPassword = getRandomPass();
		String subject = "Your password has been reset.";
		String message = "Your new temporary password is: " + newPassword
				+ ". Please change it immediately after signing in.";
		Users u = usersRepo.findByUsername(username);
		String to = u.getUserEmail();
		u.setPassword(newPassword);
		usersRepo.save(u);
		new EmailUtil().sendMessage(to, subject, message);
	}

	private String getRandomPass() {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder sb = new StringBuilder();
		Random rnd = new Random();
		while (sb.length() < 18) { // length of the random string.
			int index = rnd.nextInt(36);
			sb.append(chars.charAt(index));
		}
		String newPass = sb.toString();
		return newPass;
	}

	@Override
	public Users changeUser(Users u, String token) throws AuthenticationException {
		Users submitter = as.validateToken(token);
		submitter.setUserEmail(u.getUserEmail());
		submitter.setFirstName(u.getFirstName());
		submitter.setLastName(u.getLastName());
		submitter.setUsername(u.getUsername());
		submitter.setPassword(u.getPassword());
		submitter.setWage(u.getWage());
		return usersRepo.save(submitter);
	}

	@Override
	public void emailNewUser(String to) {
		String subject = "New User Registration";
		String message = "Welcome to Revature! This message is to notify you that "
				+ "a new user account has been created on your behalf in Revature's timesheet portal. You may access your"
				+ "account, make changes, submit timesheets, submit reimbersement request, or submit advance pay requests"
				+ " at http://localhost:4200.";

		new EmailUtil().sendMessage(to, subject, message);
	}

	@Override
	public Users getUserData(String token) throws AuthenticationException {
		Users u = as.validateToken(token);
		return u;
	}

	@Override
	public Set<Users> getEmployeeData(String token) throws AuthenticationException {
		Users u = as.validateToken(token);
		if (validateManager(u) == true) {
			return u.getSubordinates();
		} else {
			throw new AuthenticationException();
		}
	}

	public boolean validateManager(Users u) throws AuthenticationException {
		boolean b = (u.getRole().equals("Manager"));
		if (!b) {
			throw new AuthenticationException();
		}
		return b;
	}

	@Override
	public void emailAdmin(String from, String subject, String message) {
		new EmailUtil().recieveMessage(from, subject, message);
	}
}
