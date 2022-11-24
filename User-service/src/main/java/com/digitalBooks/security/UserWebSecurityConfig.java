//package com.digitalBooks.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class UserWebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	UserDetailsService userDetailsService;
//
//
//	/*
//	 * @Bean public AuthenticationProvider authProvider() {
//	 * DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
//	 * provider.setUserDetailsService(userDetailsService);
//	 * provider.setPasswordEncoder(new BCryptPasswordEncoder()); return provider;
//	 * 
//	 * }
//	 */
//
//
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//
//		return super.authenticationManagerBean();
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//	}
//
//	/*
//	 * @Bean public PasswordEncoder passwordEncoder() { return
//	 * PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	 * 
//	 * 
//	 * }
//	 */
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.authorizeRequests()
//
////				.antMatchers(HttpMethod.POST).hasAnyRole("AUTHOR", "GUEST")
////				.antMatchers(HttpMethod.PUT).hasAnyRole("AUTHOR")
//				.antMatchers(HttpMethod.GET, "/user/book/getAll").hasAnyRole("GUEST", "READER", "AUTHOR")
////				//.antMatchers(HttpMethod.POST, "/user/create").hasAnyRole("GUEST")
////				.antMatchers(HttpMethod.GET, "/user/login").hasAnyRole("GUEST", "READER", "AUTHOR")
//				.antMatchers(HttpMethod.POST, "/user/create/book").hasAnyRole("AUTHOR")
//				//.antMatchers(HttpMethod.POST, "/user/save/logo/{authorId}").hasAnyRole("AUTHOR")
//				.antMatchers(HttpMethod.PUT, "/user/update/book").hasAnyRole("AUTHOR")
//				.antMatchers(HttpMethod.GET, "/user/subscribe/book/{authorId}/{subscribedBy}")
//				.access("@userLoginSecurity.isUserNameVerified(authentication,#subscribedBy)")
//				.antMatchers(HttpMethod.GET, "/user/{userId}")
//				.access("@userLoginSecurity.isUserIdVerified(authentication,#userId)");
//
//		http.cors().disable();
//		http.csrf().disable();
//		http.headers().frameOptions().disable();
//		super.configure(http);
//	}
//}
