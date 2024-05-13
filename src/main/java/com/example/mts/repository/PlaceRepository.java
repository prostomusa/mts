package com.example.mts.repository;

import com.example.mts.entity.EventTypeEntity;
import com.example.mts.entity.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<PlaceEntity, Long>, JpaSpecificationExecutor<PlaceEntity> {
}
