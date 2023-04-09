package com.example.Book_My_Show_Application.ResponseDTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketsBookedByUser {

    private String ticketId;
    private int totalPrice;
    private String movieName;
    private LocalDate showDate;
    private LocalTime showTime;
    private String theaterName;
    private String bookedSeat;
}
