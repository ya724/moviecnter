package com.movie.mapper;

import com.movie.dto.PlayDto;
import com.movie.dto.TicketDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BuyTicketMapper {
    List<PlayDto> buyTicket(Integer film_id);

   List<String> getSelledSeatByPlayId(Integer play_id);

    PlayDto getPlayDtoById(Integer play_id);

    List<TicketDto>  getPersonTicketDtos(Integer user_id);

    int getSeatIdBySeatName( String seatName);

    void addTicket(@Param("order_id") String out_trade_no,@Param("play_id") Integer play_id, @Param("user_id") Integer user_id,@Param("seat_id") int seat_id);
}
