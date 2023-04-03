package com.myproject.ratingservice.ratingservice.service;

import com.myproject.ratingservice.ratingservice.entity.Ratings;
import com.myproject.ratingservice.ratingservice.exception.ResourceNotFoundException;
import com.myproject.ratingservice.ratingservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Ratings saveRatings(Ratings ratings) {
        return ratingRepository.save(ratings);
    }

    @Override
    public List<Ratings> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Ratings> getAllRatingsByUserId(int userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Ratings> getAllRatingsByHotelId(int hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public Ratings getRatings(int id) {
        return ratingRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("resource not found on the server with id: "+id));
    }
}
