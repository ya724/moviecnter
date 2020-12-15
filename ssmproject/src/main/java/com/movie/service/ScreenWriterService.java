package com.movie.service;

import com.movie.bean.FilmCategory;
import com.movie.bean.ScreenWriter;

import java.util.List;
import java.util.Map;

public interface ScreenWriterService {
    int totalCount();
    List<ScreenWriter> getScreenWriters(Map<String,Object> map);
    int addScreenWriter(ScreenWriter screenWriter);
    int updateScreenWriter(ScreenWriter screenWriter);
    int deleteScreenWriter(Integer screenwriter);
    ScreenWriter getById(int screenwriter_id);
    List<ScreenWriter> getAllSWriter();
}
