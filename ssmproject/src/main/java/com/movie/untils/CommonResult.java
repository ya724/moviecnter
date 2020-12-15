package com.movie.untils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult {
    private Integer code;
    private String message;
    private Object data;
    public CommonResult(Integer code,String message){
        this.code=code;
        this.message=message;
    }
}
