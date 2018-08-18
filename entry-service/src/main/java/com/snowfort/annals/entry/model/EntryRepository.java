package com.snowfort.annals.entry.model;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends ReactiveMongoRepository<Entry, String> {
}
