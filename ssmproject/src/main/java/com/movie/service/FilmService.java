package com.movie.service;

import com.movie.bean.Film;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FilmService {

    List<Film> getLastFilms(int count);

    List<Film> getFilmsByFilmsCategory(int category_id);

    int getAllCount(Map<String,Object> map);

    List<Film> getFilms(Map<String,Object> map);

    int addFilm(Film film);

    int addFilm_type( Integer category_id, Integer film_id);

    int addScreenWriter_film( Integer film_id, Integer screenwriter_id);

    int addStar( Integer film_id, Integer performer_id);


}
