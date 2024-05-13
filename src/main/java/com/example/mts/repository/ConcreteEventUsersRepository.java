package com.example.mts.repository;

import com.example.mts.entity.ConcreteEventEntity;
import com.example.mts.entity.ConcreteEventUsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcreteEventUsersRepository extends JpaRepository<ConcreteEventUsersEntity, Long>, JpaSpecificationExecutor<ConcreteEventUsersEntity> {
}