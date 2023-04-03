package com.myproject.ratingservice.ratingservice.controller;

import com.myproject.ratingservice.ratingservice.entity.Ratings;
import com.myproject.ratingservice.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/createRating")
    public ResponseEntity<Ratings> createRatings(@RequestBody Ratings ratings){
        Ratings createdRatings = ratingService.saveRatings(ratings);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRatings);
    }


    @GetMapping("/id/{ratingId}")
    public ResponseEntity<Ratings> getRatings(@PathVariable("ratingId") int id){
        Ratings ratings = ratingService.getRatings(id);
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/allRatings")
    public ResponseEntity<List<Ratings>> getAllRatings(){
        List<Ratings> ratingsList = ratingService.getAllRatings();
        return ResponseEntity.ok(ratingsList);
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<List<Ratings>> getAllRatingByUserId(@PathVariable("userId") int userId){
       List<Ratings> userRating = ratingService.getAllRatingsByUserId(userId);
       return ResponseEntity.ok(userRating);
    }

    @GetMapping("hotel/{hotelId}")
    public ResponseEntity<List<Ratings>> getAllRatingByHotelId(@PathVariable("hotelId") int hotelId){
        List<Ratings> hotelRating = ratingService.getAllRatingsByHotelId(hotelId);
        return ResponseEntity.ok(hotelRating);
    }
}
