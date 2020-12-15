package com.movie.mapper;

import com.movie.bean.Film;
import com.movie.dto.FilmDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FilmMapper {
    List<Film> getLastFilms(int count);

    List<Film> getFilmsByFilmsCategory(int category_id);

    int getAllCount(Map<String,Object> map);

    List<Film> getFilms(Map<String,Object> map);

    int addFilm(Film film);

    int addFilm_type(@Param("category_id") Integer category_id,@Param("film_id") Integer film_id);

    int addScreenWriter_film(@Param("film_id") Integer film_id,@Param("screenwriter_id") Integer screenwriter_id);

    int addStar(@Param("film_id") Integer film_id,@Param("performer_id") Integer performer_id);


}
