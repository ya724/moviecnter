package com.movie.service;


import com.movie.bean.Room;
import com.movie.dto.PlayDto;

import java.util.List;
import java.util.Map;

public interface PlayDtoService {
    public int getAllCount();
    List<PlayDto> getPagePlayDto(Map<String,Object> map);


    int addPlayDto(PlayDto playDto);

    int updateState(Integer play_id, Integer is_delete);

}
