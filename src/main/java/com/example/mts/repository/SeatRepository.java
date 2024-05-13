package com.example.mts.repository;

import com.example.mts.entity.SceneEntity;
import com.example.mts.entity.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<SeatEntity, Long>, JpaSpecificationExecutor<SeatEntity> {
}