package com.movie.service.impl;

import com.movie.dto.PlayDto;
import com.movie.dto.TicketDto;
import com.movie.mapper.BuyTicketMapper;
import com.movie.service.BuyTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyTicketServiceImpl implements BuyTicketService {

    @Autowired
    BuyTicketMapper buyTicketMapper;

    @Override
    public List<PlayDto> buyTicket(Integer film_id) {
        return buyTicketMapper.buyTicket(film_id);
    }

    @Override
    public List<String> getSelledSeatByPlayId(Integer play_id) {
        return buyTicketMapper.getSelledSeatByPlayId(play_id);
    }

    @Override
    public PlayDto getPlayDtoById(Integer play_id) {
        return buyTicketMapper.getPlayDtoById(play_id);
    }

    @Override
    public List<TicketDto> getPersonTicketDtos(Integer user_id) {
        return buyTicketMapper.getPersonTicketDtos(user_id);
    }


    @Override
    public int getSeatIdBySeatName(String seatName) {
        return buyTicketMapper.getSeatIdBySeatName(seatName);
    }

    @Override
    public void addTicket(String out_trade_no, Integer play_id, Integer user_id, int seat_id) {
        buyTicketMapper.addTicket(out_trade_no,play_id,user_id,seat_id);
    }


}
