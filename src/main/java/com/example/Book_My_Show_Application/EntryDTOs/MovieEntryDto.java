package com.example.Book_My_Show_Application.EntryDTOs;

import com.example.Book_My_Show_Application.Enums.Genre;
import com.example.Book_My_Show_Application.Enums.Language;
import lombok.Data;

@Data
public class MovieEntryDto {
    private String movieName;
    private double rating;
    private int duration;//in minute
    private Language language;
    private Genre genre;
}
