package com.example.Book_My_Show_Application.Converter;

import com.example.Book_My_Show_Application.Entity.Theater;
import com.example.Book_My_Show_Application.EntryDTOs.TheaterEntryDto;
import com.example.Book_My_Show_Application.ResponseDTOs.GetTheaterForMovie;

public class TheaterConvertor {

        public static Theater convertTheaterDtoToEntity(TheaterEntryDto theaterEntryDto){
            return Theater.builder()
                    .theaterName(theaterEntryDto.getName())
                    .location(theaterEntryDto.getLocation())
                    .build();

        }

    public static GetTheaterForMovie convertTheaterDtoToEntity(Theater theater){
        GetTheaterForMovie getTheaterForMovie =  GetTheaterForMovie.builder()
                .theaterName(theater.getTheaterName())
                .location(theater.getLocation())
                .build();
        return getTheaterForMovie;
    }
}
