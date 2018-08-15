package com.snowfort.annals.entry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EntryServiceTests {

    WebTestClient client;

    @Before
    public void setUp() {
        client = WebTestClient
                .bindToServer()
                .baseUrl("http://localhost:8080")
                .build();
    }

    @Test
    public void contextLoads() {

    }

    @Test
    public void getEntries_withNoEntries() {
        // Given...

        // When...
        WebTestClient.ResponseSpec response = client.get()
                .uri("/api/entries")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange();

        // Then...
        response.expectStatus().isOk()
                .expectBody().json("[]");
    }

}
