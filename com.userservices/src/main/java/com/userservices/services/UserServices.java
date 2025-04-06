package com.userservices.services;

import org.springframework.stereotype.Service;

import com.userservices.entities.UserEntity;


public interface UserServices {

	UserEntity createUser(UserEntity uses);
}
