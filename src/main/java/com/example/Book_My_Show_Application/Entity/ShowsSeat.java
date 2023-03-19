package com.example.Book_My_Show_Application.Entity;

import com.example.Book_My_Show_Application.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowsSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean isBooked;
    private int price;
    private String seatNumber;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    @CreationTimestamp
    private Date bookedAt;//seat booked time

    @ManyToOne
    @JoinColumn
    private Shows shows;
}
