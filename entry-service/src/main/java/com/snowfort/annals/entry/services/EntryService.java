package com.snowfort.annals.entry.services;

import com.snowfort.annals.entry.model.Entry;
import com.snowfort.annals.entry.model.EntryRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class EntryService {

    private EntryRepository repository;

    public EntryService(EntryRepository repository) {
        this.repository = repository;
    }

    public Flux<Entry> getEvents() {
        return repository.findAll();
    }
}