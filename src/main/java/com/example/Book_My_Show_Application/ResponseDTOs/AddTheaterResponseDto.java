package com.example.Book_My_Show_Application.ResponseDTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AddTheaterResponseDto {
    private String name;
    private String location;
    private int classicSeatCount;
    private int premiumSeatCount;
}
