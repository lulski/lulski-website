package com.lulski.blog.sage.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class ReactiveServiceExample {

  private final WebClient webClient;
  private final ObjectMapper objectMapper;

  public ReactiveServiceExample(WebClient.Builder webClientBuilder, ObjectMapper objectMapper) {
    this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build(); // Replace base URL as needed
    this.objectMapper = objectMapper;
  }

  public Map<String, Object> postDataToApi(String path, Map<String, Object> requestPayload) {
    try {
      // Make the POST request
      String response = webClient.post()
              .uri(path)
              .bodyValue(requestPayload)
              .retrieve()
              .bodyToMono(String.class)
              .block();  // Block the current thread to wait for the response

      // Parse the response body into a Map
      return objectMapper.readValue(response, Map.class);
    } catch (Exception e) {
      // Handle exceptions
      throw new RuntimeException("An error occurred while consuming the API", e);
    }
  }
}
