package com.myproject.hotelservice.controller;

import com.myproject.hotelservice.entity.Hotels;
import com.myproject.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/createHotels")
    public ResponseEntity<Hotels> createHotels(@RequestBody Hotels hotels){
       Hotels createdHotel =  hotelService.saveHotels(hotels);
       return ResponseEntity.status(HttpStatus.CREATED).body(createdHotel);
    }

    @GetMapping("/id/{hotelId}")
    public ResponseEntity<Hotels> getHotels(@PathVariable("hotelId") int id){
        Hotels hotel = hotelService.getHotels(id);
        return ResponseEntity.ok(hotel);
    }

    @GetMapping("/allHotels")
    public ResponseEntity<List<Hotels>> getAllHotels(){
        List<Hotels> hotelsList =  hotelService.getAllHotels();
        return ResponseEntity.ok(hotelsList);
    }


}
