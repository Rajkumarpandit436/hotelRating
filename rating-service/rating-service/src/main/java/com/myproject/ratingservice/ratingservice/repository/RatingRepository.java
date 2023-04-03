package com.myproject.ratingservice.ratingservice.repository;

import com.myproject.ratingservice.ratingservice.entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RatingRepository extends JpaRepository<Ratings, Integer> {

    List<Ratings> findByUserId(int userId);


    List<Ratings> findByHotelId(int hotelId);
}
