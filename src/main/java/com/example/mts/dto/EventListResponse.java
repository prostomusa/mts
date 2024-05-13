package com.example.mts.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventListResponse {

    private String name;
    private String place;
    private Integer minAge;
    private Boolean hasSeatForDisabled;
}
