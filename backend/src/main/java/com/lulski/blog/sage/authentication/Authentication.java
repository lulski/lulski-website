package com.lulski.blog.sage.authentication;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.lulski.blog.sage.util.Constant.PATH_LOGIN;

@RestController
public class Authentication {


  @PostMapping(PATH_LOGIN)
  public ResponseEntity<String> getToken(){

    System.out.println(">>>");
    return new ResponseEntity<String>("ok", HttpStatus.OK);
  }

}
