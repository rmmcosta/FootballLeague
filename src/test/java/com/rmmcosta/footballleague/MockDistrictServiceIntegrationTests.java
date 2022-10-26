package com.rmmcosta.footballleague;

import com.rmmcosta.footballleague.entity.District;
import com.rmmcosta.footballleague.web.DistrictController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MockDistrictServiceIntegrationTests {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void shouldCreateNewDistrict() {
        webTestClient
                .post()
                .uri("/district")
                .bodyValue("""
                         {
                          "id": "34",
                          "name": "Algarve"
                         }
                        """)
                .header(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .headers(headers -> headers.setBasicAuth("admin", "password"))
                .exchange()
                .expectStatus()
                .isCreated();
    }

    @Test
    public void getDistrict() {
        webTestClient
                .get()
                .uri("/district/1")
                .headers(headers -> headers.setBasicAuth("admin", "password"))
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(District.class);
    }

    @Test
    public void getAllDistricts() {
        webTestClient
                .get()
                .uri("/district")
                .headers(headers -> headers.setBasicAuth("admin", "password"))
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(District.class);
    }
}
