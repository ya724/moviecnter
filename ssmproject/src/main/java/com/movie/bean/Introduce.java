package com.movie.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Introduce {
    private Integer introduce_id;
    private String introduce_address;
    private String introduce_tel;
    private String introduce_qq;
    private String introduce_weixin;
    private String introduce_content;
    private String introduce_map;
}
