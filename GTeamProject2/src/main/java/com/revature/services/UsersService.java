package com.revature.services;

import java.util.Random;

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
}

