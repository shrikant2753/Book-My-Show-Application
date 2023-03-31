package com.example.Book_My_Show_Application.Converter;

import com.example.Book_My_Show_Application.Entity.Shows;
import com.example.Book_My_Show_Application.EntryDTOs.ShowEntryDto;

public class ShowConvertor {

    public static Shows convertDtoToEntity(ShowEntryDto showEntryDto){
        Shows shows = Shows.builder()
                .showDate(showEntryDto.getShowDate())
                .showTime(showEntryDto.getShowTime())
                .showType(showEntryDto.getShowType())
                .build();
        return shows;
    }
}
