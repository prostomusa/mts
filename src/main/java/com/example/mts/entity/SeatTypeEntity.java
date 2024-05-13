package com.example.mts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Entity
@Getter
@Setter
@Table(name = "seat_type")
@FieldNameConstants
public class SeatTypeEntity extends AbstractEntity {
    private String title = SeatTypeEnum.COMMON;

    public static class SeatTypeEnum {
        public static String COMMON = "COMMON";
        public static String DISABLED = "CRIPPLE";
    }
}
