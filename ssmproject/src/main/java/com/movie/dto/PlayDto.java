package com.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayDto {
    private Integer play_id;
    private String play_time;
    private Integer film_id;
    private String film_name;
    private Integer room_id;
    private String room_name;
    private double money;
    private String create_time;
    private String update_time;
    private Integer is_delete;

}
