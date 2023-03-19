package com.example.Book_My_Show_Application.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tickets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ticketId = UUID.randomUUID().toString();
    private int totalPrice;

    private String movie;
    private LocalDate showTiming;
    private LocalTime showDate;
    private String theater;
    private String bookedSeat;

    @JoinColumn
    @ManyToOne
    private User user;

    //Ticket is child wrt to showEntity
    @ManyToOne
    @JoinColumn
    private Shows shows;
}
