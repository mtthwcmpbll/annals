package com.snowfort.annals;

import com.snowfort.annals.api.HelloApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApiControllerImpl implements HelloApi {

    @Override
    public ResponseEntity<String> helloGet() {
        return ResponseEntity.ok("Hello World!");
    }
}
