package com.example.Book_My_Show_Application.Converter;

import com.example.Book_My_Show_Application.Entity.Ticket;
import com.example.Book_My_Show_Application.EntryDTOs.TicketEntryDto;

public class TicketConvertor {
     public static Ticket convertDtoToEntity(TicketEntryDto ticketEntryDto){
         Ticket ticket = new Ticket();
         return ticket;
     }
}
