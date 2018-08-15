package com.snowfort.annals.entry.api;

import com.snowfort.annals.entry.model.Entry;
import com.snowfort.annals.entry.services.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/api/entries", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EntryApi {

    @Autowired
    private EntryService entryService;

    @GetMapping()
    public Flux<Entry> getEntries() {
        return entryService.getEvents();
    }

    @PostMapping()
    public Mono<Entry> postEntry(@RequestBody Entry entry) {
        return entryService.saveEntry(entry);
    }

}