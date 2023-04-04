package com.example.Book_My_Show_Application.Service;

import com.example.Book_My_Show_Application.Converter.TicketConvertor;
import com.example.Book_My_Show_Application.Entity.Shows;
import com.example.Book_My_Show_Application.Entity.ShowsSeat;
import com.example.Book_My_Show_Application.Entity.Ticket;
import com.example.Book_My_Show_Application.Entity.User;
import com.example.Book_My_Show_Application.EntryDTOs.TicketEntryDto;
import com.example.Book_My_Show_Application.Repository.ShowRepository;
import com.example.Book_My_Show_Application.Repository.TicketRepository;
import com.example.Book_My_Show_Application.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;

    //@Autowired
    //JavaMailSender

    public String bookedTicket(TicketEntryDto ticketEntryDto) throws Exception{
        //convert dto to entity
        Ticket ticket = TicketConvertor.convertDtoToEntity(ticketEntryDto);

        int showId = ticketEntryDto.getShowId();

        //validation - Check requested seats are available or not?
        boolean isValidRequest = checkValidityOfRequestedSeat(ticketEntryDto);
        if(!isValidRequest){
            throw new Exception("Requested seats are not available");
        }

        //we assume that requested seats are valid

        //calculate the total amount
        Shows showEntity = showRepository.findById(ticketEntryDto.getShowId()).get();
        List<String>requestedSeats = ticketEntryDto.getRequestedSeat();
        int totalAmount = calculateTotalAmount(showEntity, requestedSeats);

        ticket.setTotalPrice(totalAmount);

        //setting the other attribute
        ticket.setMovieName(showEntity.getMovie().getMovieName());
        ticket.setTheaterName(showEntity.getTheaterEntity().getTheaterName());
        ticket.setShowDate(showEntity.getShowDate());
        ticket.setShowTime(showEntity.getShowTime());

        //set the string bookedSeat
        String allottedSeat = getAllottedSeatsFromShowSeats(requestedSeats);
        ticket.setBookedSeat(allottedSeat);

        //setting the foreign key attributes
        User user = userRepository.findById(ticketEntryDto.getUserId()).get();
        ticket.setUser(user);
        ticket.setShows(showEntity);

        //save the parents
        ticket = ticketRepository.save(ticket);

        List<Ticket> ticketList = showEntity.getListOfBookedTickets();
        ticketList.add(ticket);
        showEntity.setListOfBookedTickets(ticketList);
        showRepository.save(showEntity);

        List<Ticket> ticketList1 = user.getBookedTickets();
        ticketList1.add(ticket);
        user.setBookedTickets(ticketList1);
        userRepository.save(user);

        return "Ticket Booked Successfully";
    }

    private boolean checkValidityOfRequestedSeat(TicketEntryDto ticketEntryDto)throws Exception{
        int showId = ticketEntryDto.getShowId();
        List<String>requestedSeats = ticketEntryDto.getRequestedSeat();
        Shows showEntity = showRepository.findById(showId).get();
        List<ShowsSeat> listOfShowSeat = showEntity.getListOfShowSeats();

        for(ShowsSeat showsSeat : listOfShowSeat){
            String seatNo = showsSeat.getSeatNumber();
            if(requestedSeats.contains(seatNo)){
                if(showsSeat.isBooked())
                    return false;
            }
        }

       return true;
    }

    private String getAllottedSeatsFromShowSeats(List<String> requestedSeat){
        String result = "";

        for(String seat : requestedSeat){
            result += seat + ", ";
        }
        return result;
    }

    private int calculateTotalAmount(Shows shows, List<String> requestedSeat){
        int totalAmount=0;
        List<ShowsSeat> listOfShowSeat = shows.getListOfShowSeats();
        for(ShowsSeat showsSeat : listOfShowSeat){
            if(requestedSeat.contains(showsSeat.getSeatNumber())) {
                totalAmount += showsSeat.getPrice();
                showsSeat.setBooked(true);
                showsSeat.setBookedAt(new Date());
            }
        }
        return totalAmount;
    }
}
