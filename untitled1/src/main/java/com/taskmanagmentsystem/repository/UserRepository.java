package com.taskmanagmentsystem.repository;


import com.taskmanagmentsystem.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> getByEmail(String email);


    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByEmailAndIdNot(String email,Integer id);
}
