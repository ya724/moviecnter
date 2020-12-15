package com.movie.service;

import com.movie.bean.Performer;

import java.util.List;
import java.util.Map;

public interface PerformerService {
    int totalCount();
    List<Performer> getPerformers(Map<String,Object> map);
    int addPerformer(Performer performer);
    int updatePerformer(Performer performer);
    int deletePerformer(Integer performer_id);
    Performer getById(int performer_id);
    List<Performer> getAllPerformers();
}
