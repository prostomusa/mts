package com.example.mts.repository;

import com.example.mts.entity.ConcreteEventUsersEntity;
import com.example.mts.entity.ConcreteEventUsersSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcreteEventUsersSeatRepository extends JpaRepository<ConcreteEventUsersSeatEntity, Long>, JpaSpecificationExecutor<ConcreteEventUsersSeatEntity> {
}
