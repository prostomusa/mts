package com.example.mts.repository;

import com.example.mts.entity.ConcreteEventEntity;
import com.example.mts.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConcreteEventRepository extends JpaRepository<ConcreteEventEntity, Long>, JpaSpecificationExecutor<ConcreteEventEntity> {

    List<ConcreteEventEntity> findAllByEventId(Long eventId);
}
