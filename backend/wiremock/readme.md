start WireMock server using this command

`docker run -it --rm \
-p 8080:8080 \
--name wiremock \
-v /Users/lulski/projects/java/sage/wiremock:/home/wiremock \
wiremock/wiremock:3.9.1`