package com.lulski.blog.sage.service;

import com.lulski.blog.sage.configuration.WebClientConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@WebFluxTest
@ContextConfiguration(classes = {ReactiveServiceExample.class, WebClientConfig.class})
class ReactiveServiceExampleTest {


  @Autowired
  ReactiveServiceExample reactiveServiceExample;

  @Test
  public void i_am_sad() {
    String apiPath = "/swamp/thing"; // Replace with your actual API path

    // Example request payload
    Map<String, Object> payload = new HashMap<>();
    payload.put("key1", "value1");
    payload.put("key2", "value2");

    Map<String, Object> response = reactiveServiceExample.postDataToApi(apiPath,payload);

    System.out.println(">>>");

  }
}