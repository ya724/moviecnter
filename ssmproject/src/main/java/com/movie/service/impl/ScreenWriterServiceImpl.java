package com.movie.service.impl;

import com.movie.bean.FilmCategory;
import com.movie.bean.ScreenWriter;
import com.movie.mapper.ScreenWriterMapper;
import com.movie.service.ScreenWriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ScreenWriterServiceImpl implements ScreenWriterService {

    @Autowired
    ScreenWriterMapper screenWriterMapper;

    @Override
    public int totalCount() {
        return screenWriterMapper.totalCount();
    }

    @Override
    public List<ScreenWriter> getScreenWriters(Map<String, Object> map) {
        return screenWriterMapper.getScreenWriters(map);
    }

    @Override
    public int addScreenWriter(ScreenWriter screenWriter) {
        return screenWriterMapper.addScreenWriter(screenWriter);
    }

    @Override
    public int updateScreenWriter(ScreenWriter screenWriter) {
        return screenWriterMapper.updateScreenWriter(screenWriter);
    }

    @Override
    public int deleteScreenWriter(Integer screenwriter_id) {
        return screenWriterMapper.deleteScreenWriter(screenwriter_id);
    }

    @Override
    public ScreenWriter getById(int screenwriter_id) {
        return screenWriterMapper.getById(screenwriter_id);
    }

    @Override
    public List<ScreenWriter> getAllSWriter() {
        return screenWriterMapper.getAllSWriter();
    }
}
