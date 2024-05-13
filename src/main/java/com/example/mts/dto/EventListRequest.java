package com.example.mts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventListRequest {

    private Integer minAge;

    private Boolean hasSeatForDisabled = Boolean.TRUE;

    private String eventType;
}
