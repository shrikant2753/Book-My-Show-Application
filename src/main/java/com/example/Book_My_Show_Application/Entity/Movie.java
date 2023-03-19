package com.example.Book_My_Show_Application.Entity;

import com.example.Book_My_Show_Application.Enums.Genre;
import com.example.Book_My_Show_Application.Enums.Language;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    @Nonnull
    private String movieName;
    private double rating;
    private int duration;//in minute

    @Enumerated(value = EnumType.STRING)
    private Language language;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    //this is parent wrt show
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Shows> showsList = new ArrayList<>();

}
