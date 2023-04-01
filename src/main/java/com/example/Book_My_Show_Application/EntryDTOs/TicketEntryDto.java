package com.example.Book_My_Show_Application.EntryDTOs;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TicketEntryDto {
    private int showId;
    private List<String>requestedSeat  = new ArrayList<>();
    private int userId;
}
