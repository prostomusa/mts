package com.example.mts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Entity
@Getter
@Setter
@Table(name = "place")
@FieldNameConstants
public class PlaceEntity extends AbstractEntity {

    private String name;

    private String city;

    private String description;
}
