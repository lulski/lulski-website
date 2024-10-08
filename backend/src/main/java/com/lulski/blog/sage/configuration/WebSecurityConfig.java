package com.lulski.blog.sage.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SpringSecurity example.
 * <a href="https://docs.spring.io/spring-security/reference/servlet/authentication/architecture.html">...</a>
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

  @Bean
  @Profile("prod")
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.authorizeHttpRequests((auth) -> auth.anyRequest().authenticated()).httpBasic(Customizer.withDefaults()).formLogin(Customizer.withDefaults());

    return httpSecurity.build();
  }

  @Bean
  @Profile("dev")
  public SecurityFilterChain devSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests((auth) -> auth.anyRequest().permitAll());


    return httpSecurity.build();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails user = User.builder().username("kocu").password("beraknanah").roles("USER").build();

    UserDetails admin = User.builder().username("admin").password("beraknanah").roles("ADMIN","USER").build();


    return new InMemoryUserDetailsManager(user,admin);
  }

  @Bean
  public PasswordEncoder passwordEncoder(){
    return  new BCryptPasswordEncoder();
  }


}
