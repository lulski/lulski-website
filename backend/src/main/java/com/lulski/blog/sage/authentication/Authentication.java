package com.lulski.blog.sage.authentication;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

import static com.lulski.blog.sage.util.Constant.PATH_LOGIN;

@RestController
public class Authentication {

  @GetMapping(PATH_LOGIN)
  public ResponseEntity<String> getToken(){

    var response = new ResponseEntity<String>("ok", HttpStatus.OK);

    return  response;
  }

}
