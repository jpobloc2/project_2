package com.revature.services;


import java.util.Random;


import java.util.List;
import javax.security.sasl.AuthenticationException;


import org.springframework.beans.factory.annotation.Autowired;
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

	@Override
	public Users createNew(Users u, String token) throws AuthenticationException {
		// Set role based on the string that was passed in
		Users submitter = as.validateToken(token);
		as.validateManager(submitter);
		UserRole tmp = roleRepo.findByUserRole("Employee");
		u.setRole(tmp);

		// Set userId to 0 so that it creates a new user rather than updating
		u.setUserId(0);
		
		String to = u.getUserEmail();
		emailNewUser(to);
		return usersRepo.save(u);
	}

  @Override
	public boolean changePass(Users u) {
		Users tmp = usersRepo.findById(u.getUserId()).get();
		tmp.setPassword(u.getPassword());
		Users success = usersRepo.save(tmp);
		if (success != null) {
			return true;
		} else {
			return false;
		}
  }
  
	@Override
	public Users login(String username, String password) {
		Users u = usersRepo.findByUsername(username);
		if (u.getPassword().equals(password)) {
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
	public void emailNewUser(String to) {
		String subject = "New User Registration";
		String message = "Welcome to Revature! This message is to notify you that "
				+ "a new user account has been created on your behalf in Revature's timesheet portal. You may access your"
				+ "account, make changes, submit timesheets, submit reimbersement request, or submit advance pay requests"
				+ " at http://localhost:4200.";
		
		new EmailUtil().sendMessage(to, subject, message);
	}

	@Override
	public void emailAdmin(String from, String subject, String message) {
		new EmailUtil().recieveMessage(from, subject, message);
	}
}

