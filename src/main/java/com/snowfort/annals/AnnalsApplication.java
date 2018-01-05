package com.snowfort.annals;

import com.snowfort.annals.model.TimelineEvent;
import com.snowfort.annals.model.TimelineEventRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.time.OffsetDateTime;
import java.util.UUID;

@SpringBootApplication
public class AnnalsApplication {

	@Bean
	ApplicationRunner demoData(TimelineEventRepository repository) {
		return args -> {
			repository.deleteAll().thenMany(
				Flux.just("Woke up", "Ate breakfast", "Worked all day", "Went to bed")
					.map(c -> new TimelineEvent(UUID.randomUUID().toString(), OffsetDateTime.now(), c))
					.flatMap(repository::save))
				.thenMany(repository.findAll())
				.subscribe(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(AnnalsApplication.class, args);
	}

}
