package com.example.Book_My_Show_Application.Converter;

import com.example.Book_My_Show_Application.Entity.User;
import com.example.Book_My_Show_Application.EntryDTOs.UserEntryDto;

public class UserConverter {
    public static User convertDtoToEntity(UserEntryDto userEntryDto){
        User user = User.builder()
            .name(userEntryDto.getName())
            .email(userEntryDto.getEmail())
            .mobNumber(userEntryDto.getMobNumber())
            .address(userEntryDto.getAddress())
            .age(userEntryDto.getAge())
            .build();//this is set all the attributes is one go
        return user;
    }
}
