package com.movie.service.impl;

import com.movie.bean.FilmCategory;
import com.movie.mapper.FilmCategoryMapper;
import com.movie.service.FilmCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class FilmCategoryServiceImpl implements FilmCategoryService {

    @Resource
    FilmCategoryMapper filmCategoryMapper;
    @Override
    public int totalCount() {
        return filmCategoryMapper.totalCount();
    }

    @Override
    public List<FilmCategory> getFilmCategorys(Map<String,Object> map) {
        return filmCategoryMapper.getFilmCategorys(map);
    }

    @Override
    public int addFilmCategory(FilmCategory filmCategory) {
        return filmCategoryMapper.addFilmCategory(filmCategory);
    }

    @Override
    public int updateFilmCategory(FilmCategory filmCategory) {
        return filmCategoryMapper.updateFilmCategory(filmCategory);
    }

    @Override
    public int deleteFilmCategory(int category_id) {
        return filmCategoryMapper.deleteFilmCategory(category_id);
    }

    @Override
    public FilmCategory getById(int category_id) {
        return filmCategoryMapper.getById(category_id);
    }

    @Override
    public List<FilmCategory> getAllFilmCategorys() {
        return filmCategoryMapper.getAllFilmCategorys();
    }
}
