package com.lulski.blog.sage.authentication;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

import static com.lulski.blog.sage.util.Constant.PATH_LOGIN;

@RestController
public class Authentication {

  UserDetailsService userDetailsService;

  PasswordEncoder passwordEncoder;

  public Authentication(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
      this.userDetailsService = userDetailsService;
      this.passwordEncoder = passwordEncoder;
  }

  @PostMapping(PATH_LOGIN)
  public ResponseEntity<String> getToken(@RequestParam("username") String inputUsername,
                                         @RequestParam("password") String inputPassword) throws AuthenticationException {
    UserDetails user = userDetailsService.loadUserByUsername(inputUsername);

    if (inputUsername == null){
      throw new UsernameNotFoundException("User not found");
    }

    if (passwordEncoder.matches(inputPassword,user.getPassword())){
      var username = user.getUsername();
      return new ResponseEntity<String>("welcome " +username, HttpStatus.OK);

    }else{
      throw new AuthenticationException("Credentials doesn't match");
    }

  }

}
