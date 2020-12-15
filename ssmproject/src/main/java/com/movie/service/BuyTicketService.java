package com.movie.service;

import com.movie.dto.PlayDto;
import com.movie.dto.TicketDto;

import java.util.List;

public interface BuyTicketService {
    List<PlayDto> buyTicket(Integer film_id);

    List<String> getSelledSeatByPlayId(Integer play_id);

    PlayDto getPlayDtoById(Integer play_id);

    List<TicketDto> getPersonTicketDtos(Integer user_id);

    int getSeatIdBySeatName(String seatName);

    void addTicket(String out_trade_no, Integer play_id, Integer user_id, int seat_id);
}