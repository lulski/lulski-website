package com.lulski.blog.sage.authentication;

import com.lulski.blog.sage.configuration.WebSecurityConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.test.context.ContextConfiguration;

import javax.naming.AuthenticationException;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {Authentication.class, AuthenticationTestConfiguration.class})
@SpringBootTest
class AuthenticationTest {

  private UserDetailsService userDetailsService;

  private String encodedPassword;

  private String rawPassword = "validPassword";

  @Autowired
  Authentication authentication;

  @BeforeEach
  void setUp() {
    var passwordEncoder = new BCryptPasswordEncoder();
    this.encodedPassword = passwordEncoder.encode(rawPassword);
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void testPasswordMatching() throws AuthenticationException {
      authentication.getToken("test", "test");
  }
}