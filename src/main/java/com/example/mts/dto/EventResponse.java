package com.example.mts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventResponse {

    private String name;
    private String description;
    private String eventType;
    private LocalDateTime startEvent;
    private LocalDateTime endEvent;
    private String place;
    private String scene;
    private Integer minAge;
    @Schema(type = "bool",
            description = "Флаг, который указывает на то, что на сцене есть места для инвалидов")
    private Boolean hasSeatForDisabled;
    @Schema(type = "bool",
            description = "Флаг, который указывает на то, что на данном мероприятии есть возможность получить услугу сопровождения для инвалидов")
    private Boolean canHelpDisabled;
    private List<Seat> seats;
}
