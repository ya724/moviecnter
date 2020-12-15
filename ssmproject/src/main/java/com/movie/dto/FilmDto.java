package com.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmDto {
    private Integer film_id;
    private String film_name;
    private Integer category_id;
    private String film_category;
    private String director;
    private Integer screenwriter_id;
    private String screenwriter_name;
    private Integer performer_id;
    private String performer_name;
    private String film_time;
    private String play_time;
    private String description;
    private String poster_url;
    private Integer is_delete;
}
