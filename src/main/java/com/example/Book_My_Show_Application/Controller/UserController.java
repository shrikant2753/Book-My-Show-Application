package com.example.Book_My_Show_Application.Controller;

import com.example.Book_My_Show_Application.Entity.Ticket;
import com.example.Book_My_Show_Application.EntryDTOs.UserEntryDto;
import com.example.Book_My_Show_Application.ResponseDTOs.TicketsBookedByUser;
import com.example.Book_My_Show_Application.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserEntryDto userEntryDto){
        try{
            String response = userService.addUser(userEntryDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch(SQLException e){
            String response = e.getMessage();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            String response = e.getMessage();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/ticketBookedByUser")
    public List<TicketsBookedByUser> getTicketBookedByUser(@RequestParam int userId){
        return userService.getTicketBookedByUser(userId);
    }
}
