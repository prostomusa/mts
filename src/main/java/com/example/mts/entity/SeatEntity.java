package com.example.mts.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Entity
@Getter
@Setter
@Table(name = "seat")
@FieldNameConstants
public class SeatEntity extends AbstractEntity {
    private String title;

    @ManyToOne
    private SceneEntity scene;

    @ManyToOne
    private SeatTypeEntity seatType;
}
