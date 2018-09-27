package com.snowfort.annals.entry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoReactiveAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

import java.util.function.BiFunction;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;

@SpringBootApplication
@EnableSwagger2WebFlux
@EnableReactiveMongoRepositories
public class EntryServiceApplication {

	public static void main(String[] args) {
	    //TODO: remove after verifying this does in fact get run on PFC (yay JDK 11!)
		BiFunction<Object, Object, String> formatter = (var x, var y) -> "Yay, JDK 11!!!  " + x.toString() + y.toString();
        System.out.println(formatter.apply(1, 2));

		SpringApplication.run(EntryServiceApplication.class, args);
	}

}
