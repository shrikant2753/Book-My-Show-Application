package com.example.Book_My_Show_Application.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Theaters")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String theaterName;

    @NonNull
    private String location;

    //This is the parent wrt to theaterSeats
    @OneToMany(mappedBy = "theaterEntity",cascade = CascadeType.ALL)
    private List<TheaterSeat> theaterSeatEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "theaterEntity",cascade = CascadeType.ALL)
    private List<Shows> showEntityList = new ArrayList<>();
}
