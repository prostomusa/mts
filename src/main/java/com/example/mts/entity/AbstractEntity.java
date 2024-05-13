package com.example.mts.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
@Getter
public abstract class AbstractEntity {

    public static final String ID_COLUMN_NAME = "id";

    @Id
    @GeneratedValue
    private Long id;

}