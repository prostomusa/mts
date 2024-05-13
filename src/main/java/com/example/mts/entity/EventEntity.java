package com.example.mts.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "event")
@FieldNameConstants
public class EventEntity extends AbstractEntity {
    private String name;

    @ManyToOne
    private SceneEntity scene;

    @ManyToOne
    private EventTypeEntity eventType;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "event")
    List<ConcreteEventEntity> concreteEvents = new ArrayList<>();

    private Integer minAge;

    private String description;

    private Boolean canHelpDisabled;
}
