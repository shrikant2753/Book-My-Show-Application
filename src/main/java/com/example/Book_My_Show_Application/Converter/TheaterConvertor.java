package com.example.Book_My_Show_Application.Converter;

import com.example.Book_My_Show_Application.Entity.Theater;
import com.example.Book_My_Show_Application.EntryDTOs.TheaterEntryDto;

public class TheaterConvertor {

        public static Theater convertTheaterDtoToEntity(TheaterEntryDto theaterEntryDto){
            return Theater.builder()
                    .theaterName(theaterEntryDto.getName())
                    .location(theaterEntryDto.getLocation())
                    .build();

        }
}
