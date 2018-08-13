package com.snowfort.annals.entry.api;

import com.snowfort.annals.entry.model.Entry;
import com.snowfort.annals.entry.services.EntryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.util.Date;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EntryApiTests {

	@LocalServerPort
	int port;

	WebTestClient client;

	@MockBean
	EntryService entryService;

	@Before
	public void setUp() {
		client = WebTestClient
				.bindToServer()
				.baseUrl("http://localhost:"+this.port)
				.build();
	}

	@Test
	public void getAllTimelineEvents_NoEvents() {
		// Given...
		when(entryService.getEvents()).thenReturn(Flux.empty());

		// When...
		WebTestClient.ResponseSpec response = client.get()
				.uri("/api/entries")
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.exchange();

		// Then...
		response.expectStatus().isOk()
				.expectBody().json("[]");
	}

	@Test
	public void getAllTimelineEvents_SeveralEvents() {
		// Given...
		Entry firstObject = new Entry("a", new Date(), "first event");
		Entry secondObject = new Entry("b", new Date(), "second event");
		when(entryService.getEvents()).thenReturn(Flux.just(firstObject, secondObject));

		// When...
		WebTestClient.ResponseSpec response = client.get()
				.uri("/api/entries")
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.exchange();

		// Then...
		response.expectStatus().isOk();
	}

}
