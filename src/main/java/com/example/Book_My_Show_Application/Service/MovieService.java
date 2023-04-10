package com.example.Book_My_Show_Application.Service;

import com.example.Book_My_Show_Application.Converter.MovieConvertor;
import com.example.Book_My_Show_Application.Entity.Movie;
import com.example.Book_My_Show_Application.Entity.Ticket;
import com.example.Book_My_Show_Application.EntryDTOs.MovieEntryDto;
import com.example.Book_My_Show_Application.Repository.MovieRepository;
import com.example.Book_My_Show_Application.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TicketRepository ticketRepository;

    public String addMovie(MovieEntryDto movieEntryDto)throws Exception{
        Movie movie = MovieConvertor.convertDtoToEntity(movieEntryDto);
        movieRepository.save(movie);
        return "Movie Added successfully";
    }

    public int getTotalCollectionOfMovie(String movieName){
        int totalCollection = 0;
        List<Ticket> ticketList = ticketRepository.findAll();

        for(Ticket ticket : ticketList){
            if(movieName.equalsIgnoreCase(ticket.getMovieName())){
                totalCollection += ticket.getTotalPrice();
            }
        }

        return totalCollection;
    }

    public List<String>getMovies(){
        List<String> movieList = new ArrayList<>();
        List<Movie> moviesList = movieRepository.findAll();

        for(Movie movie : moviesList){
            if(!movieList.contains(movie.getMovieName()))
                movieList.add(movie.getMovieName());
        }
        return movieList;
    }
}
