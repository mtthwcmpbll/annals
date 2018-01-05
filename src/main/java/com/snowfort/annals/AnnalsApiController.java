package com.snowfort.annals;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class AnnalsApiController {

    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("Hello reactive world!");
    }

}
