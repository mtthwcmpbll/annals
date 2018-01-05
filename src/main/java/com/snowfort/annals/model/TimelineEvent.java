package com.snowfort.annals.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;


@Document
public class TimelineEvent {

    @Id
    private String id;
    private OffsetDateTime occurredOn;
    private String rawContent;

    public TimelineEvent() {
        //init
    }

    public TimelineEvent(String id, OffsetDateTime occurredOn, String rawContent) {
        this.id = id;
        this.occurredOn = occurredOn;
        this.rawContent = rawContent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OffsetDateTime getOccurredOn() {
        return occurredOn;
    }

    public void setOccurredOn(OffsetDateTime occurredOn) {
        this.occurredOn = occurredOn;
    }

    public String getRawContent() {
        return rawContent;
    }

    public void setRawContent(String rawContent) {
        this.rawContent = rawContent;
    }
}
