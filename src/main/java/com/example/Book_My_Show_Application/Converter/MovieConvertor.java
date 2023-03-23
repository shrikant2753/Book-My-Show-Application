package com.example.Book_My_Show_Application.Converter;

import com.example.Book_My_Show_Application.Entity.Movie;
import com.example.Book_My_Show_Application.EntryDTOs.MovieEntryDto;

public class MovieConvertor {

    public static Movie convertDtoToEntity(MovieEntryDto movieEntryDto){
        Movie movie = Movie.builder()
                .movieName(movieEntryDto.getMovieName())
                .rating(movieEntryDto.getRating())
                .duration(movieEntryDto.getDuration())
                .genre(movieEntryDto.getGenre())
                .language(movieEntryDto.getLanguage())
                .build();
        return movie;
    }
}
