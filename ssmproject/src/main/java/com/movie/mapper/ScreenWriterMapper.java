package com.movie.mapper;

import com.movie.bean.FilmCategory;
import com.movie.bean.ScreenWriter;

import java.util.List;
import java.util.Map;

public interface ScreenWriterMapper {
    int totalCount();
    List<ScreenWriter> getScreenWriters(Map<String,Object> map);
    int addScreenWriter(ScreenWriter screenWriter);
    int updateScreenWriter(ScreenWriter screenWriter);
    int deleteScreenWriter(Integer screenwriter_id);
    ScreenWriter getById(int screenwriter_id);
    List<ScreenWriter> getAllSWriter();
}
