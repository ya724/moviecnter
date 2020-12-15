package com.movie.web;

import com.movie.bean.FilmCategory;
import com.movie.service.FilmCategoryService;
import com.movie.untils.CommonResult;
import com.movie.untils.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FilmCategoryController {

    @Resource
    FilmCategoryService filmCategoryService;


    @RequestMapping("/filmcategory_paging")
    public String Paging(@RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
                         @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Model model){

        int totalCount = filmCategoryService.totalCount();
        Map<String,Object> map=new HashMap<>();
        map.put("startPage",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        List<FilmCategory> filmCategorys = filmCategoryService.getFilmCategorys(map);
        PageUtil<FilmCategory> filmCategoryPage=new PageUtil<>(pageIndex,pageSize,totalCount,filmCategorys);
        model.addAttribute("fcpage",filmCategoryPage);
        return "movie_type";
    }

    @ResponseBody
    @RequestMapping("/filmcategory_add")
    public CommonResult AddFilmCategory(FilmCategory filmCategory){
        CommonResult commonResult;
        int i = filmCategoryService.addFilmCategory(filmCategory);
        if(i>0){
            commonResult=new CommonResult(200,"添加成功");
        }
        else {
            commonResult=new CommonResult(500,"添加失败");
        }
        return commonResult;
    }

    @ResponseBody
    @RequestMapping("/filmcategory_delete")
    public CommonResult DeleteFilmCategory(int category_id){
        CommonResult commonResult;
        int i = filmCategoryService.deleteFilmCategory(category_id);
        if(i>0){
            commonResult=new CommonResult(200,"删除成功");
        }
        else {
            commonResult=new CommonResult(500,"删除失败");
        }
        return commonResult;
    }

    @ResponseBody
    @RequestMapping("/filmcategory_toupdate")
    public FilmCategory ToupdateFilmCategory(int category_id){
        FilmCategory filmCategory = filmCategoryService.getById(category_id);
        return filmCategory;
    }

    @ResponseBody
    @RequestMapping("/filmcategory_update")
    public CommonResult UpdateFilmCategory(FilmCategory filmCategory){
        CommonResult commonResult;
        int i = filmCategoryService.updateFilmCategory(filmCategory);
        if(i>0){
            commonResult=new CommonResult(200,"更新成功");
        }
        else {
            commonResult=new CommonResult(500,"更新失败");
        }
        return commonResult;
    }
}
