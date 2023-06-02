package com.example.Book_My_Show_Application.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String name;

    @Column(unique = true, nullable = false)
    private String email;
    private String mobNumber;
    private int age;
    private String address;

    //this is parent wrt Ticket
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Ticket> bookedTickets = new ArrayList<>();
}
