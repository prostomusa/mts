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
@Table(name = "scene")
@FieldNameConstants
public class SceneEntity extends AbstractEntity {

    private String name;

    @ManyToOne
    private PlaceEntity place;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "scene")
    List<SeatEntity> seats = new ArrayList<>();

}