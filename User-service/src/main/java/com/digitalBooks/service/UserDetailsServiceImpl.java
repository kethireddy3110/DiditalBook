//package com.digitalBooks.service;
//
//import org.springframework.security.core.userdetails.UserDetails;
//
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.digitalBooks.components.User;
//import com.digitalBooks.components.UserDetailsImpl;
//import com.digitalBooks.repository.UserRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//	
//	@Autowired
//	private UserRepository userRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//		User user=userRepository.findByUserName(username);
//				
//		if(user==null) {
//			throw new UsernameNotFoundException(username + "not found");
//		}
//		return new UserDetailsImpl(user);
//	}
//
//}
