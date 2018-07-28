package com.snowfort.annals.entry.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entry {

    @Id
    private String id;
    private OffsetDateTime createdOn;
    private String body;

}
