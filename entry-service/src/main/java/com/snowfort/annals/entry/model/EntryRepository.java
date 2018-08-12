package com.snowfort.annals.entry.model;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface EntryRepository extends ReactiveMongoRepository<Entry, String> {
}
