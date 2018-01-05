package com.snowfort.annals.model;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TimelineEventRepository extends ReactiveCrudRepository<TimelineEvent, String> {
}
