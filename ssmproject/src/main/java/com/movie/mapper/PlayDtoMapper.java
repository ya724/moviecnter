package com.movie.mapper;


import com.movie.bean.Room;
import com.movie.dto.PlayDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PlayDtoMapper {
    public int getAllCount();
    List<PlayDto> getPagePlayDto(Map<String,Object> map);


    int addPlayDto(PlayDto playDto);

    int updateState(@Param("play_id") Integer play_id,@Param("is_delete") Integer is_delete);


}
