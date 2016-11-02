package com.project.bidonline.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.project.bidonline.authenticate.DatabaseProcess;

@Configuration
@EnableWebSecurity
public class BidOnlineSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DatabaseProcess userDetailsService;
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		http.csrf().disable()
		.formLogin()
			.loginPage("/user/login")
			.failureUrl("/user/login?error")
			.defaultSuccessUrl("/user/bids")
			.usernameParameter("username")
			.passwordParameter("password")
			.and()
		.authorizeRequests()
			.antMatchers("/user/bids").access("hasRole('ROLE_MEMBER')")
			.and().exceptionHandling().accessDeniedPage("/403").and()
		.logout().logoutUrl("/user/logout").logoutSuccessUrl("/");
		
	}
}
