package com.example.mts.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "concrete_event")
@FieldNameConstants
public class ConcreteEventEntity extends AbstractEntity {

    @ManyToOne
    private EventEntity event;

    private LocalDateTime eventStart;

    private LocalDateTime eventEnd;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "concreteEvent")
    List<ConcreteEventUsersEntity> concreteEventUsers = new ArrayList<>();
}
