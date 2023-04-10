package com.example.Book_My_Show_Application.Controller;

import com.example.Book_My_Show_Application.Entity.Shows;
import com.example.Book_My_Show_Application.EntryDTOs.ShowEntryDto;
import com.example.Book_My_Show_Application.EntryDTOs.ShowTiming;
import com.example.Book_My_Show_Application.ResponseDTOs.GetShowTiming;
import com.example.Book_My_Show_Application.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/add")
    public ResponseEntity<String> addShow(@RequestBody ShowEntryDto showEntryDto){
        try{
            return new ResponseEntity<>(showService.addShow(showEntryDto), HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getShowTiming")
    public List<GetShowTiming> getShowsTiming(@RequestBody ShowTiming showTiming){
        System.out.println(showTiming.getMovieId());
        try{
            return showService.getShowsTiming(showTiming);
        }
        catch(Exception e){
            return null;
        }
    }
}