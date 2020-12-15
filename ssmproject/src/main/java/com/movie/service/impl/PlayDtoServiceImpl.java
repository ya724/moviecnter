package com.movie.service.impl;


import com.movie.bean.Room;
import com.movie.dto.PlayDto;
import com.movie.mapper.PlayDtoMapper;
import com.movie.service.PlayDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PlayDtoServiceImpl implements PlayDtoService {
   @Autowired
    PlayDtoMapper playDtoMapper;
   @Autowired


    @Override
    public int getAllCount() {
        return playDtoMapper.getAllCount();
    }

    @Override
    public List<PlayDto> getPagePlayDto(Map<String, Object> map) {
        return playDtoMapper.getPagePlayDto(map);
    }

    @Override
    public int addPlayDto(PlayDto playDto) {
        return playDtoMapper.addPlayDto(playDto);
    }

    @Override
    public int updateState(Integer play_id, Integer is_delete) {
        return playDtoMapper.updateState(play_id,is_delete);
    }




}
