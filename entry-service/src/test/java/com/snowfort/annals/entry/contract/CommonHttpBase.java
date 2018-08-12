package com.snowfort.annals.entry.contract;

import com.snowfort.annals.entry.model.Entry;
import com.snowfort.annals.entry.services.EntryService;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

import java.time.OffsetDateTime;
import java.util.UUID;

import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public abstract class CommonHttpBase {

    @LocalServerPort
    int port;

    @MockBean
    private EntryService entryService;

    @Before
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = this.port;

        when(entryService.getEvents()).thenReturn(Flux.fromArray(
                new Entry[] {
                        new Entry(UUID.randomUUID().toString(), OffsetDateTime.now().minusHours(2), "This is the first entry"),
                        new Entry(UUID.randomUUID().toString(), OffsetDateTime.now().minusHours(1), "This is the second entry"),
                        new Entry(UUID.randomUUID().toString(), OffsetDateTime.now(), "This is the third entry")
                }));
    }

}
