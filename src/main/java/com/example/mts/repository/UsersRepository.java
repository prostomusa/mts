package com.example.mts.repository;

import com.example.mts.entity.SeatTypeEntity;
import com.example.mts.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long>, JpaSpecificationExecutor<UsersEntity> {
}
