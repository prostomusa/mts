package com.example.mts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "concrete_event_users_seat")
public class ConcreteEventUsersSeatEntity extends AbstractEntity {

    @ManyToOne
    private ConcreteEventUsersEntity concreteEventUser;

    @ManyToOne
    private SeatEntity seat;
}
