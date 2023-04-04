package com.example.Book_My_Show_Application.Service;

import com.example.Book_My_Show_Application.Converter.UserConverter;
import com.example.Book_My_Show_Application.Entity.User;
import com.example.Book_My_Show_Application.EntryDTOs.UserEntryDto;
import com.example.Book_My_Show_Application.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public String addUser(UserEntryDto userEntryDto) throws SQLException, Exception{

//        if(userEntryDto.getEmail()!=null){
//            throw new Exception("Email already exist");
//        }

        if(userRepository.findByEmail(userEntryDto.getEmail())!=null){
            throw new Exception("Email already exist");
        }
        User user = UserConverter.convertDtoToEntity(userEntryDto);
        userRepository.save(user);
        return "User Added Successfully";
    }
}
