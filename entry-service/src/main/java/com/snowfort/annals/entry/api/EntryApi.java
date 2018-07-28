package com.snowfort.annals.entry.api;

import com.snowfort.annals.entry.model.Entry;
import com.snowfort.annals.entry.services.EntryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(path = "/entries", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EntryApi {

    private EntryService entryService;

    public EntryApi(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping()
    public Flux<Entry> getEntries() {
        return entryService.getEvents();
    }

}