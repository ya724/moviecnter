package com.movie.service.impl;

import com.movie.bean.Film;
import com.movie.dto.FilmDto;
import com.movie.mapper.FilmDtoMapper;
import com.movie.service.FilmDtoService;
import com.movie.service.FilmService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class FilmDtoServiceImpl implements FilmDtoService {

    @Resource
    FilmDtoMapper filmDtoMapper;
    @Resource
    FilmService filmService;

    @Override
    public int getAllCount() {
        return filmDtoMapper.getAllCount();
    }

    @Override
    public List<FilmDto> getFilms(Map<String,Object> map) {
        return filmDtoMapper.getFilms(map);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addFilmDto(FilmDto filmDto) {
        Film film=new Film(null,filmDto.getFilm_name(),filmDto.getFilm_time(),filmDto.getDirector(),
                filmDto.getPlay_time(),filmDto.getPoster_url(),filmDto.getDescription(),1);
        int count1 = filmService.addFilm(film);
        int count2 = filmService.addFilm_type(filmDto.getCategory_id(), film.getFilm_id());
        int count3 = filmService.addScreenWriter_film( film.getFilm_id(), filmDto.getScreenwriter_id());
        int count4 = filmService.addStar( film.getFilm_id(), filmDto.getPerformer_id());
        return count1+count2+count3+count4;
    }

    @Override
    public FilmDto getFilmDtoById(Integer film_id) {
        return filmDtoMapper.getFilmDtoById(film_id);
    }

    @Override
    public int updateFilmState(Integer film_id, Integer is_delete) {
        return filmDtoMapper.updateFilmState(film_id,is_delete);
    }


}
