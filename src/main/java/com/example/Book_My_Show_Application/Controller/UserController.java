package com.example.Book_My_Show_Application.Controller;

import com.example.Book_My_Show_Application.EntryDTOs.UserEntryDto;
import com.example.Book_My_Show_Application.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

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
}
