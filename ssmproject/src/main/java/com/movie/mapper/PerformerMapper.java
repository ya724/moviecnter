package com.movie.mapper;

import com.movie.bean.Performer;
import com.movie.bean.Performer;

import java.util.List;
import java.util.Map;

public interface PerformerMapper {
    int totalCount();
    List<Performer> getPerformers(Map<String,Object> map);
    int addPerformer(Performer performer);
    int updatePerformer(Performer performer);
    int deletePerformer(Integer performer_id);
    Performer getById(int performer_id);
    List<Performer> getAllPerformers();
}
