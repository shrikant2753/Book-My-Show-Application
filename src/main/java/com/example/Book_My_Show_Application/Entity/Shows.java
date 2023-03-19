package com.example.Book_My_Show_Application.Entity;

import com.example.Book_My_Show_Application.Enums.ShowType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shows")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shows {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate showDate;
    private LocalTime showTime;

    @Enumerated(value = EnumType.STRING)
    private ShowType showType;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    //This is child wrt to the movieEntity
    @ManyToOne
    @JoinColumn
    private Movie movie;


    @ManyToOne
    @JoinColumn
    private Theater theaterEntity;

    //Show is parent wrt to ticket
    @OneToMany(mappedBy = "shows",cascade = CascadeType.ALL)
    private List<Ticket> listOfBookedTickets = new ArrayList<>();

    @OneToMany(mappedBy = "shows",cascade = CascadeType.ALL)
    private List<ShowsSeat> listOfShowSeats = new ArrayList<>();

}
