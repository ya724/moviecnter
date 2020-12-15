package com.movie.service;

import com.movie.dto.FilmDto;

import java.util.List;
import java.util.Map;

public interface FilmDtoService {

    int getAllCount();
    List<FilmDto> getFilms(Map<String,Object> map);
    int addFilmDto(FilmDto filmDto);
    FilmDto getFilmDtoById(Integer film_id);

    int updateFilmState(Integer film_id, Integer is_delete);
}
