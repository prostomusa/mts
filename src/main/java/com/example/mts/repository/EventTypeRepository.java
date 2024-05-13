package com.example.mts.repository;

import com.example.mts.entity.ConcreteEventUsersSeatEntity;
import com.example.mts.entity.EventEntity;
import com.example.mts.entity.EventTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTypeRepository extends JpaRepository<EventTypeEntity, Long>, JpaSpecificationExecutor<EventTypeEntity> {
}
