package com.movie.untils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageUtil<T> {
    private int pageIndex;//当前页码
    private int pageSize; //页面大小
    private int totalcount; //总条数
    private int pageCount; //总页数
    private List<T> records; //分页的数据

    private int numberStart; //开始序号
    private List<Integer> numbers=new ArrayList<>();//序号
    private int numberEnd; //结束序号


    public PageUtil(int pageIndex, int pageSize, int totalcount, List<T> records) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalcount = totalcount;
        this.records = records;
        //人工计算总页数
        this.pageCount=(this.totalcount%this.pageSize==0)?(this.totalcount/this.pageSize):(this.totalcount/this.pageSize+1);

        //给序号赋值
        if(this.pageCount<=10){
            this.numberStart=1;
            this.numberEnd=this.pageCount;
        }else{
            this.numberStart=this.pageIndex-4;
            this.numberEnd=this.pageIndex+5;
            if(this.numberStart<1){
                this.numberStart=1;
                this.numberEnd=10;
            }
            if(this.numberEnd>this.pageCount){
                this.numberStart=this.pageCount-9;
                this.numberEnd=this.pageCount;
            }
        }
        for (int i = numberStart; i <=numberEnd ; i++) {
            numbers.add(i);
        }
    }



}


