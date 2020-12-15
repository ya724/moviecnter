package com.movie.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {
    private Integer film_id;
    private String film_name;
    private String film_time;
    private String director;
    private String play_time;
    private String poster_url;
    private String description;
    private Integer is_delete;
}
