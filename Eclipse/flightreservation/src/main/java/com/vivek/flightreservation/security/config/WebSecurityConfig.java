package com.vivek.flightreservation.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/showReg", "/", "/index.html", "/registerUser", "/login", "/showLogin", "/login/*",
						"/reservations/*", "/doReservation")
				.permitAll().and().authorizeRequests().antMatchers("/admin/showAddFlight").hasAuthority("ADMIN").anyRequest().authenticated()
				.and().csrf().disable();
	}

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

}
