package com.example.Book_My_Show_Application.Converter;

import com.example.Book_My_Show_Application.Entity.Shows;
import com.example.Book_My_Show_Application.EntryDTOs.ShowEntryDto;
import com.example.Book_My_Show_Application.ResponseDTOs.GetShowTiming;

public class ShowConvertor {

    public static Shows convertDtoToEntity(ShowEntryDto showEntryDto){
        Shows shows = Shows.builder()
                .showDate(showEntryDto.getShowDate())
                .showTime(showEntryDto.getShowTime())
                .showType(showEntryDto.getShowType())
                .build();
        return shows;
    }

    public static GetShowTiming convertToResponseDto(Shows show){
        GetShowTiming getShowTiming1 = GetShowTiming.builder()
                .showDate(show.getShowDate())
                .showTime(show.getShowTime())
                .showType(show.getShowType())
                .createdOn(show.getCreatedOn())
                .movie(show.getMovie().getMovieName())
                .theater(show.getTheaterEntity().getTheaterName())
                .build();
        return getShowTiming1;
    }
}
