package com.revature.controllers;

import static org.assertj.core.api.Assertions.useRepresentation;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.revature.entities.Complaint;
import com.revature.entities.LoginCredentials;
import com.revature.entities.Users;
import com.revature.rest.JwtAuthenticationRequest;
import com.revature.rest.JwtAuthenticationResponse;
import com.revature.services.UsersServiceInterface;
import com.revature.util.JwtTokenUtil;
import com.revature.views.View;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	private UsersServiceInterface us;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	// @Autowired
	// @Qualifier("jwtUserDetailsService")
	// private UserDetailsService userDetailsService;
	@Autowired
	private AuthenticationManager authenticationManager;
	// @Autowired
	// private AuthenticationService as;

	@GetMapping("forgotPass/{username}")
	public ResponseEntity<String> forgotPass(@PathVariable String username) {
		try {
			us.forgotPass(username);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("emailAdmin")
	public ResponseEntity<String> emailAdmin(@RequestBody String from, String subject, String message) {
		try {
			us.emailAdmin(from, subject, message);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("changePass")
	@JsonView(View.UserInfo.class)
	public ResponseEntity<Users> changePass(@RequestBody String newPass, @RequestHeader(value = "xtoken") String token) {
		try {
			return new ResponseEntity<Users>(us.changePass(newPass, token), HttpStatus.OK);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Users>(HttpStatus.UNAUTHORIZED);
		}
	}

	@PostMapping("new")
	@JsonView(View.UserInfo.class)
	public ResponseEntity<Users> createNew(@RequestBody Users u, @RequestHeader(value = "xtoken") String token) {
		try {
			return new ResponseEntity<Users>(us.createNew(u, token), HttpStatus.OK);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Users>(HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping("{id}")
	@JsonView(View.UserInfo.class)
	public Users findById(@PathVariable int id) {
		return us.findById(id);
	}

	@JsonView(View.UserInfo.class)
	@GetMapping()
	public ResponseEntity<Users> getUserData(@RequestHeader(value = "xtoken") String token) {
		try {
			System.out.println(us.getUserData(token).toString());
			return new ResponseEntity<Users>(us.getUserData(token), HttpStatus.OK);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Users>(HttpStatus.UNAUTHORIZED);
		}
	}

	@JsonView(View.Summary.class)
	@GetMapping("employeeData")
	public ResponseEntity<Set<Users>> getEmployeeData(@RequestHeader(value = "xtoken") String token) {
		try {
			return new ResponseEntity<Set<Users>>(us.getEmployeeData(token), HttpStatus.OK);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Set<Users>>(HttpStatus.UNAUTHORIZED);
		}
	}

	@PostMapping("change")
	@JsonView(View.UserInfo.class)
	public ResponseEntity<Users> changeUser(@RequestBody Users u, @RequestHeader(value = "xtoken") String token) {
		try {
			return new ResponseEntity<Users>(us.changeUser(u, token), HttpStatus.OK);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Users>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PostMapping("change/sub")
	@JsonView(View.UserInfo.class)
	public ResponseEntity<Users> changeSubordinate(@RequestBody Users u, @RequestHeader(value = "xtoken") String token) {
		try {
			return new ResponseEntity<Users>(us.changeSub(u, token), HttpStatus.OK);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Users>(HttpStatus.UNAUTHORIZED);
		}
	}

	@PostMapping
	@JsonView(View.UserInfo.class)
	public Users login(@RequestBody LoginCredentials lc) {
		System.out.println(lc.getUsername() + " " + lc.getPassword());
		return us.login(lc.getUsername(), lc.getPassword());
	}

	@GetMapping("all")
	@JsonView(View.UserInfo.class)
	public List<Users> findAll() {
		return us.findAll();

	}

	@JsonView(View.UserInfo.class)
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<JwtAuthenticationResponse> createAuthenticationToken(
			@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		Users user = us.login(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		// Reload password post-security so we can generate the token
		// final UserDetails userDetails =
		// userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(user);

		// Return the token
		return ResponseEntity.ok(new JwtAuthenticationResponse(user, token));
	}

	@PostMapping("complaint")
	public ResponseEntity<Complaint> submitComplaint(@RequestBody Complaint complaint,
			@RequestHeader(value = "xtoken") String token) {
		try {
			us.submitComplaint(complaint, token);
			return new ResponseEntity<Complaint>(complaint, HttpStatus.OK);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Complaint>(HttpStatus.UNAUTHORIZED);
		}
	}

	/**
	 * Authenticates the user. If something is wrong, an AuthenticationException
	 * will be thrown
	 */
	private void authenticate(String username, String password) throws AuthenticationException {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);
		System.out.println(username + " " + password);
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new AuthenticationException("User is disabled!", e);
		} catch (BadCredentialsException e) {
			throw new AuthenticationException("Bad credentials!", e);
		}
	}

	// @RequestMapping(value = "/authenticate/getuser", method = RequestMethod.GET)
	// public JwtUser getAuthenticatedUser(HttpServletRequest request) {
	// System.out.println("HI");
	// String token = request.getHeader("xtoken");
	// //String token =
	// "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJicmFkeSIsImV4cCI6MTUyMDk4NjA3MSwiaWF0IjoxNTIwOTg1MDcxfQ.ofjy5DzJAhzolTL_i7Z-DhaF-dnOtao6h6QsNIi8NWLZpZiIDL2HaKB_6QuBaWzUgZb2aScmiVGmUvUw50Ei4g";
	// //System.out.println(request.getHeader("Authorization").substring(7));
	// System.out.println(token);
	// String username = jwtTokenUtil.getUsernameFromToken(token);
	// System.out.println(username);
	// JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
	// return user;
	// }
}
