package com.example.Book_My_Show_Application.Controller;

import com.example.Book_My_Show_Application.Entity.Theater;
import com.example.Book_My_Show_Application.EntryDTOs.TheaterEntryDto;
import com.example.Book_My_Show_Application.ResponseDTOs.GetTheaterForMovie;
import com.example.Book_My_Show_Application.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theater")
public class TheaterController {
    @Autowired
    TheaterService theaterService;

    @PostMapping("/add")
    public ResponseEntity<String> addTheater(@RequestBody TheaterEntryDto theaterEntryDto){
        try{
            String response = theaterService.addTheater(theaterEntryDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            String response =  e.getMessage();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getTheaterForMovie")
    public List<GetTheaterForMovie> getTheatersForMovie(@RequestParam int movieId){
        return theaterService.getTheaterForMovie(movieId);
    }

    @GetMapping("/getLocations")
    public List<String>getUniqueLocations(){
        return theaterService.getUniqueLocations();
    }
}
