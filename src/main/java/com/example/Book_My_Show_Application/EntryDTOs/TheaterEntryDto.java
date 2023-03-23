package com.example.Book_My_Show_Application.EntryDTOs;

import lombok.Data;

@Data
public class TheaterEntryDto {
    private String name;
    private String location;
    private int classicSeatCount;
    private int premiumSeatCount;
}

