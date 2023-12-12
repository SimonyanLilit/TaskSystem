package com.quotesystem.repository;

import com.quotesystem.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
UserEntity getById(Integer Id);
List<UserEntity> getByEmail(String email);
}
