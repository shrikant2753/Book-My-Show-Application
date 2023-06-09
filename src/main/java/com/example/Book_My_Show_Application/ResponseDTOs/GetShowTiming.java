package com.example.Book_My_Show_Application.ResponseDTOs;

import com.example.Book_My_Show_Application.Enums.ShowType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetShowTiming {
    private LocalDate showDate;
    private LocalTime showTime;
    private ShowType showType;
    private Date createdOn;
    private String movie;
    private String theater;
}
