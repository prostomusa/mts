package com.example.mts.repository;

import com.example.mts.entity.ConcreteEventUsersSeatEntity;
import com.example.mts.entity.EventEntity;
import com.example.mts.entity.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long>, JpaSpecificationExecutor<EventEntity> {

    List<EventEntity> findAllByScenePlaceId(Long placeId);
}