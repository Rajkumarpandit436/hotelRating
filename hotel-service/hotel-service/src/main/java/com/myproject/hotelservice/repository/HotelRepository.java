package com.myproject.hotelservice.repository;

import com.myproject.hotelservice.entity.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotels, Integer> {


}
