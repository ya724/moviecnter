package com.movie.mapper;

import com.movie.dto.FilmDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FilmDtoMapper {

    public int getAllCount();
    List<FilmDto> getFilms(Map<String,Object> map);
    FilmDto getFilmDtoById(Integer film_id);

    int updateFilmState(@Param("film_id") Integer film_id,@Param("is_delete") Integer is_delete);
}
