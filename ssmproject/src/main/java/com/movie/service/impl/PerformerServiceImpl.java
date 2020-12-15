package com.movie.service.impl;

import com.movie.bean.Performer;
import com.movie.mapper.PerformerMapper;
import com.movie.service.PerformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PerformerServiceImpl implements PerformerService {

    @Autowired
    PerformerMapper performerMapper;

    @Override
    public int totalCount() {
        return performerMapper.totalCount();
    }

    @Override
    public List<Performer> getPerformers(Map<String, Object> map) {
        return performerMapper.getPerformers(map);
    }

    @Override
    public int addPerformer(Performer performer) {
        return performerMapper.addPerformer(performer);
    }

    @Override
    public int updatePerformer(Performer performer) {
        return performerMapper.updatePerformer(performer);
    }

    @Override
    public int deletePerformer(Integer performer_id) {
        return performerMapper.deletePerformer(performer_id);
    }

    @Override
    public Performer getById(int performer_id) {
        return performerMapper.getById(performer_id);
    }

    @Override
    public List<Performer> getAllPerformers() {
        return performerMapper.getAllPerformers();
    }
}
