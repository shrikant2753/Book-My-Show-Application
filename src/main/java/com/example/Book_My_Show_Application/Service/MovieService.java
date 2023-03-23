package com.example.Book_My_Show_Application.Service;

import com.example.Book_My_Show_Application.Converter.MovieConvertor;
import com.example.Book_My_Show_Application.Entity.Movie;
import com.example.Book_My_Show_Application.EntryDTOs.MovieEntryDto;
import com.example.Book_My_Show_Application.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieEntryDto movieEntryDto)throws Exception{
        Movie movie = MovieConvertor.convertDtoToEntity(movieEntryDto);
        movieRepository.save(movie);
        return "Movie save successfully";
    }
}
