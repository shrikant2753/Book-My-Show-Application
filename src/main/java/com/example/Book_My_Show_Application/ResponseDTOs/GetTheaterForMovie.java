package com.example.Book_My_Show_Application.ResponseDTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class GetTheaterForMovie {
    private String theaterName;
    private String location;
}
