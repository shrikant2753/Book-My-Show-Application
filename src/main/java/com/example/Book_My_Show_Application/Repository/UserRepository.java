package com.example.Book_My_Show_Application.Repository;


import com.example.Book_My_Show_Application.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
