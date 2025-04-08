package com.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.entities.HotelEntity;

public interface HotelRepo  extends JpaRepository<HotelEntity, String>{

}
