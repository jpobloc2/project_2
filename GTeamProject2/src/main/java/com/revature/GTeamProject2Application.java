package com.revature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.revature.entities.JwtUser;
import com.revature.repo.UsersRepo;

@SpringBootApplication
public class GTeamProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(GTeamProject2Application.class, args);
	}
	
//	@Autowired
//	public void authenticationManager(AuthenticationManagerBuilder builder, UsersRepo repo ) throws Exception {
//		builder.userDetailsService(new UserDetailsService() {
//			@Override
//			public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//				return new JwtUser(repo.findByUsername(s));
//			}
//		});
//	}
}
