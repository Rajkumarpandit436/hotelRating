package com.myproject.hotelservice.service;

import com.myproject.hotelservice.entity.Hotels;
import java.util.List;

public interface HotelService {

    Hotels saveHotels(Hotels hotels);
    Hotels getHotels(int id);
    List<Hotels> getAllHotels();
}
