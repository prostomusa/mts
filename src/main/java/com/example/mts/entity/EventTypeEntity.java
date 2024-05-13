package com.example.mts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Entity
@Getter
@Setter
@Table(name = "event_type")
@FieldNameConstants
public class EventTypeEntity extends AbstractEntity {

    private String name;
}
