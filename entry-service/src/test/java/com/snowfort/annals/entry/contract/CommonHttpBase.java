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
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;
import java.util.Date;

import static org.mockito.Mockito.any;
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
                        new Entry("5b6fa36048ad6dbe795c0737", Date.from(OffsetDateTime.now().minusHours(2).toInstant()), "This is the first entry"),
                        new Entry("5b6fa36048ad6dbe795c0736", Date.from(OffsetDateTime.now().minusHours(1).toInstant()), "This is the second entry"),
                        new Entry("5b6fa36048ad6dbe795c0735", Date.from(OffsetDateTime.now().toInstant()), "This is the third entry")
                }));

        when(entryService.saveEntry(any(Entry.class))).thenAnswer(i -> {
            Entry e = (Entry)i.getArguments()[0];
            return Mono.just(Entry.builder().id("5b6fa36048ad6dbe795c073f")
                    .createdOn(new Date())
                    .body(e.getBody())
                    .build());
        });
    }

}
