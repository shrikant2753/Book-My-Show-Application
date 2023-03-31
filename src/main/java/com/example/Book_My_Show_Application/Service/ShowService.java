package com.example.Book_My_Show_Application.Service;

import com.example.Book_My_Show_Application.Converter.ShowConvertor;
import com.example.Book_My_Show_Application.Entity.*;
import com.example.Book_My_Show_Application.EntryDTOs.ShowEntryDto;
import com.example.Book_My_Show_Application.Enums.SeatType;
import com.example.Book_My_Show_Application.Repository.MovieRepository;
import com.example.Book_My_Show_Application.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {


    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheaterRepository theaterRepository;

    public String addShow(ShowEntryDto showEntryDto) throws Exception{
        Shows shows = ShowConvertor.convertDtoToEntity(showEntryDto);

        int movieID = showEntryDto.getMovieId();
        int theaterId = showEntryDto.getTheaterId();

        Movie movie = movieRepository.findById(movieID).get();
        Theater theater = theaterRepository.findById(theaterId).get();

        shows.setMovie(movie);
        shows.setTheaterEntity(theater);

        List<ShowsSeat> showsSeatList = createShowSeatEntity(showEntryDto, shows);
        shows.setListOfShowSeats(showsSeatList);

        //now we need to update the parent entities
        List<Shows> showsList = movie.getShowsList();
        showsList.add(shows);
        movie.setShowsList(showsList);
        movieRepository.save(movie);

        List<Shows> showsList1 = theater.getShowEntityList();
        showsList1.add(shows);
        theater.setShowEntityList(showsList1);
        theaterRepository.save(theater);

        return "Show added successfully";
    }

    private List<ShowsSeat> createShowSeatEntity(ShowEntryDto showEntryDto, Shows shows){
        Theater theater = shows.getTheaterEntity();
        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatEntityList();

        List<ShowsSeat> showsSeatList = new ArrayList<>();

        for(TheaterSeat theaterSeat : theaterSeatList){
            ShowsSeat showsSeat = new ShowsSeat();
            showsSeat.setSeatNumber(theaterSeat.getSeatNumber());
            showsSeat.setSeatType(theaterSeat.getSeatType());
            if(theaterSeat.getSeatType().equals(SeatType.PREMIUM)){
                showsSeat.setPrice(showEntryDto.getPremiumSeatPrice());
            }
            else{
                showsSeat.setPrice(showEntryDto.getClassicSeatPrice());
            }
            showsSeat.setBooked(false);
            showsSeat.setShows(shows);//parent : foreign key for the showSeatEntity
            showsSeatList.add(showsSeat);
        }
        return showsSeatList;
    }
}
