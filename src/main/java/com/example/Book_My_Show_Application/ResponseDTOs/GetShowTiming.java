package com.example.Book_My_Show_Application.ResponseDTOs;

import lombok.Data;

@Data
public class GetShowTiming {
    private int movieId;
    private int theaterId;
}
