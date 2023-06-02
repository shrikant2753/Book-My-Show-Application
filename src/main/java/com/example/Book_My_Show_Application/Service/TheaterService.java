package com.example.Book_My_Show_Application.Service;

import com.example.Book_My_Show_Application.Converter.TheaterConvertor;
import com.example.Book_My_Show_Application.Entity.Shows;
import com.example.Book_My_Show_Application.Entity.Theater;
import com.example.Book_My_Show_Application.Entity.TheaterSeat;
import com.example.Book_My_Show_Application.EntryDTOs.TheaterEntryDto;
import com.example.Book_My_Show_Application.Enums.SeatType;
import com.example.Book_My_Show_Application.Repository.ShowRepository;
import com.example.Book_My_Show_Application.Repository.TheaterRepository;
import com.example.Book_My_Show_Application.Repository.TheaterSeatRepository;
import com.example.Book_My_Show_Application.ResponseDTOs.GetTheaterForMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {
    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    @Autowired
    ShowRepository showRepository;

    public String addTheater(TheaterEntryDto theaterEntryDto) throws Exception{

        if(theaterEntryDto.getName()==null || theaterEntryDto.getLocation()==null){
            throw new Exception("Name and location should be valid");
        }

//        if(theaterRepository.findByName(theaterEntryDto.getName())!=null){
//            throw new Exception("Theater name should be unique");
//        }

        if(theaterEntryDto.getClassicSeatCount() < 0 || theaterEntryDto.getPremiumSeatCount() < 0){
            throw new Exception("Theater seats should not be negative");
        }

        Theater theater = TheaterConvertor.convertTheaterDtoToEntity(theaterEntryDto);
        List<TheaterSeat> theaterSeatList = createTheater(theaterEntryDto, theater);
        theater.setTheaterSeatEntityList(theaterSeatList);
        theaterRepository.save(theater);
        return " Theater Added Successfully";
    }

    private List<TheaterSeat> createTheater(TheaterEntryDto theaterEntryDto, Theater theater){
        int countOfClassicSeat = theaterEntryDto.getClassicSeatCount();
        int countOfPremiumSeat = theaterEntryDto.getPremiumSeatCount();
        List<TheaterSeat> theaterSeatList = new ArrayList<>();

        //create a classic seat
        for(int i=1; i<=countOfClassicSeat; i++){
            TheaterSeat theaterSeat = TheaterSeat.builder()
                    .seatType(SeatType.CLASSIC)
                    .seatNumber("C"+i)
                    .theaterEntity(theater)
                    .build();
            theaterSeatList.add(theaterSeat);
        }

        //create a premium seat
        for(int i=1; i<=countOfPremiumSeat; i++){
            TheaterSeat theaterSeat = TheaterSeat.builder()
                    .seatType(SeatType.PREMIUM)
                    .seatNumber("P"+i)
                    .theaterEntity(theater)
                    .build();
            theaterSeatList.add(theaterSeat);
        }

        return theaterSeatList;
    }

    public List<GetTheaterForMovie> getTheaterForMovie(int movieId){
        List<GetTheaterForMovie> theaterList = new ArrayList<>();
        List<Shows>showsList = showRepository.findAll();

        for(Shows shows : showsList){
            if(shows.getMovie().getId()==movieId){
                if(!theaterList.contains(shows.getTheaterEntity())){
                    GetTheaterForMovie listEntry = TheaterConvertor.convertTheaterDtoToEntity(shows.getTheaterEntity());
                    if(!theaterList.contains(listEntry))
                        theaterList.add(listEntry);
                }
            }
        }
        return theaterList;
    }

    public List<String> getUniqueLocations(){
        List<String> locationsList = new ArrayList<>();
        List<Theater> theaterList = theaterRepository.findAll();

        for(Theater theater : theaterList){
            if(!locationsList.contains(theater.getLocation())){
                locationsList.add(theater.getLocation());
            }
        }
        return locationsList;
    }
}
