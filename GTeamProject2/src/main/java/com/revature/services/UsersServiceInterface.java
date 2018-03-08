package com.revature.services;

import com.revature.entities.Users;

public interface UsersServiceInterface {

	Users createNew(Users u, int manager_id);

	Users login(String username, String password);

}
