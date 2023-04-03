package com.myproject.ratingservice.ratingservice.service;

import com.myproject.ratingservice.ratingservice.entity.Ratings;

import java.util.List;

public interface RatingService {

    Ratings saveRatings(Ratings ratings);

    List<Ratings> getAllRatings();

    List<Ratings> getAllRatingsByUserId(int userId);

    List<Ratings> getAllRatingsByHotelId(int hotelId);
    Ratings getRatings(int id);
}
