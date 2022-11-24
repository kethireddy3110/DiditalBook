//package com.digitalBooks.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import com.digitalBooks.components.User;
//import com.digitalBooks.components.UserCredentials;
//import com.digitalBooks.repository.UserRepository;
//
//@Component("userLoginSecurity")
//public class UserLoginSecurity {
//
//	@Autowired
//	UserRepository userRepository;
//
//	/*
//	 * @Override public UserDetails loadUserByUsername(String userName) throws
//	 * UsernameNotFoundException { User user =
//	 * userRepository.findByUserName(userName); if (user == null) { throw new
//	 * UsernameNotFoundException("Username not found");
//	 * 
//	 * } return new UserCredentials(user); }
//	 */
//
//	public boolean isUserNameVerified(Authentication authentication, String userToVerify) {
//
//		String userName = userRepository.findByUserName(authentication.getName()).getUserName();
//		if (userName != null && userName.equals(userToVerify)) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//
//	public boolean isUserIdVerified(Authentication authentication, Integer userToVerify) {
//
//		int userId = userRepository.findByUserName(authentication.getName()).getUserId();
//		if (userId == userToVerify) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//}
