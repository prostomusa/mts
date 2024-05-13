package com.example.mts.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "concrete_event_users")
public class ConcreteEventUsersEntity extends AbstractEntity {

    @ManyToOne
    private ConcreteEventEntity concreteEvent;

    @ManyToOne
    private UsersEntity user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "concreteEventUser")
    List<ConcreteEventUsersSeatEntity> concreteEventUsersSeat = new ArrayList<>();
}
