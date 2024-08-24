package com.lulski.blog.sage.mockapi;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.http.HttpStatus;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class PostApiTest {


//
//  @RegisterExtension
//  static WireMockExtension wireMockRule = WireMockExtension.newInstance().options(
//          WireMockConfiguration.wireMockConfig().dynamicPort()
//  ).build();

  private WireMockServer wireMockServer;

  @BeforeEach
  void setupMock() {
      wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().dynamicPort());
      wireMockServer.start();
  }

  @Test
  public void exampleTest() {

    String endpoint = "/api-v1/post";

    String jsonResponse = """
            {
                "id": 1,
                "name": "John Doe",
                "email": "johndoe@example.com",
                "roles": ["user", "admin"]
            }
            """;
    wireMockServer
        .stubFor(post(endpoint)
            .willReturn(aResponse()
                    .withHeader("Content-Type", "application/json")
                    .withBody(jsonResponse)
                    .withStatus(HttpStatus.OK.value())
            )
          );

    //call the mock endpoint using RestAssured
    String jsonRequest = """
            {
                "name": "John Doe",
                "email": "johndoe@example.com"
            }
            """;
    given()
            .baseUri(wireMockServer.baseUrl())
            .contentType("application/json")
            .body(jsonRequest)
            .when()
              .post(endpoint)
            .then()
              .statusCode(HttpStatus.OK.value())
            .body("id", equalTo(1))
            .body("name", equalTo("John Doe"))
            .body("email", equalTo("johndoe@example.com"))
            .body("roles[0]", equalTo("user"))
            .body("roles[1]", equalTo("admin"));
  }


}
