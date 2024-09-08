package com.lulski.blog.sage.authentication;

import org.mockito.Mock;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@TestConfiguration
public class AuthenticationTestConfiguration {


  @Bean
  public UserDetailsService userDetailsService() {

    UserDetails user = User.builder().username("test")
            .password(passwordEncoder().encode("test"))
            .roles("USER").build();

    return new InMemoryUserDetailsManager(user);
  }


  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  };
}
