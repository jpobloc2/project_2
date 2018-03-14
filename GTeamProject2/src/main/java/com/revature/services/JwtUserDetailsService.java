//package com.revature.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.revature.entities.JwtUser;
//import com.revature.entities.Users;
//import com.revature.repo.UsersRepo;
//
//@Service
//public class JwtUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UsersRepo userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users user = userRepository.findByUsername(username);
//        //System.out.println(user.getUsername() + " and " + user.getPassword());
//
//        if (user == null) {
//            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
//        } else {
//        	return new JwtUser(
//                    user.getUserId(),
//                    user.getUsername(),
//                    user.getFirstName(),
//                    user.getLastName(),
//                    user.getUserEmail(),
//                    user.getPassword(),
//                    new SimpleGrantedAuthority("ROLE_" + user.getRole().getUserRole())
//            );
//        }
//    }
//}
