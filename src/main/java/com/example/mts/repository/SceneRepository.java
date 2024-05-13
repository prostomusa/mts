package com.example.mts.repository;

import com.example.mts.entity.PlaceEntity;
import com.example.mts.entity.SceneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SceneRepository extends JpaRepository<SceneEntity, Long>, JpaSpecificationExecutor<SceneEntity> {
}
