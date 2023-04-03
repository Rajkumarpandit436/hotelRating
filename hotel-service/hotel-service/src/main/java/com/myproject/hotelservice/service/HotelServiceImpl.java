package com.myproject.hotelservice.service;

import com.myproject.hotelservice.entity.Hotels;
import com.myproject.hotelservice.entity.Ratings;
import com.myproject.hotelservice.exception.ResourceNotFoundException;
import com.myproject.hotelservice.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Hotels saveHotels(Hotels hotels) {
        return hotelRepository.save(hotels);
    }

    @Override
    public Hotels getHotels(int id) {
        Hotels hotels = hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource Not Found on the server with id : "+id));
        List<Ratings> ratingsList = restTemplate.getForObject("http://RATING-SERVICE/ratings/hotel/"+id, ArrayList.class);
        hotels.setHotelRating(ratingsList);
        return hotels;
    }

    @Override
    public List<Hotels> getAllHotels() {
        List<Hotels> hotelsList = hotelRepository.findAll();
        List<Hotels> newHotelsList=new ArrayList<>();
        for (Hotels hotels:hotelsList){
            List<Ratings> ratingsList = restTemplate.getForObject("http://RATING-SERVICE/ratings/hotel/"+hotels.getHotelId(), ArrayList.class);
            hotels.setHotelRating(ratingsList);
            newHotelsList.add(hotels);
        }
        return newHotelsList;
    }
}
