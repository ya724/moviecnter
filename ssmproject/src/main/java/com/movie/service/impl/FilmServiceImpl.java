package com.movie.service.impl;

import com.movie.bean.Film;
import com.movie.mapper.FilmMapper;
import com.movie.service.FilmService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class FilmServiceImpl implements FilmService {

    @Resource
    FilmMapper filmMapper;


    @Override
    public List<Film> getLastFilms(int count) {
        return filmMapper.getLastFilms(count);
    }

    @Override
    public List<Film> getFilmsByFilmsCategory(int category_id) {
        return filmMapper.getFilmsByFilmsCategory(category_id);
    }

    @Override
    public int getAllCount(Map<String, Object> map) {
        return filmMapper.getAllCount(map);
    }

    @Override
    public List<Film> getFilms(Map<String, Object> map) {
        return filmMapper.getFilms(map);
    }

    @Override
    public int addFilm(Film film) {
        return filmMapper.addFilm(film);
    }

    @Override
    public int addFilm_type(Integer category_id, Integer film_id) {
        return filmMapper.addFilm_type(category_id,film_id);
    }

    @Override
    public int addScreenWriter_film(Integer film_id, Integer screenwriter_id) {
        return filmMapper.addScreenWriter_film(film_id,screenwriter_id);
    }

    @Override
    public int addStar(Integer film_id, Integer performer_id) {
        return filmMapper.addStar(film_id,performer_id);
    }


}
