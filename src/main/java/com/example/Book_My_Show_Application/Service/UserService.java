package com.example.Book_My_Show_Application.Service;

import com.example.Book_My_Show_Application.Converter.UserConverter;
import com.example.Book_My_Show_Application.Converter.UserTicketConvertor;
import com.example.Book_My_Show_Application.Entity.Theater;
import com.example.Book_My_Show_Application.Entity.Ticket;
import com.example.Book_My_Show_Application.Entity.User;
import com.example.Book_My_Show_Application.EntryDTOs.UserEntryDto;
import com.example.Book_My_Show_Application.Repository.TicketRepository;
import com.example.Book_My_Show_Application.Repository.UserRepository;
import com.example.Book_My_Show_Application.ResponseDTOs.TicketsBookedByUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TicketRepository ticketRepository;

    public String addUser(UserEntryDto userEntryDto) throws SQLException, Exception{

        if(userRepository.findByEmail(userEntryDto.getEmail())!=null){
            throw new Exception("Email already exist");
        }
        User user = UserConverter.convertDtoToEntity(userEntryDto);
        userRepository.save(user);
        return "User Added Successfully";
    }

    public List<TicketsBookedByUser> getTicketBookedByUser(int userId){
        List<TicketsBookedByUser> ticketBookedByUser = new ArrayList<>();
        List<Ticket>ticketList = ticketRepository.findAll();

        for(Ticket ticket : ticketList){
            if(ticket.getUser().getId()==userId){
                ticketBookedByUser.add(UserTicketConvertor.userTicketConvertor(ticket));
            }
        }
        return ticketBookedByUser;
    }
}
