package com.revature.services;

import com.revature.entities.Users;

public interface UsersServiceInterface {

	void createNew(Users u);

	Users login(String username, String password);

}
