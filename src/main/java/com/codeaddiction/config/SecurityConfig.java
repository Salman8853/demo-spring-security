package com.codeaddiction.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

   
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    	http
    	.csrf().disable()
    	
		.authorizeHttpRequests()
		.requestMatchers("/india/admin").hasRole("ADMIN")
		.requestMatchers("/india/common").hasAnyRole("ADMIN","NORMAL")
		.requestMatchers("/india/public","/india/add-user").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin();

		
	return http.build();
    }

    
   // This Authorization machanishm used for In-Memory authentication
//    @Bean
//   UserDetailsService userDetailsService() {
//        // The builder will ensure the passwords are encoded before saving in memory
//        UserDetails normalUser = User.builder().username("Salman")
//                .password(passwordEncoder().encode("12345"))
//                .roles("NORMAL")
//                .build();
//        
//        UserDetails adminUser = User.builder().username("Puddua")
//        		.password(passwordEncoder().encode("12345"))
//        		.roles("ADMIN")
//        		.build();
//
//     return  new InMemoryUserDetailsManager(normalUser,adminUser);
//    }
    
    
//    @Bean
//   UserDetailsService userDetailsService() { 
//     return  myUserDetailsService;
//        //return userDetails;
//    } 
//    
    
    
    
    
    
    
    // This Authorization mechanism used for Dao based authentication
    
    @Bean 
    AuthenticationProvider daoAuthenticationProvider() {
      DaoAuthenticationProvider provider =  new DaoAuthenticationProvider();
      provider.setPasswordEncoder(passwordEncoder());
      provider.setUserDetailsService(this.myUserDetailsService);
      return provider;
    }


    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

   
}
