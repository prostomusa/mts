package com.example.mts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Seat {

    private Long id;
    private String title;

    private String seatType;

    private Boolean isReserved;
}
