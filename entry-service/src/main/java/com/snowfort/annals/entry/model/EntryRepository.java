package com.snowfort.annals.entry.model;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface EntryRepository extends ReactiveCrudRepository<Entry, String> {
}
