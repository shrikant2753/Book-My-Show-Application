package com.example.Book_My_Show_Application.Converter;

import com.example.Book_My_Show_Application.Entity.Ticket;
import com.example.Book_My_Show_Application.ResponseDTOs.TicketsBookedByUser;

public class UserTicketConvertor {

    public static TicketsBookedByUser userTicketConvertor(Ticket ticket){
        TicketsBookedByUser ticketsBookedByUser = TicketsBookedByUser.builder()
                .ticketId(ticket.getTicketId())
                .totalPrice(ticket.getTotalPrice())
                .movieName(ticket.getMovieName())
                .showDate(ticket.getShowDate())
                .showTime(ticket.getShowTime())
                .theaterName(ticket.getTheaterName())
                .bookedSeat(ticket.getBookedSeat())
                .build();
        return ticketsBookedByUser;
    }
}
