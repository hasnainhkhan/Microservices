package com.userservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservices.entities.UserEntity;

public interface UserServiceRepo  extends JpaRepository<UserEntity, String>{

}
