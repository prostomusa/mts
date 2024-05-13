package com.example.mts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaceResponse {

    private String name;

    private String city;

    private String description;

    private List<EventListResponse> eventList;
}
