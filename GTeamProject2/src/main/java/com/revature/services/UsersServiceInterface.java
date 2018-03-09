package com.revature.services;

import com.revature.entities.Users;

public interface UsersServiceInterface {

	boolean createNew(Users u);

	Users login(String username, String password);

	boolean changePass(Users u);

}
