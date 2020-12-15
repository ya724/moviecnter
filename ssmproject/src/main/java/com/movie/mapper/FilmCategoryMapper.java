package com.movie.mapper;

import com.movie.bean.FilmCategory;

import java.util.List;
import java.util.Map;

public interface FilmCategoryMapper {

    int totalCount();
    List<FilmCategory> getFilmCategorys(Map<String,Object> map);
    int addFilmCategory(FilmCategory filmCategory);
    int updateFilmCategory(FilmCategory filmCategory);
    int deleteFilmCategory(int category_id);
    FilmCategory getById(int category_id);
    List<FilmCategory> getAllFilmCategorys();
}
