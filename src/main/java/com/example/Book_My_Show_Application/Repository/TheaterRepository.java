package com.example.Book_My_Show_Application.Repository;

import com.example.Book_My_Show_Application.Entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer> {
//    Theater findByName(String name);
}
