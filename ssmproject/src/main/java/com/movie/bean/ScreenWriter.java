package com.movie.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScreenWriter {
    private Integer screenwriter_id;
    private String screenwriter_name;
    private int is_delete;
}
